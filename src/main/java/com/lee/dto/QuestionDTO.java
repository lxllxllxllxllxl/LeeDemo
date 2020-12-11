package com.lee.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lee.entity.Item;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author: lxl
 * @Date: 2020/11/4 9:40
 * @Description: 接收用户传入问题保存的实体类
 */
@Data
public class QuestionDTO extends QueryDTO{

	@TableId(value = "id",type = IdType.INPUT)
	private String id;

	@NotBlank(message = "类别不能为空")
	private String type;

	@NotBlank(message = "问题不能为空")
	private String content;

	@NotBlank(message = "答案不能为空")
	private String answer;

	private String comment;

	private List<@Valid Item> items;
}
