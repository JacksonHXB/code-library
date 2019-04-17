<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引入Sturts2的标签库 -->
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OGNL</title>
</head>
<body>
	<!-- OGNL表达式 -->
	<!-- 访问常量 -->
	PI = <s:property value="@java.lang.Math@PI" /><br>
	<!-- 访问静态方法 -->
	random = <s:property value="@java.lang.Math@random() * 100" /><br>
</body>
</html>

























































































