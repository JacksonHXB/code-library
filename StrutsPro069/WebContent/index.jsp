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
	list
	<hr>
	<!-- 创建list集合 -->
	<%--set标签定义的对象均存放在context中，所以会加上# --%>
	<s:set name="myList" value="{'张三','李四','王五'}" />
	
	<!-- 遍历list集合 -->
	<%--iterator标签默认会将当前的迭代对象放入到值栈栈顶
		property标签默认会输出值栈栈顶的元素
	--%>
	<s:iterator value="#myList"><!-- 这里最好写#myList,当然myList也能找到 -->
		<s:property /><br>
	</s:iterator>
	
	
	<br><br>
	
	
	map
	<hr>
	<!-- 创建map集合 -->
	<s:set name="myMap" value="#{'mobile':'123456','QQ':'53213','Wechat':'65434'}"/>
	<!-- 遍历map集合1 -->
	<s:iterator value="#myMap">
		<s:property /><br>
	</s:iterator>
	<br>
	<!-- 遍历map集合2 -->
	<s:iterator value="#myMap" var="entry">
		<s:property value="entry"/><br>
	</s:iterator>
	<br>
	<!-- 遍历map集合3 -->
	<s:iterator value="#myMap">
		<s:property value="key"/> = <s:property value="value"/><br>
	</s:iterator>
	
	
	<br><br>
	
	
	集合元素的判断
	<hr>
	判断张三在集合中：<s:property value="'张三' in #myList"/><br>
	判断张三不在集合中：<s:property value="'张三' not in #myList"/><br>
	
	
	<br><br>
	
	
	创建Student对象
	<hr>
	<s:bean name="com.hxb.beans.Student" id="student3">
		<s:param name="name" value="'张三'" />
		<s:param name="age" value="20" />
	</s:bean>
	<s:bean name="com.hxb.beans.Student" id="student4">
		<s:param name="name" value="'李四'" />
		<s:param name="age" value="23" />
	</s:bean>
	<s:bean name="com.hxb.beans.Student" id="student5">
		<s:param name="name" value="'王五'" />
		<s:param name="age" value="21" />
	</s:bean>
	<!-- 输出一个对象 -->
	<s:property value="#student3"/>
	
	
	<br><br>
	
	
	<!-- 集合投影：
		指对于集合中的所有数据（相当于行）只选择集合某个属性值（字段）作为一个新的集合，即行数不变，只选择列
	-->
	集合的投影：将Student对象的name属性值再组成一个List
	<hr>
	<s:set name="students" value="{#student3,#student4,#student5}" />
	<s:set name="studentsNames" value="#students.{name}"/>
	<s:iterator value="#studentsNames">
		<s:property /><br>
	</s:iterator>
	
	
	<br><br>
	
	
	集合查询：查询前面三个Student对象中年龄大于23岁的所有人,?表示所有
	<hr>
	<s:iterator value="#students.{?#this.age >= 23}">
		<s:property /><br>
	</s:iterator>
	
	
	<br><br>
	
	
	集合查询：查询前面三个Student对象中年龄大于21岁的所有人中的第一个人,^表示第一个，$表示最后一个
	<hr>
	<s:iterator value="#students.{^#this.age >= 21}">
		<s:property /><br>
	</s:iterator>
	
</body>
</html>



































































































































































































