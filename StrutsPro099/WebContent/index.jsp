<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据验证</title>
</head>
<body>
	<s:fielderror />
	<!-- 将不会被验证 -->
	<form action="test/login_doSecond" method="POST">
		用户名：<input type="text" name="name"/><br>
		手机号：<input type="text" name="mobile"/><br>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>




































