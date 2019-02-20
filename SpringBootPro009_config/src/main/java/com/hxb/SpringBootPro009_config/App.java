package com.hxb.SpringBootPro009_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ImportResource(locations={"classpath:spring.xml"})//加载Spring的配置文件
@SpringBootApplication
public class App {
	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}
