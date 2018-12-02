/*
 * Copyright (c) 18-12-2 下午11:08 toxic
 */
package com.toxic.auth.model;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private Long id;
	/** 用户id */
	private String userId;
	/** 用户名 */
	private String userName;
	/** 密码 */
	private String password;
	/** 性别 0男，1女 */
	private Integer sex;
	/** 年龄 */
	private Integer age;
	/** 创建时间 */
	private java.util.Date createDateTime;
	/** 创建人 */
	private String createUser;
	/** 修改时间 */
	private java.util.Date modifyDateTime;
	/** 修改人 */
	private String modifyUser;
	/** 删除标识 0不可用，1可用 */
	private Integer deleteFlag;

	public Long getId() {
		return this.id;
	}
	
	public void setId(Long value) {
		this.id = value;
	}
	
	
	
	
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String value) {
		this.userId = value;
	}
	
	
	
	
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String value) {
		this.userName = value;
	}
	
	
	
	
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	
	
	
	
	public Integer getSex() {
		return this.sex;
	}
	
	public void setSex(Integer value) {
		this.sex = value;
	}
	
	
	
	
	
	public Integer getAge() {
		return this.age;
	}
	
	public void setAge(Integer value) {
		this.age = value;
	}
	
	
	
	
	
	public java.util.Date getCreateDateTime() {
		return this.createDateTime;
	}
	
	public void setCreateDateTime(java.util.Date value) {
		this.createDateTime = value;
	}
	
	
	
	
	
	public String getCreateUser() {
		return this.createUser;
	}
	
	public void setCreateUser(String value) {
		this.createUser = value;
	}
	
	
	
	
	
	public java.util.Date getModifyDateTime() {
		return this.modifyDateTime;
	}
	
	public void setModifyDateTime(java.util.Date value) {
		this.modifyDateTime = value;
	}
	
	
	
	
	
	public String getModifyUser() {
		return this.modifyUser;
	}
	
	public void setModifyUser(String value) {
		this.modifyUser = value;
	}
	
	
	
	
	
	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}
	
	public void setDeleteFlag(Integer value) {
		this.deleteFlag = value;
	}
	
	
	
	
	

}

