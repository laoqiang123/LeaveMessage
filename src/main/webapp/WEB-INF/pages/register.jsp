<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- 这里链接css 最好写相对路径，不要写/web-inf/css/register  -->
<link rel="stylesheet" href="../css/register.css" type="text/css" />
<script language="javascript" src="../js/register.js"></script>
</head>
<body>
	<form:form modelAttribute="user" id="form" action="h2" method="post">
		<table>
			<h2>Welcome to register LeaveMessageSystem</h2>
			<tr>
				<td><form:label path="name">username:</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors cssClass="error" path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="pass">pass:</form:label></td>
				<td><form:input path="pass" /></td>
				<td><form:errors cssClass="error" path="pass" /></td>
			</tr>
			<tr>
				<td><form:label path="email">email:</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors cssClass="error" path="email" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>