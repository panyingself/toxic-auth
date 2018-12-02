/*
 * Copyright (c) 18-12-3 上午12:38 toxic
 */

/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */

package com.toxic.auth.model;

import java.io.Serializable;

public class RolePermission implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private Integer id;
	/** 角色id */
	private String roleId;
	/** 权限id */
	private String permissionId;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	
	
	
	
	public String getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(String value) {
		this.roleId = value;
	}
	
	
	
	
	
	public String getPermissionId() {
		return this.permissionId;
	}
	
	public void setPermissionId(String value) {
		this.permissionId = value;
	}
	
	
	
	
	

}

