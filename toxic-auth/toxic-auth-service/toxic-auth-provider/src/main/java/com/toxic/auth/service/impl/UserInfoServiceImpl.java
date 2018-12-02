/*
 * Copyright (c) 18-12-2 下午11:25 toxic
 */

package com.toxic.auth.service.impl;

import java.util.List;
import com.toxic.auth.page.Page;
import com.toxic.auth.service.UserInfoService;
import com.toxic.auth.service.impl.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.toxic.auth.model.*;
import com.toxic.auth.mapper.*;
import com.toxic.auth.model.query.*;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo,Integer> implements UserInfoService {
	@Resource
	private UserInfoMapper userInfoMapper;


	public List<UserInfo> queryList(UserInfoQuery userInfoQuery){
		return userInfoMapper.selectList(userInfoQuery);
	}

	public Page<UserInfo> queryListPage(UserInfoQuery userInfoQuery, Page<UserInfo> page){
        PageHelper.startPage(page.getCurrent(), page.getSize());
        page.setRecords(userInfoMapper.selectList(userInfoQuery));
		return page;
	}
}
