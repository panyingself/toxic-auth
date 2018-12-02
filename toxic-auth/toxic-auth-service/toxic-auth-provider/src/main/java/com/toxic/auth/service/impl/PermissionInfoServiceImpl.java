/*
 * Copyright (c) 18-12-3 上午12:35 toxic
 */

/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */

package com.toxic.auth.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.toxic.auth.service.PermissionInfoService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.toxic.auth.page.Page;
import com.toxic.auth.service.impl.base.BaseServiceImpl;
import com.toxic.auth.model.*;
import com.toxic.auth.mapper.*;
import com.toxic.auth.model.*;
import com.toxic.auth.model.query.*;

@Service
public class PermissionInfoServiceImpl extends BaseServiceImpl<PermissionInfo,Integer> implements PermissionInfoService {
	@Resource
	private PermissionInfoMapper permissionInfoMapper;


	public List<PermissionInfo> queryList(PermissionInfoQuery permissionInfoQuery){
		return permissionInfoMapper.selectList(permissionInfoQuery);
	}

	public Page<PermissionInfo> queryListPage(PermissionInfoQuery permissionInfoQuery, Page<PermissionInfo> page){
        PageHelper.startPage(page.getCurrent(), page.getSize());
        page.setRecords(permissionInfoMapper.selectList(permissionInfoQuery));
		return page;
	}
}
