package com.hxb.component;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

/*区域信息解析器*/
/*接收请求头信息，并进行动态设定区域的国际化*/
public class MyLocaleResolver implements LocaleResolver{
	
	Logger logger = LoggerFactory.getLogger(getClass());

	/*解析区域信息*/
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		logger.info("区域信息解析器正在处理.....");
		
		//获取请求对象，用于分辨请求的语言类型
		String l = request.getParameter("l");
		Locale locale = Locale.getDefault();	//设置默认的区域信息
		if(!StringUtils.isEmpty(l)){
			String[] split = l.split("_");
			locale = new Locale(split[0], split[1]);//分别将国家和语音简码传入到区域信息对象
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale arg2) {
		// TODO Auto-generated method stub
		
	}

}




























