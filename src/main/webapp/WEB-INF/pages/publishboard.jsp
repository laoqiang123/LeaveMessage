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
<h2>Welcome to publish Board page!</h2>
<form:form action="h2" method="post" modelAttribute="board">
<table border="1" bordercolor="white" cellpadding="5" cellspacing="0">
<tr>
<td><form:label path="boardName">boardName:</form:label></td>
<td><form:input path="boardName"></form:input></td>
<td><form:errors cssClass="error" path="boardName" /></td>
</tr>
<tr>
<td><form:label path="content">content:</form:label></td>
<td><form:textarea path="content"></form:textarea></td>
<td><form:errors cssClass="error" path="content" /></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="publish"></td>
</tr>
</table>
</form:form>
</body>
</html>