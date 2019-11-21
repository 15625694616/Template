package com.template.demos.admin.dao;


import com.template.demos.admin.entity.SysDeptEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 部门管理
 *
 */
@Component
public interface SysDeptDao extends BaseDao<SysDeptEntity> {

    /**
     * 查询子部门ID列表
     *
     * @param parentId 上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);


    /**
     * 根据实体条件查询
     *
     * @return
     */
//    List<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto);
}
