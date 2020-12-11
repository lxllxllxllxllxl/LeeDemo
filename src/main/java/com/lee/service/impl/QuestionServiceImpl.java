package com.lee.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.common.PageBean;
import com.common.Type;
import com.lee.dto.QueryDTO;
import com.lee.dto.QuestionDTO;
import com.lee.entity.Item;
import com.lee.entity.Question;
import com.lee.mapper.QuestionMapper;
import com.lee.service.IItemService;
import com.lee.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.util.Tool;
import com.lee.vo.ItemVO;
import com.lee.vo.QuestionVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-29
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

	@Resource
	private IItemService itemService;

	@Resource
	private QuestionMapper questionMapper;

	/**
	 * 问题保存（新增和修改）
	 * @param questionDto
	 * @return
	 */
	@Override
	@Transactional(
			rollbackFor = {Exception.class}
	)
	public boolean saveQuestion(QuestionDTO questionDto) {
		Question question = new Question();
		BeanUtil.copyProperties(questionDto,question);

		if (questionDto.getType().equals(Type.singleChoice.getCode())
				|| questionDto.getType().equals( Type.multipleChoice.getCode()) ) {
			if(Tool.hasValue(questionDto.getItems())) {
				saveOrUpdate(question);

				List<Item> items = questionDto.getItems();

				QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
				queryWrapper.eq("question_id",questionDto.getId());
				boolean flag = itemService.remove(queryWrapper);
				if (flag) {
					for (Item item: items) {
						item.setQuestionId(questionDto.getId());
						if (Tool.isNoValue(item.getId())) {
							item.setId(IdUtil.simpleUUID());
						}
						itemService.save(item);
					}
				}
				return true;
			} else {
				return false;
			}
		} else {
			return saveOrUpdate(question);
		}
	}

	/**
	 * 分页查询
	 * @param questionDTO
	 * @return
	 */
	@Override
	public PageBean<QuestionVO> queryQustionList(QuestionDTO questionDTO) {
		List<QuestionVO> questionList = questionMapper.queryList(questionDTO);
		for (QuestionVO question: questionList) {
			if (question.getType().equals(Type.singleChoice.getCode())
			|| question.getType().equals(Type.multipleChoice.getCode())) {
				List<ItemVO> items = questionMapper.queryItemsByQuestionId(question.getId());
				question.setItems(items);
			}
		}
		PageBean pageBean = new PageBean(questionDTO.getCurrentPage(),questionDTO.getPageSize(),questionMapper.queryListCount(questionDTO),questionList);
		return pageBean;
	}

	/**
	 * 删除单个问题
	 * @param questionId
	 * @return
	 */
	@Override
	@Transactional(
			rollbackFor = {Exception.class}
	)
	public boolean removeQuestionById(String questionId) {
		QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("question_id",questionId);
		boolean flag = itemService.remove(queryWrapper);
		if (flag) {
			return removeById(questionId);
		} else {
			return false;
		}
	}

	@Override
	@Transactional(
			rollbackFor = {Exception.class}
	)
	public boolean removeQuestionByIdBatch(List<String> idList) {
		for (String id:
				idList) {
			boolean flag =removeQuestionById(id);
			if (!flag) {
				return false;
			}
		}
		return true;
	}
}
