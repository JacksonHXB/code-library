package com.hxb.component;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

/*SpringBoot默认类，所有的错误都会使用这个类，通过这个类可以实现在每种错误的返回值中自定义自己的数据*/
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{
	
	//这里返回的map就是页面和json能获取的所有字段
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
		Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
		/*设置SpringBoot异常处理器携带的字段*/
		map.put("company","这是我的公司");
		
		/*从自定义的错误处理类中取出错误信息*/
		Map<String, Object> etc = (Map<String, Object>)requestAttributes.getAttribute("etc", 0);//表示request请求域
		
		map.put("etc", etc);
		return map;
	}
}

































