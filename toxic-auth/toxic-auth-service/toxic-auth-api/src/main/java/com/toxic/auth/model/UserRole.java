/*
 * Copyright (c) 18-12-2 下午11:45 toxic
 */

/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */

package com.toxic.auth.model;

import java.io.Serializable;

public class UserRole implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private Integer id;
	/** 用户id */
	private String userId;
	/** 角色id */
	private String roleId;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	
	
	
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String value) {
		this.userId = value;
	}
	
	
	
	
	
	public String getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(String value) {
		this.roleId = value;
	}
	
	
	
	
	

}

