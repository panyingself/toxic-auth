/*
 * Copyright (c) 18-12-2 下午11:41 toxic
 */

/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */

package com.toxic.auth.model;

import java.io.Serializable;

public class RoleInfo implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id 主键 */
	private Integer id;
	/** 角色名称 */
	private String roleName;
	/** 角色id */
	private String roleId;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	
	
	
	
	public String getRoleName() {
		return this.roleName;
	}
	
	public void setRoleName(String value) {
		this.roleName = value;
	}
	
	
	
	
	
	public String getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(String value) {
		this.roleId = value;
	}
	
	
	
	
	

}

