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
	<s:text name="index.form.head" /><br>
	<a href="test/language.action?request_locale=zh_CN">中文</a><!-- 这里的参数名不能随意变更 -->
	&nbsp;&nbsp;&nbsp;
	<a href="test/language.action?request_locale=en_US">English</a><br>
	<hr>
	<!-- 指定读取的Action范围资源文件 -->
	<s:i18n name="com/hxb/actions/LoginAction">
		<s:form action="test/login" method="POST">
			<s:textfield name="name" key="index.form.name"/>
			<s:textfield name="age" key="index.form.age"/>
			<s:submit key="index.form.submit"/>
		</s:form>
	</s:i18n>
</body>
</html>




































