package com.common;

import lombok.Getter;

/**
 * @Author: lxl_a
 * @Date: 2020/10/29 9:12
 * @Description: 统一响应体
 */
@Getter
public class ResultVO<T> {
	/**
	 * 状态码，比如1000代表响应成功
	 */
	private int code;
	/**
	 * 响应信息，用来说明响应情况
	 */
	private String msg;
	/**
	 * 响应的具体数据
	 */
	private T data;

	public ResultVO(T data) {
		this(ResultCode.SUCCESS, data);
	}

	public ResultVO(ResultCode resultCode, T data) {
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
		this.data = data;
	}

	public ResultVO(ResultCode resultCode) {
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
	}
}
