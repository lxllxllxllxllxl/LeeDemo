package com.common;

import lombok.Getter;

/**
 * @Author: lxl_a
 * @Date: 2020/10/29 14:59
 * @Description: 响应码
 */
@Getter
public enum ResultCode {
	SUCCESS(1000,"操作成功"),
	FAILED(1001,"响应失败"),
	VALIDATE_FAILED(1002,"参数校验失败"),
	UNEXIST_URL(404,"URL不存在"),
	ERROR(500,"未知错误");

	private int code;
	private String msg;

	ResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
