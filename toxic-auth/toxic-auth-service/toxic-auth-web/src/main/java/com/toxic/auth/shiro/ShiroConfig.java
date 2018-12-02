/*
 * Copyright (c) 18-12-2 下午9:43 toxic
 */

package com.toxic.auth.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/12/2 21:43.
 */
@Configuration
public class ShiroConfig {
    /**
      * Method: 
      * Description: 自定义realm 
      * Author: py
      * Data: 2018/12/2 22:02
       * @param
      * @return com.toxic.auth.shiro.MyShiroRealm
      */
    @Bean(name = "myShiroRealm")
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //设置realm
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 配置登录的url和登录成功的url
        shiroFilterFactoryBean.setLoginUrl("/auth/login");
        shiroFilterFactoryBean.setSuccessUrl("/home");
        // 配置未授权跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/errorPage/403");
        // 配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/css/**", "anon"); // 表示可以匿名访问
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/imgs/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/auth/**", "anon");
        filterChainDefinitionMap.put("/errorPage/**", "anon");
        filterChainDefinitionMap.put("/demo/**", "anon");
        filterChainDefinitionMap.put("/swagger-*/**", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");// 表示admin角色权限才可以访问，多个加引号用逗号相隔
//        filterChainDefinitionMap.put("/permission/**", "roles[admin]");// 表示admin权限才可以访问，多个加引号用逗号相隔
        filterChainDefinitionMap.put("/permission/**", "perms[admin]");// 表示admin菜单权限才可以访问，多个加引号用逗号相隔
        filterChainDefinitionMap.put("/*", "authc");// 表示需要认证才可以访问
        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/*.*", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
