package com.template.demos.admin.controller;


import com.template.demos.admin.entity.SysUserEntity;
import com.template.demos.utils.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUserEntity getUser() {
        return ShiroUtils.getUserEntity();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }

    protected Long getDeptId() {
        return getUser().getDeptId();
    }
}
