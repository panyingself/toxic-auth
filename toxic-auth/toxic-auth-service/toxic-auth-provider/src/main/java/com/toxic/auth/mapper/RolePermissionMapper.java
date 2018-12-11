/*
 * Copyright (c) 18-12-3 上午12:39 toxic
 */

/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */

package com.toxic.auth.mapper;

import com.toxic.auth.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.toxic.auth.model.*;

@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    void deleteByResourceId(String resourceId);

}
