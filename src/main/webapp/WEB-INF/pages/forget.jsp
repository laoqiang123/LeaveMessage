<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/register.css" type="text/css" />
<script type="text/javascript" src="../js/forget.js"></script>
</head>
<body>
<h1>Welcome to find pass Page</h1>
<table>
<form:form modelAttribute="user" method="post" action="../findpass/h3">

<tr>
<td><form:label path="email">please input your email:</form:label></td>
<td><form:input path="email" id="email"></form:input></td>
<td><form:errors cssClass="error" path="email" /></td>
</tr>
<tr>
<td><form:input type="text" path="verification" ></form:input></td>
<td><input type="button" value="get verification code" onclick="change()"/></td>
</tr> 
<tr>
<td>
<input type="submit" value="find pass"  />
</td>
</tr>
<tr>
<div class="error">
   <c:if test="${!empty forgeterror}">
   <c:out value="${forgeterror}"/>
   </c:if>
</div>
</tr>
</form:form>
</table>
</body>
</html>