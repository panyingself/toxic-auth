/*
 * Copyright (c) 18-12-2 下午11:12 toxic
 */
package com.toxic.auth.model.query;

import com.toxic.auth.model.UserInfo;

public class UserInfoQuery extends UserInfo {
	private static final long serialVersionUID = 1L;
	
	/** 关键字查询 */
	private String keyWord;

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
}
