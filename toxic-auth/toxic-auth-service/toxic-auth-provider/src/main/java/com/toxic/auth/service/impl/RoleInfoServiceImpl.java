/*
 * Copyright (c) 18-12-2 下午11:43 toxic
 */

/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */

package com.toxic.auth.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.toxic.auth.service.RoleInfoService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.toxic.auth.page.Page;
import com.toxic.auth.service.impl.base.BaseServiceImpl;
import com.toxic.auth.model.*;
import com.toxic.auth.mapper.*;
import com.toxic.auth.model.query.*;

@Service
public class RoleInfoServiceImpl extends BaseServiceImpl<RoleInfo,Integer> implements RoleInfoService {
	@Resource
	private RoleInfoMapper roleInfoMapper;


	public List<RoleInfo> queryList(RoleInfoQuery roleInfoQuery){
		return roleInfoMapper.selectList(roleInfoQuery);
	}

	public Page<RoleInfo> queryListPage(RoleInfoQuery roleInfoQuery, Page<RoleInfo> page){
        PageHelper.startPage(page.getCurrent(), page.getSize());
        page.setRecords(roleInfoMapper.selectList(roleInfoQuery));
		return page;
	}
}
