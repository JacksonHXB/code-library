<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功页面</title>
</head>
<body>
	<s:text name="welcome.text.msg" /><br>
	<!-- 读取动态参数 -->
	<s:text name="welcome.text.msg2">
		<s:param><s:property value="name" /></s:param>
	</s:text>
	${sessionScope.msg }<br>
	${sessionScope.msg2 }<br>
</body>
</html>



































































