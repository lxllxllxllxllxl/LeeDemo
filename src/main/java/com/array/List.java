package com.array;

/**
 * @Author: lxl_a
 * @Date: 2020/11/19 10:56
 * @Description: 自定义数组结构
 */
public interface List {
	int Size();  //数组大小
	Object Get(int index);  //抓取第几个元素
	void Set(int index, Object newval);  //修改元素
	void Insert(int index,Object newval);  //插入元素
	void Append(Object newval); //追加
	Object Clear(); //清空
	void Delete(int index);  //删除
}
