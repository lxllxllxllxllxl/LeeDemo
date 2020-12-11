package com.io;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @Author: lxl
 * @Date: 2020/11/16 11:53
 * @Description: IO学习-读取键盘输入，打印到控制台
 * @Link https://www.cnblogs.com/CQqf/p/10795656.html
 * 在刷题网站刷算法题的时候，在程序开头都需要和键盘进行交互，
 * 常常用到行夺取器 BufferedReader 和转换流 InputStreamReader。
 */
public class IoTest01 {
	public static void keyInAndPrintConsole() throws IOException {
		PrintWriter out = null;
		BufferedReader br = null;
		try {
			System.out.println("请输入：");
			out = new PrintWriter(System.out,true);
			br = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while ((line = br.readLine())!=null) {
				if (line.equals("exit")) {
					System.exit(1);
				}
				out.println(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
			br.close();
		}
	}

	public static void main(String[] args) throws IOException {
		keyInAndPrintConsole();
	}
}
