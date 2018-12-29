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
	<div align="center">
		<h3>Welcome to visit reply page</h3>
		<div style="border-style: dotted; width: 600px;">
			<font>${board.boardName}</font>
		</div>
		<table cellpadding="5px" width="500px" cellspacing="0"
			style="margin-top: 5px">
			<c:if test="${!empty replys}">
				<c:forEach var="reply" begin="0" step="1" items="${replys}">
					<c:set var="count" value="${count+1}" />
					<tr>
						<td>${count}floor:</td>
						<td colspan="2"><font>${reply.replyContent}</font></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:set var="p" scope="page" value="${p}"></c:set>
			<tr>
				<td align="left"><c:choose>
						<c:when test="${p>0}">
							<a href="<c:url value="/reply/h1?page=${p-1}"/>">pre page</a>
						</c:when>
						<c:otherwise>
							<a href="" />none pre page</a>
						</c:otherwise>
					</c:choose></td>
				<td><a href="http://localhost:9999/LeaveMessageSystem/reply/h2"
					style="align: center">add reply</a></td>
				<td align="center"><a href="http://localhost:9999/LeaveMessageSystem/board/h4">go back</a></a></td>
				<td colspan="2" align="right"><c:choose>
						<c:when test="${p<max}">
							<a href="<c:url value="/reply/h1?page=${p+1}"/>">next page</a>
						</c:when>
						<c:otherwise>
							<a href="" />none next page</a>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
		<div>
</body>
</html>