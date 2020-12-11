package com.array;

//import java.util.ArrayList;
/**
 * @Author: lxl_a
 * @Date: 2020/11/19 21:06
 * @Description: 主函数
 */
public class Main {
	public static void main(String[] args) {

		ArrayList arrayList = new ArrayList(3);
		arrayList.Append("1");
		arrayList.Append("2");
		arrayList.Append("3");
//		arrayList.Set(1,"4");
		arrayList.Insert(1,2);
		System.out.println(arrayList.Get(0));
		System.out.println(arrayList.Get(1));
	}
}
