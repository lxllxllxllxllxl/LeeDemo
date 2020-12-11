package com.lee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.entity.Dict;
import com.lee.mapper.DicMapper;
import com.lee.service.IDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lxl_a
 * @Date: 2020/11/3 16:33
 * @Description: 公共服务实现类
 */
@Service
public class DictServiceImpl extends ServiceImpl<DicMapper, Dict> implements IDictService {
	@Resource
	private DicMapper dicMapper;

	@Override
	public List get(String category) {
		QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("category",category);
		return dicMapper.selectList(queryWrapper);
	}
}
