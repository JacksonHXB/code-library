<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>
	<!-- 数据回显标签：当类型准换错误的时候，就会返回相应提交的页面 -->
	<s:form action="test/login" method="POST">
		<s:textfield name="age" label="年龄"/>
		<s:textfield name="birthday" label="生日" />
		<s:submit value="登录" />
	</s:form>
	
	<form action="test/login" method="POST">
		年龄：<input type="text" name="age"/><br>
		<!-- Struts2默认的类型转换器，在这里可以将Stirng类型2017-08-09 转换成默认的时间格式-->
		生日：<input type="text" name="birthday"/><br>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>



































































































































































































