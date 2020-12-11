package com.lee.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.PageBean;
import com.lee.dto.QueryDTO;
import com.lee.dto.QuestionDTO;
import com.lee.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.vo.ItemVO;
import com.lee.vo.QuestionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-10-29
 */
public interface QuestionMapper extends BaseMapper<Question> {

	List<QuestionVO> queryList(@Param("param") QuestionDTO questionDTO);

	int queryListCount(@Param("param") QuestionDTO questionDTO);

	List<ItemVO> queryItemsByQuestionId(@Param("questionId") String questionId);

}
