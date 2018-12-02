/*
 * Copyright (c) 18-12-3 上午12:39 toxic
 */

/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */

package com.toxic.auth.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.toxic.auth.service.RolePermissionService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.toxic.auth.page.Page;
import com.toxic.auth.service.impl.base.BaseServiceImpl;
import com.toxic.auth.model.*;
import com.toxic.auth.mapper.*;
import com.toxic.auth.model.*;
import com.toxic.auth.model.query.*;

@Service
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermission,Integer> implements RolePermissionService {
	@Resource
	private RolePermissionMapper rolePermissionMapper;


	public List<RolePermission> queryList(RolePermissionQuery rolePermissionQuery){
		return rolePermissionMapper.selectList(rolePermissionQuery);
	}

	public Page<RolePermission> queryListPage(RolePermissionQuery rolePermissionQuery, Page<RolePermission> page){
        PageHelper.startPage(page.getCurrent(), page.getSize());
        page.setRecords(rolePermissionMapper.selectList(rolePermissionQuery));
		return page;
	}
}
