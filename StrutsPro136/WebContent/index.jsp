<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<form action="test/login" method="POST">
		<s:token /><!-- 防止表单重复提交 -->
		姓名：<input type="text" name="name"/>
		年龄：<input type="text" name="age"/>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>




































