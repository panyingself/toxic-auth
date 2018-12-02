/*
 * Copyright (c) 18-12-2 下午11:42 toxic
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

public interface RoleInfoService extends BaseService<RoleInfo, Integer>{

	List<RoleInfo> queryList(RoleInfoQuery roleInfoQuery);

	Page<RoleInfo> queryListPage(RoleInfoQuery roleInfoQuery, Page<RoleInfo> page);
}
