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
	name = <s:property value="name" /><br>
	age = <s:property value="age"/><br> 
	
	<!-- #reqeust.name底层执行的是request.getAttribute("name") -->
	#request.name = <s:property value="#request.name" /><br>
	#request.age = <s:property value="#request.age"/><br> 
	
	<!-- #parameters.name底层执行的是request.getParameter("name") -->
	$parameters.name = <s:property value="#parameters.name"/><br>
	$parameters.age = <s:property value="#parameters.age"/><br>
	
	$action.name = <s:property value="#action.name"/><br>
	$action.age = <s:property value="#action.age"/><br>
</body>
</html>

























































































































































