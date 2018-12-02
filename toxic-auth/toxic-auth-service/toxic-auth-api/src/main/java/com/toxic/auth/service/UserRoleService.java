/*
 * Copyright (c) 18-12-2 下午11:45 toxic
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

public interface UserRoleService extends BaseService<UserRole, Integer>{

	List<UserRole> queryList(UserRoleQuery userRoleQuery);

	Page<UserRole> queryListPage(UserRoleQuery userRoleQuery, Page<UserRole> page);
}
