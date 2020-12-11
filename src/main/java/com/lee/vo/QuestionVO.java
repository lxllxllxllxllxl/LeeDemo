package com.lee.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lee.entity.Item;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author: lxl_a
 * @Date: 2020/11/5 9:25
 * @Description: 查询返回的问题实体类
 */
@Data
public class QuestionVO {

	@TableId(value = "id",type = IdType.INPUT)
	private String id;

	private String type;

	@NotBlank(message = "问题不能为空")
	private String content;

	@NotBlank(message = "答案不能为空")
	private String answer;

	private List<@Valid ItemVO> items;
}
