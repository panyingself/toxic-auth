/*
 * Copyright (c) 18-12-3 上午12:34 toxic
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

public interface PermissionInfoService extends BaseService<PermissionInfo, Integer>{

	List<PermissionInfo> queryList(PermissionInfoQuery permissionInfoQuery);

	Page<PermissionInfo> queryListPage(PermissionInfoQuery permissionInfoQuery, Page<PermissionInfo> page);
}
