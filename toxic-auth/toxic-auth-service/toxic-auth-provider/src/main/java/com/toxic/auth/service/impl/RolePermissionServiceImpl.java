/*
 * Copyright (c) 18-12-3 上午12:39 toxic
 */

/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */

package com.toxic.auth.service.impl;

import com.github.pagehelper.PageHelper;
import com.toxic.auth.mapper.RolePermissionMapper;
import com.toxic.auth.model.RolePermission;
import com.toxic.auth.model.query.RolePermissionQuery;
import com.toxic.auth.page.Page;
import com.toxic.auth.service.RolePermissionService;
import com.toxic.auth.service.impl.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermission,Integer> implements RolePermissionService {
	@Resource
	private RolePermissionMapper rolePermissionMapper;

	@Override
	public void deleteByResourceId(String resouceId) {
		rolePermissionMapper.deleteByResourceId(resouceId);
	}

	public List<RolePermission> queryList(RolePermissionQuery rolePermissionQuery){
		return rolePermissionMapper.selectList(rolePermissionQuery);
	}

	public Page<RolePermission> queryListPage(RolePermissionQuery rolePermissionQuery, Page<RolePermission> page){
        PageHelper.startPage(page.getCurrent(), page.getSize());
        page.setRecords(rolePermissionMapper.selectList(rolePermissionQuery));
		return page;
	}
}
