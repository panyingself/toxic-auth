/*
 * Copyright (c) 18-12-2 下午9:43 toxic
 */

package com.toxic.auth.shiro;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.toxic.auth.business.UserInfoBusiness;
import com.toxic.auth.model.PermissionInfo;
import com.toxic.auth.model.RoleInfo;
import com.toxic.auth.model.UserInfo;
import com.toxic.auth.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/12/2 21:43.
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserInfoBusiness userInfoBusiness;
    /**
      * Method: 
      * Description: 获取授权信息
      * Author: py
      * Data: 2018/12/2 21:45
       * @param principalCollection
      * @return org.apache.shiro.authz.AuthorizationInfo
      */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        System.out.println(JSON.toJSONString(principalCollection.getPrimaryPrincipal()));
        UserInfo userInfo  = (UserInfo)principalCollection.getPrimaryPrincipal();
        UserLoadInfo userLoadInfo = userInfoBusiness.queryRoleByUser(userInfo);
        for(RoleInfo role:userLoadInfo.getRoleInfoList()){
            authorizationInfo.addRole(role.getRoleName());
            for(PermissionInfo p:userLoadInfo.getPermissionInfoList()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }
    /**
      * Method: 
      * Description: 登录认证
      * Author: py
      * Data: 2018/12/2 21:45
       * @param authenticationToken
      * @return org.apache.shiro.authc.AuthenticationInfo
      */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //step1 获取登录信息
        String userName = authenticationToken.getPrincipal().toString();
        //step2 获取用户真正的密码
        UserInfo userInfo = userInfoBusiness.queryUserPwd(userName);
        String password = userInfo.getPassword();
        if( null != password ){
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    userInfo,//认证通过后，存放在session,一般存放user对象
                    password, //用户数据库中的密码
                    getName()//返回Realm名
            );
            return authenticationInfo;
        }
        return null;
    }
}
