package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: lxl_a
 * @Date: 2020/10/20 15:33
 * @Description: 启动类
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.lee.mapper"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}
}
