package com.lee.controller;

import cn.hutool.core.util.IdUtil;
import com.lee.entity.Dict;
import com.lee.service.IDictService;
import com.lee.util.Tool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author: lxl
 * @Date: 2020/11/3 16:48
 * @Description: 字典维护
 */
@RestController
@RequestMapping("/lee/dict")
@Slf4j
@Validated
public class DictController {
	@Autowired
	private IDictService dictService;

	@PostMapping("/save")
	public boolean save(@Valid @RequestBody Dict dict) {
		if (Tool.isNoValue(dict.getId())) {
			dict.setId(IdUtil.simpleUUID());
		}
		return dictService.saveOrUpdate(dict);
	}

	@GetMapping("/get")
	public List get(@NotBlank(message = "字典类型不能为空")
						@RequestParam String category) {
		return dictService.get(category);
	}

	@DeleteMapping("/{dictId}")
	public boolean del(@NotBlank(message = "字典ID不能为空")
			@PathVariable String dictId) {
		return dictService.removeById(dictId);
	}
}
