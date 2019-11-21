package com.template.demos.shiro;


import com.template.demos.shiro.AuthRealm;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ShiroConfiguration {
    private static final Logger log = LoggerFactory.getLogger(ShiroConfiguration.class);

    /**
     * 注入Realm
     * @return MyRealm
     */
    @Bean(name = "myRealm")
    public AuthRealm myAuthRealm() {
        AuthRealm myRealm = new AuthRealm();
        myRealm.setCacheManager(new MemoryConstrainedCacheManager());
        log.info("myRealm注册完成");
        return myRealm;
    }
/*
    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect(){

        return new ShiroDialect();

    }*/

    // 创建 SecurityManager 对象
    //加上注解 @Qualifier 不然service会注入失败
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("myRealm") AuthRealm myShiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm);
        return securityManager;
    }

    // Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new LinkedHashMap<>();
        // 退出登录
        map.put("/logout", "logout");
        // 对所有用户认证


        map.put("/imgs/**","anon");
        map.put("/MP_verify_9z5R9r5F0ddgVNBc.txt","anon");
        map.put("/api/**","anon");
        map.put("/admin/**","anon");
        map.put("/api/**","noSessionCreation");
        map.put("/doc.html","anon");
        map.put("/login","anon");
        map.put("/captcha.jpg","anon");
        // 对登录跳转接口进行释放
        map.put("/sys/login", "anon");
        map.put("/err", "anon");
        map.put("/static/*","anon");
        map.put("/js/*","anon");
        map.put("/css/*","anon");
        map.put("/img/*","anon");
        map.put("/libs/*","anon");
        map.put("/plugins/*","anon");
        map.put("/audio/*","anon");

        //
        map.put("/webjars/**","anon");
        map.put("/swagger-resources","anon");
        map.put("/v2/api-docs","anon");
        map.put("/v2/api-docs-ext","anon");
        map.put("/v2/api-docs-ext","anon");

        //authc
        map.put("/**", "authc");
        // 登录
        // 注意：这里配置的 /login 是指到 @RequestMapping(value="/login")中的 /login
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/err");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    // 加入注解的使用，不加这个，注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    // 跟上面的注解配置搭配使用，有时候加了上面的配置后注解不生效，需要加入下面的配置
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator app = new DefaultAdvisorAutoProxyCreator();
        app.setProxyTargetClass(true);
        return app;
    }



}

