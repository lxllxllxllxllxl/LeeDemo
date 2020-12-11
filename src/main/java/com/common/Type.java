package com.common;

import lombok.Getter;

/**
 * @Author: lxl_a
 * @Date: 2020/11/4 10:12
 * @Description: 题型
 */
@Getter
public enum Type {
	singleChoice("101","singleChoice"),
	multipleChoice("102","multipleChoice"),
	completion("103","completion"),
	shortAnswer("104","completion");

	private String code;
	private String msg;

	Type(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
