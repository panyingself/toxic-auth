/*
 * Copyright (c) 18-12-2 下午11:50 toxic
 */

package com.toxic.auth.business;

import com.toxic.auth.model.*;
import com.toxic.auth.model.query.UserRoleQuery;
import com.toxic.auth.service.*;
import com.toxic.auth.shiro.UserLoadInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/12/2 23:50.
 */
@Component
public class UserInfoBusiness {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoleInfoService roleInfoService;
    @Resource
    private PermissionInfoService permissionInfoService;
    @Resource
    private RolePermissionService rolePermissionService;
    /**
      * Method: 
      * Description: 获取用户信息
      * Author: py
      * Data: 2018/12/2 23:53
       * @param userName
      * @return java.lang.String
      */
    public UserInfo queryUserPwd(String userName){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo = userInfoService.selectOne(userInfo);
        if( null != userInfo){
            return userInfo;
        }
        return null;
    }
    /**
      * Method: 
      * Description: 获取用户权限信息
      * Author: py
      * Data: 2018/12/3 0:06
       * @param userInfo
      * @return com.toxic.auth.model.RoleInfo
      */
    public UserLoadInfo queryRoleByUser(UserInfo userInfo){
        UserLoadInfo userLoadInfo = new UserLoadInfo();
        List<RoleInfo> roleInfoList = new ArrayList<>();
        //step1 查询用户角色关联信息
        UserRoleQuery userRoleQuery = new UserRoleQuery();
        userRoleQuery.setUserId(userInfo.getUserId());
        List<UserRole> userRoleList = userRoleService.queryList(userRoleQuery);
        //step2 查询角色信息
        if( null != userRoleList && userRoleList.size() > 0 ){
            roleInfoList = userRoleList.stream()
                    .filter( x -> null != x.getRoleId())
                    .map( x -> {
                        return getRoleInfo(x.getRoleId());
                    })
                    .collect(Collectors.toList());
        }
        userLoadInfo.setRoleInfoList(roleInfoList);
        //根据用户角色信息获取权限
        List<PermissionInfo> permissionInfoList = new ArrayList<>();
        if( null != roleInfoList && roleInfoList.size() > 0 ){
            //查询角色权限关联信息
            List<RolePermission> rolePermissionList = new ArrayList<>();
            for ( RoleInfo roleInfo : roleInfoList ){
                rolePermissionList.addAll(getRolePermission(roleInfo.getRoleId()));
            }
            //查询具体权限信息
            if( null != rolePermissionList && rolePermissionList.size() > 0 ){
                for ( RolePermission rp : rolePermissionList){
                     permissionInfoList = getPermissionInfo(rp.getPermissionId());
                }
            }
        }
        userLoadInfo.setPermissionInfoList(permissionInfoList);
        return userLoadInfo;
    }
    /**
      * Method: 
      * Description: 获取角色信息
      * Author: py
      * Data: 2018/12/3 0:15
       * @param roleId
      * @return com.toxic.auth.model.RoleInfo
      */
    private RoleInfo getRoleInfo(String roleId){
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleId(roleId);
        roleInfo = roleInfoService.selectOne(roleInfo);
        return roleInfo;
    }
    /**
      * Method: 
      * Description: 获取角色权限关联信息
      * Author: py
      * Data: 2018/12/3 0:50
       * @param roleId
      * @return com.toxic.auth.model.RolePermission
      */
    private List<RolePermission> getRolePermission(String roleId){
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(roleId);
        List<RolePermission> rolePermissionList = rolePermissionService.selectList(rolePermission);
        return rolePermissionList;

    }
    /**
      * Method: 
      * Description: 获取权限信息
      * Author: py
      * Data: 2018/12/3 0:15
       * @param roleId
      * @return com.toxic.auth.model.permissionInfo
      */
    private List<PermissionInfo> getPermissionInfo(String permissionId){
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setResourceId(permissionId);
        List<PermissionInfo> permissionInfoList = permissionInfoService.selectList(permissionInfo);
        return permissionInfoList;
    }
}
