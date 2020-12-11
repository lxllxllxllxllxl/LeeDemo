package com.common;

import lombok.Data;

import java.util.List;

/**
 * @Author: lxl_a
 * @Date: 2020/11/5 9:17
 * @Description: 分页实体类
 */
@Data
public class PageBean<T> {
	private int pageNo; // 当前页数
	private int totalPage; // 总页数
	private int totalCount; // 总记录数
	private int pageIndex; // 当前页起始行
	private int pageSize = 10; // 每页显示的记录数
	private List<T> list; // 每页显示数据的集合

	public PageBean(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public PageBean(int a, int b, int count, List<T> list) {
		this.pageNo = a;
		this.pageSize = b;
		this.totalCount = count;
		this.list = list;
	}

	public int getPageIndex() {
		pageIndex = (pageNo - 1) * pageSize + 1;
		return pageIndex;
	}

	public int getTotalPage() {
		return (totalCount + pageSize - 1) / pageSize;
	}

}
