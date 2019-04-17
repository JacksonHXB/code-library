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
	<!-- debug标签可以查看栈中的数据，也可以看见context中的数据 -->
	<s:debug />
	
	<!-- 输出无名对象的属性的值 -->
	name = <s:property value="name" /><br>
	age = <s:property value="age" /><br>
	
	student3.name3 = <s:property value="student3.name"/><br>
	student3.age3 = <s:property value="student3.age"/><br>
	student4.name4 = <s:property value="student4.name"/><br>
	student4.age4 = <s:property value="student4.age"/><br>
</body>
</html>

























































































































































