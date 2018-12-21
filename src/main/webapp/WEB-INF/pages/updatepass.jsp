<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/register.css" type="text/css" />
</head>
<body>
<table>
<h1>Welcome to reset pass Page</h1>
<form:form modelAttribute="user" action="h2" method="post">
<tr>
<td><form:label path="pass">old pass:</form:label></td>
<td><form:input path="pass"></form:input></td>
<td><form:errors cssClass="error" path="pass" /></td>
</tr>
<tr>
<td><form:label path="newpass">new pass:</form:label></td>
<td><form:input path="newpass"></form:input></td>
<td><form:errors cssClass="error" path="newpass" /></td>
</tr>
<tr>
<td><input type="submit" value="submit"/></td>
</tr>

</form:form>
</table>
</body>
</html>