package com.lee.controller;

import cn.hutool.core.util.IdUtil;
import com.common.PageBean;
import com.lee.dto.QuestionDTO;
import com.lee.service.IQuestionService;
import com.lee.util.Tool;
import com.lee.vo.QuestionVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lixl
 * @since 2020-10-29
 */
@RestController
@RequestMapping("/lee/question")
public class QuestionController {

	@Resource
	private IQuestionService questionService;

	@GetMapping("hello")
	public String Hello() {
		return "hello world";
	}


	/**
	 * 修改或保存
	 * @param questionDto
	 * @return
	 */
	@PostMapping("/save")
	public boolean save(@Valid @RequestBody QuestionDTO questionDto) {
		if (Tool.isNoValue(questionDto.getId())) {
			questionDto.setId(IdUtil.simpleUUID());
		}
		return questionService.saveQuestion(questionDto);
	}

	/**
	 * 查询
	 * @param questionDTO
	 * @return
	 */
	@GetMapping("/get")
	public PageBean<QuestionVO> list(@Valid @RequestBody QuestionDTO questionDTO) {
		return questionService.queryQustionList(questionDTO);
	}

	/**
	 * 删除单个问题
	 * @param questionId
	 * @return
	 */
	@DeleteMapping("/{questionId}")
	public boolean del(@NotBlank(message = "字典ID不能为空")
			@PathVariable String questionId) {
		return questionService.removeQuestionById(questionId);
	}

	/**
	 * 删除多个问题
	 * @param idList
	 * @return
	 */
	@PostMapping("/delBatch")
	public boolean delBatch(@Valid @RequestBody List<String> idList) {
		return questionService.removeQuestionByIdBatch(idList);
	}
}
