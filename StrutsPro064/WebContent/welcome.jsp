<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>
	<s:debug />
	
	<!-- 使用el表达式，从域中获取 -->
	name = ${name }<br> 
	age = ${age }<br>
	
	<!-- 从root里面读取数据,建议使用这种方式 -->
	name = <s:property value="name" /><br>
	age = <s:property value="age" /><br>
</body>
</html>

























































































































































