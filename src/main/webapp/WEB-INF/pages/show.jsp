<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to visit Board page</h2>
	<table border="1px" bordercolor="blue" cellpadding="5" cellspacing="0">
		<tr>
			<td colspan="5"></td>
			<td><input type="button" value="publish"
				onclick="window.location.href = 'http://localhost:9999/LeaveMessageSystem/board/h1'" /></td>
		</tr>
		<tr>
			<th>username</th>
			<th>title</th>
			<th>count of reply</th>
			<th>date of publish</th>
			<th>last date of reply</th>
			<th>operation</th>
		</tr>
	<c:if test="${!empty boards}">
	<c:forEach var="board" begin="0" step="1" items="${boards}">
		<tr>
			<td>${board.user.userName}</td>
			<td><a href="http://localhost:9999/LeaveMessageSystem/reply/h1?boardId=${board.boardId}">
					${board.boardName}</a></td>
			<td>${board.replyCount}</td>
			<td>${board.publishDate}</td>
			<td>2018-07-05</td>
			<td><a href="">forward</a></td>
		</tr>
		</c:forEach>
		</c:if>
	</table>
</body>
</html>