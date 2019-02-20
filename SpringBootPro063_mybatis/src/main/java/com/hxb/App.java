package com.hxb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(value="com.hxb.mapper")   //扫描该包下面的所有映射文件
@SpringBootApplication
public class App {
	public static void main(String[] args){
		//启动Spring应用
		SpringApplication.run(App.class, args);
	}
}


	









































