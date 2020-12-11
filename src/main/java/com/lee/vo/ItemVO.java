package com.lee.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: lxl_a
 * @Date: 2020/11/5 10:20
 * @Description: 返回的选项结果集
 */
@Data
public class ItemVO {
	@TableId(value = "id",type = IdType.INPUT)
	private String id;

	@NotBlank(message = "选项不能为空")
	private String content;

	@NotBlank(message = "标签不能为空")
	private String label;

	private String questionId;
}
