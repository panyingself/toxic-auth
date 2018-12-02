/*
 * Copyright (c) 18-12-2 下午11:24 toxic
 */

package com.toxic.auth.mapper.base;

import java.util.List;

public interface BaseMapper<T> {
    int insert(T var1);

    int delete(Object var1);

    int update(T var1);

    T getById(Object var1);

    T selectOne(T var1);

    List<T> selectList(T var1);
}