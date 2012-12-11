<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form</title>
</head>
<body>
<h2>article form</h2>
<form:form commandName="article" action="/article/save" method="post">
	<form:hidden path="member.id" />
	<div>
		<form:errors path="member" />
	</div>
	<table>
		<tr>
			<th>제목</th>
			<td><form:input path="title"/> <form:errors path="title"  /></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><form:input path="member.id" /><form:errors path="member"  /></td>
		</tr>
		<tr>
			<td colspan="2"><form:textarea path="contents"/></td>
		</tr>
	</table>
	
	<form:button>save</form:button>
</form:form>
</body>
</html>
