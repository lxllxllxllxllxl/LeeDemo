package com.array;

/**
 * @Author: lxl_a
 * @Date: 2020/11/26 9:43
 * @Description: 迭代器接口
 */
public interface Iterator {
	boolean HasNext();		//是否有下一个
	Object Next();		//下一个
	void Remove();		//删除
	int GetIndex();		//得到索引
}
