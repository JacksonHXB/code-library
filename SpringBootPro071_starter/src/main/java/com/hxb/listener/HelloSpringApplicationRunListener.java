package com.hxb.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class HelloSpringApplicationRunListener implements SpringApplicationRunListener{

	public HelloSpringApplicationRunListener(SpringApplication application, String[] args){
		
	}
	
	@Override
	public void starting() {
		System.out.println("SpringApplicatioRunListener....starting");
	}

	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {
		Object o = environment.getSystemProperties().get("os.name");//这里可以获取操作系统的名称
		System.out.println("SpringApplicatioRunListener....environmentPrepared..." + o);
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		System.out.println("SpringApplicatioRunListener...contextPrepared");
	}

	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {
		System.out.println("SpringApplicatioRunListener...contextLoaded");
	}

	@Override
	public void finished(ConfigurableApplicationContext context, Throwable exception) {
		System.out.println("SpringApplicatioRunListener...finished");
	}

}






























