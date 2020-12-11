package com.common;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: lxl_a
 * @Date: 2020/10/29 9:21
 * @Description: 全局异常处理类
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		// 从异常对象中拿到ObjectError对象
		ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
		// 然后提取错误提示信息进行返回
		return new ResultVO<>(ResultCode.VALIDATE_FAILED,objectError.getDefaultMessage());
	}

	@ExceptionHandler(APIException.class)
	public ResultVO<String> APIExceptionHandler(APIException e) {
		return new ResultVO<>(ResultCode.FAILED,e.getMsg());
	}

}
