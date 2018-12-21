<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/register.css" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to LeaveMessage System</h1>
<form:form modelAttribute="user" action="h3">
<table>
<tr>
<td><form:label path="name">username:</form:label></td>
<td><form:input path="name"></form:input></td>
<td><form:errors cssClass="error" path="name" /></td>

</tr>
<tr>
<td><form:label path="pass">userpass:</form:label></td>
<td><form:input path="pass"></form:input></td>
<td><form:errors cssClass="error" path="pass" /></td>
</tr>
<tr>
<td>
<input type="button" value="forget"  onclick="window.location.href = 'http://localhost:9999/LeaveMessageSystem/login/h2'"/>
<input type="submit" value="login"/>
<input type="button" value="register" onclick="window.location.href = 'http://localhost:9999/LeaveMessageSystem/register/h1'"/>

</td>
</tr>
</table>

</form:form>


</body>
</html>