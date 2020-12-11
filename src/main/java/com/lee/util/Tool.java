package com.lee.util;
import java.util.List;

/**
 * @Author: lxl
 * @Date: 2020/11/3 16:04
 * @Description: 工具类
 */
public class Tool {
	public static boolean isNoValue(String str) {
		if (null==str|| "".equals(str) || "null".equals(str) || "undefined".equals(str)) {
			return true;
		}
		return false;
	}

	public static boolean hasValue(List ls) {
		if (null!=ls && !"".equals(ls) && !"null".equals(ls) && !"undefined".equals(ls) && ls.size()>0) {
			return true;
		}
		return false;
	}

}
