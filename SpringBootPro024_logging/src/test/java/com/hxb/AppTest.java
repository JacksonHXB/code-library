package com.hxb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest{
	//记录器
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void contextLoads(){
		/*日志的级别：
		 *	日志的级别由低到高：trace < debug < info < warn < error
		 *  日志框架的好处可以调整输出日志的级别，这个日志就会在当前级别和以后以后的高级别生效
		 **/
		logger.trace("这是trace日志....");
		logger.debug("这是debug日志....");
		logger.info("这是info日志....");		//SpringBoot默认设置的日志级别是info级别
		logger.warn("这是warn日志....");
		logger.error("这是error日志....");
	}
}

































