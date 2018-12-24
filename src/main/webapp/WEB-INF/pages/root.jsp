<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h3>Welcome to manage page!</h3>
<table border="1px"  bordercolor="blue" cellpadding="5" cellspacing="0">
<tr>
<th>userid</th>
<th>username</th>
<th>count of subject</th>
<th>count of reply</th>
<th>operation</th>
</tr>
<c:forEach var="user" begin="0" step="1" items="${list}">
<tr>
<td>${user.userId}</td>
<td>${user.userName}</td>
<td>${user.boardCount}</td>
<td>${user.replyCount}</td>
<td><a href="<c:url value="/manage/h2?userId=${user.userId}"/>">delete user</a></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>