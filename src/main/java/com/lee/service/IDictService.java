package com.lee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.entity.Dict;
import com.lee.entity.Item;

import java.util.List;

/**
 * @Author: lxl_a
 * @Date: 2020/11/3 16:32
 * @Description: 公共服务类
 */
public interface IDictService extends IService<Dict>{
	List get(String category);
}
