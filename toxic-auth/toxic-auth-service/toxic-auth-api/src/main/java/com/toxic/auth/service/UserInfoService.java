/*
 * Copyright (c) 18-12-2 下午11:13 toxic
 */
package com.toxic.auth.service;


import java.util.List;
import com.toxic.auth.page.Page;
import com.toxic.auth.model.*;
import com.toxic.auth.model.query.*;
import com.toxic.auth.service.base.BaseService;

public interface UserInfoService extends BaseService<UserInfo, Integer> {

	List<UserInfo> queryList(UserInfoQuery userInfoQuery);

	Page<UserInfo> queryListPage(UserInfoQuery userInfoQuery, Page<UserInfo> page);
}
