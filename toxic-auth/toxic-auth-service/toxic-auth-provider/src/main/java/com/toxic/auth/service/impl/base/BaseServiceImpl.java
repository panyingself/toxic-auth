/*
 * Copyright (c) 18-12-2 下午11:29 toxic
 */

package com.toxic.auth.service.impl.base;

import com.toxic.auth.mapper.base.BaseMapper;
import com.toxic.auth.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @author py
 * @date 2018/11/26 3:52 PM.
 */
public abstract class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {
    @Autowired
    private BaseMapper<T> baseMapper;

    public BaseServiceImpl() {
    }

    public int insert(T record) {
        return this.baseMapper.insert(record);
    }

    public int delete(PK entityId) {
        return this.baseMapper.delete(entityId);
    }

    public int update(T record) {
        return this.baseMapper.update(record);
    }

    public T getById(PK entityId) {
        return this.baseMapper.getById(entityId);
    }

    public T selectOne(T var1) {
        return this.baseMapper.selectOne(var1);
    }

    public List<T> selectList(T var1) {
        return this.baseMapper.selectList(var1);
    }
}
