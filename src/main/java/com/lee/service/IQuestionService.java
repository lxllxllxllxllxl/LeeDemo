package com.lee.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.PageBean;
import com.lee.dto.QueryDTO;
import com.lee.dto.QuestionDTO;
import com.lee.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.vo.QuestionVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-10-29
 */
public interface IQuestionService extends IService<Question> {

	boolean saveQuestion(QuestionDTO questionDto);

	PageBean<QuestionVO> queryQustionList(QuestionDTO questionDTO);

	boolean removeQuestionById(String questionId);

	boolean removeQuestionByIdBatch(List<String> idList);

}
