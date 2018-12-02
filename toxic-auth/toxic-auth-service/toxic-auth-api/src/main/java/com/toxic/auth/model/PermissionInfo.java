/*
 * Copyright (c) 18-12-3 上午12:34 toxic
 */

/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */

package com.toxic.auth.model;

import java.io.Serializable;

public class PermissionInfo implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private Integer id;
	/** resourceId */
	private String resourceId;
	/** 资源类型menu?button */
	private String resourceType;
	/** 权限名称 */
	private String name;
	/** 资源路径 */
	private String url;
	/** 权限字符串 */
	private String permission;
	/** 父id */
	private String parentId;
	/** 父id列表 */
	private String parentIds;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	
	
	
	
	public String getResourceId() {
		return this.resourceId;
	}
	
	public void setResourceId(String value) {
		this.resourceId = value;
	}
	
	
	
	
	
	public String getResourceType() {
		return this.resourceType;
	}
	
	public void setResourceType(String value) {
		this.resourceType = value;
	}
	
	
	
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	
	
	
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String value) {
		this.url = value;
	}
	
	
	
	
	
	public String getPermission() {
		return this.permission;
	}
	
	public void setPermission(String value) {
		this.permission = value;
	}
	
	
	
	
	
	public String getParentId() {
		return this.parentId;
	}
	
	public void setParentId(String value) {
		this.parentId = value;
	}
	
	
	
	
	
	public String getParentIds() {
		return this.parentIds;
	}
	
	public void setParentIds(String value) {
		this.parentIds = value;
	}
	
	
	
	
	

}

