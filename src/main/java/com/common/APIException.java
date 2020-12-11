package com.common;

import lombok.Getter;

/**
 * @Author: lxl_a
 * @Date: 2020/10/29 9:27
 * @Description: 自定义异常类
 */
@Getter
public class APIException extends RuntimeException {
	private int code;
	private String msg;

	public APIException() {
		this(1001, "接口错误");
	}
	public APIException(String msg) {
		this(1001, msg);
	}
	public APIException(int code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}
}
