<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>
	<form action="test/login" method="POST">
		<!-- 当使用域驱动时，需要在前面加上域对象 -->
		姓名：<input type="text" name="student.name"/><br>
		年龄：<input type="text" name="student.age"/><br>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>



































































































































































































