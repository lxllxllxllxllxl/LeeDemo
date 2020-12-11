package com.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author: lxl_a
 * @Date: 2020/10/29 15:13
 * @Description: 全局处理响应数据--响应增强类
 */
@ControllerAdvice
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
		System.out.println("=================="+!returnType.getParameterType().equals(ResultVO.class));
		return !returnType.getParameterType().equals(ResultVO.class);
	}

	@Override
	public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
		// String类型不能直接包装，所以要进行些特别的处理
		if (returnType.getParameterType().equals(String.class)) {
			System.out.println(data instanceof String);
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				System.out.println("===========进入了包装数据======");
				// 将String转换，再将数据包装在ResultVO里，再转换为json字符串响应给前端
				return objectMapper.writeValueAsString(new ResultVO<>(data));
			} catch (JsonProcessingException e) {
				throw new APIException("返回String类型错误");
			}
		}
		// 将原本的数据包装在ResultVO里
		return new ResultVO<>(data);
	}
}
