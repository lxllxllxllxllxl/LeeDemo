package com.io;

import java.io.*;

/**
 * @Author: lxl_a
 * @Date: 2020/11/16 14:50
 * @Description: 用字符流进行读写操作
 * FileReader 和 FileWriter
 */
public class IoTest03 {
	public static void readAndWriteCharToFile() throws IOException {
		Reader reader = null;
		Writer writer = null;
		try {
			File readFile = new File("C:/Users/boolean/Desktop/Project/LeeDemo/FileInputStreamTest.txt");
			reader = new FileReader(readFile);
			File writeFile = new File("C:/Users/boolean/Desktop/Project/LeeDemo/FileOutStreamTest.txt");
			writer = new FileWriter(writeFile);
			char[] byteArray = new char[(int)readFile.length()];
			int size = reader.read(byteArray);
			System.out.println("大小："+size+"个字符；内容："+new String(byteArray));
			writer.write(byteArray);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
			writer.close();
		}
	}

	public static void main(String[] args) throws IOException {
		readAndWriteCharToFile();
	}
}
