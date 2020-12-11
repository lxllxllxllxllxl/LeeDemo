package com.io;

import java.io.*;

/**
 * @Author: lxl_a
 * @Date: 2020/11/16 14:32
 * @Description: IO学习-用字节流读写文件。
 * 因为是用字节流来读媒介，
 * 所以对应的流是 InputStream 和 OutputStream，
 * 并且媒介对象是文件，所以用到子类是 FileInputStream 和
 * FileOutputStream，这里还可以通过 BufferedInputStream
 * 用缓冲流来读取文件。
 */
public class IoTest02 {
	public static void readAndWriteByteToFile() throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("C:/Users/boolean/Desktop/Project/LeeDemo/FileInputStreamTest.txt");
			os = new FileOutputStream("C:/Users/boolean/Desktop/Project/LeeDemo/FileOutStreamTest.txt");
			byte[] buf = new byte[4];
			int hasRead = 0;
			while ((hasRead=is.read(buf))>0) {
				os.write(buf,0,hasRead);
			}
			System.out.println("write success");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			os.close();
			is.close();
		}
	}

	public static void main(String[] args) throws IOException {
		readAndWriteByteToFile();
	}
}
