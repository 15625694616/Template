package com.template.demos.admin.dao;


import com.template.demos.admin.entity.SysUserRoleEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户与角色对应关系
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年9月18日 上午9:34:46
 */
@Component
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);
}
