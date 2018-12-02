/*
 * Copyright (c) 18-12-3 上午1:00 toxic
 */

package com.toxic.auth.shiro;

import com.toxic.auth.model.PermissionInfo;
import com.toxic.auth.model.RoleInfo;

import java.util.List;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/12/3 1:00.
 */
public class UserLoadInfo {
    private List<RoleInfo> roleInfoList;
    private List<PermissionInfo> permissionInfoList;

    public List<RoleInfo> getRoleInfoList() {
        return roleInfoList;
    }

    public void setRoleInfoList(List<RoleInfo> roleInfoList) {
        this.roleInfoList = roleInfoList;
    }

    public List<PermissionInfo> getPermissionInfoList() {
        return permissionInfoList;
    }

    public void setPermissionInfoList(List<PermissionInfo> permissionInfoList) {
        this.permissionInfoList = permissionInfoList;
    }
}
