package com.hxb.typeconverters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

/**
 * @author Administrator
 * 多种日期格式的转换
 */
@SuppressWarnings("all")
public class MyDateConverter extends DefaultTypeConverter{
	@Override
	public Object convertValue(Object value, Class toType) {
		SimpleDateFormat sdf = null;
		try {
			if(toType == Date.class){ 
				String dateStr = ((String[])value)[0];
				
				sdf = getSimpleDateFormat(dateStr);
				//将用户输入的格式存入session，以方便后期数据回显
				ActionContext.getContext().getSession().put("sdf", sdf);
				
				return sdf.parse(dateStr);
			}else if(toType == String.class){
				Date date = (Date)value;
				
				/*获取用户输入的字符串格式*/
				sdf = (SimpleDateFormat)ActionContext.getContext().getSession().get("sdf");
				
				return sdf.format(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return super.convertValue(value, toType);
	}

	
	/*根据用户输入的字符串返回字符串的格式*/
	private SimpleDateFormat getSimpleDateFormat(String source) {
		SimpleDateFormat sdf = null;
		if(Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$", source)){//2018/09/08
			sdf = new SimpleDateFormat("yyy/MM/dd");
		}else if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", source)){//2018-09-08
			sdf = new SimpleDateFormat("yyy-MM-dd");
		}else if(Pattern.matches("^\\d{4}\\d{2}\\d{2}$", source)){//20180908
			sdf = new SimpleDateFormat("yyyMMdd");
		}else{//如果都不符合，就扔出类型转换异常
			throw new TypeConversionException();
		}
		return sdf;
	}
}











































