/*
 * Copyright (c) 18-12-2 下午11:46 toxic
 */

/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */

package com.toxic.auth.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.toxic.auth.service.UserRoleService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.toxic.auth.page.Page;
import com.toxic.auth.service.impl.base.BaseServiceImpl;
import com.toxic.auth.model.*;
import com.toxic.auth.mapper.*;
import com.toxic.auth.model.*;
import com.toxic.auth.model.query.*;

@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole,Integer> implements UserRoleService {
	@Resource
	private UserRoleMapper userRoleMapper;


	public List<UserRole> queryList(UserRoleQuery userRoleQuery){
		return userRoleMapper.selectList(userRoleQuery);
	}

	public Page<UserRole> queryListPage(UserRoleQuery userRoleQuery, Page<UserRole> page){
        PageHelper.startPage(page.getCurrent(), page.getSize());
        page.setRecords(userRoleMapper.selectList(userRoleQuery));
		return page;
	}
}
