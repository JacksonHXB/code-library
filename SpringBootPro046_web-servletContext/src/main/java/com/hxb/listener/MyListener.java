package com.hxb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {//web应用初始化
		System.out.println("web应用启动中...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {//当前web销毁后执行后的操作
		System.out.println("web应用已经关闭....");
	}
}
