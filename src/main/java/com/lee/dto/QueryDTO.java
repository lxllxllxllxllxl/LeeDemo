package com.lee.dto;

import lombok.Data;

/**
 * @Author: lxl
 * @Date: 2020/11/4 16:02
 * @Description: 查询DTO
 */
@Data
public class QueryDTO {
	private int currentPage;
	private int pageSize;
}
