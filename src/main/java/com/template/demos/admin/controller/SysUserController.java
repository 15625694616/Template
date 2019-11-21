package com.template.demos.admin.controller;


import com.template.demos.admin.entity.SysUserEntity;
import com.template.demos.admin.service.SysUserRoleService;
import com.template.demos.admin.service.SysUserService;
import com.template.demos.utils.*;
import com.template.demos.utils.annotation.SysLog;
import com.template.demos.utils.validator.ValidatorUtils;
import com.template.demos.utils.validator.group.AddGroup;
import com.template.demos.utils.validator.group.UpdateGroup;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    public R list(@RequestParam Map<String, Object> params) {
        //只有超级管理员，才能查看所有管理员列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            params.put("createUserId", getUserId());
        }

        //查询列表数据
        Query query = new Query(params);
        List<SysUserEntity> userList = sysUserService.queryList(query);
        int total = sysUserService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 获取登录的用户信息
     */
   /* @RequestMapping("/info")
    public R info() {
        return R.ok().put("user", getUser());
    }*/

    /**
     * 修改登录用户密码
     */
    @SysLog("修改密码")
    @ApiOperation(value = "修改密码", response = Map.class)
    @RequestMapping("/password")
    public R password(String password, String newPassword) {
//        if(ResourceUtil.getConfigByName("sys.demos").equals("1")){
//            throw new RRException("演示环境无法修改密码！");
//        }
        if (newPassword==null){
            throw new RRException("新密码不为能空");
        }

        //sha256加密
        password = new Sha256Hash(password).toHex();
        //sha256加密
        newPassword = new Sha256Hash(newPassword).toHex();

        //更新密码
        int count = sysUserService.updatePassword(getUserId(), password, newPassword);
        if (count == 0) {
            return R.error("原密码不正确");
        }

        //退出
        ShiroUtils.logout();

        return R.ok();
    }

    /**
     * 用户信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:user:info")
    public R info(@PathVariable("userId") Long userId) {
        SysUserEntity user = sysUserService.queryObject(userId);

        //获取用户所属的角色列表
        List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
        user.setRoleIdList(roleIdList);

        return R.ok().put("user", user);
    }

    /**
     * 保存用户
     */
    @SysLog("保存用户")
    @RequestMapping("/save")
    @RequiresPermissions("sys:user:save")
    public R save(@RequestBody SysUserEntity user) {
        ValidatorUtils.validateEntity(user, AddGroup.class);

        user.setCreateUserId(getUserId());
        sysUserService.save(user);

        return R.ok();
    }

    /**
     * 修改用户
     */
    @SysLog("修改用户")
    @RequestMapping("/update")
    @RequiresPermissions("sys:user:update")
    public R update(@RequestBody SysUserEntity user) {
        ValidatorUtils.validateEntity(user, UpdateGroup.class);

        user.setCreateUserId(getUserId());
        sysUserService.update(user);

        return R.ok();
    }

    /**
     * 删除用户
     */
    @SysLog("删除用户")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public R delete(@RequestBody Long[] userIds) {
        if (ArrayUtils.contains(userIds, 1L)) {
            return R.error("系统管理员不能删除");
        }

        if (ArrayUtils.contains(userIds, getUserId())) {
            return R.error("当前用户不能删除");
        }

        sysUserService.deleteBatch(userIds);

        return R.ok();
    }

//    @RequestMapping("/getToKen")
//    public String getToken() {
//        try {
//
//            Map<String, String> map = new LinkedHashMap<String, String>();
//            map.put("grant_type", grant_type);
//            map.put("appid", "wx0c8bbe9ee5e7dd6b");
//            map.put("secret", "150356fff3841d435725ebb94d4b5cb2");
//
//            String rt = HttpUtils.sendGet(TOKEN_URL, map);
//
//            System.out.println(rt);
//            JSONObject json = JSONObject.parseObject(rt);
//
//            if (json.getString("access_token") != null || json.getString("access_token") != "") {
//                return json.getString("access_token");
//            } else {
//                return null;
//            }
//        } catch (Exception e) {
//            log.error("# 获取 token 出错... e:" + e);
//            e.printStackTrace();
//            return null;
//        }
//
//    }
}
