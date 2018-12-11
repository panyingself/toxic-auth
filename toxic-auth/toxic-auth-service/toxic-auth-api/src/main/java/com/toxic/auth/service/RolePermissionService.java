/*
 * Copyright (c) 18-12-3 上午12:39 toxic
 */

/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */

package com.toxic.auth.service;


import java.util.List;
import com.github.pagehelper.PageHelper;
import com.toxic.auth.model.*;
import com.toxic.auth.model.query.*;
import com.toxic.auth.page.Page;
import com.toxic.auth.service.base.BaseService;

public interface RolePermissionService extends BaseService<RolePermission, Integer>{

	List<RolePermission> queryList(RolePermissionQuery rolePermissionQuery);

	Page<RolePermission> queryListPage(RolePermissionQuery rolePermissionQuery, Page<RolePermission> page);

	void deleteByResourceId(String resouceId);
}
