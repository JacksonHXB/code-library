package com.hxb.typeconverters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

/**
 * @author Administrator
 * 自定义类型转换器
 */
@SuppressWarnings("all")
public class MyDateConverter extends DefaultTypeConverter{
	/*
		value:将要被转换的值
		toType:要转换称为目标类型
		类型转换器需要定义成双向的
			页面-> 服务器：String[] -> Date 是数组可以接受用户多个值
			服务器 -> 页面 ：Date -> String
	*/
	@Override
	public Object convertValue(Object value, Class toType) {
		/*根据转换的方向进行转换*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");
		try {
			if(toType == Date.class){ //成立，说明是由页面到服务器的转换
				System.out.println("页面到服务器的类型转换");
				String dateStr = ((String[])value)[0];
				/*如果用户输入错误，提示类型转换错误*/
				if(!Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$", dateStr)){//两个\表示转义后的
					//抛出类型转换异常，Struts就会去执行数据的回显提示
					throw new TypeConversionException();
				}
				return sdf.parse(dateStr);
			}else if(toType == String.class){//成立，说明是由服务端到页面的转换
				System.out.println("服务器到页面的类型转换");
				Date date = (Date)value;
				return sdf.format(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return super.convertValue(value, toType);
	}
}











































