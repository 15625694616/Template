package com.template.demos.admin.dao;


import com.template.demos.admin.entity.SysRoleMenuEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色与菜单对应关系
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年9月18日 上午9:33:46
 */
@Component
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> queryMenuIdList(Long roleId);
}
