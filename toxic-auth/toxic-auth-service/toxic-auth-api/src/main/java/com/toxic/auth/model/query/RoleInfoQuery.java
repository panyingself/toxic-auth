/*
 * Copyright (c) 18-12-2 下午11:41 toxic
 */

/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */

package com.toxic.auth.model.query;

import com.toxic.auth.model.RoleInfo;

public class RoleInfoQuery extends RoleInfo {
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
