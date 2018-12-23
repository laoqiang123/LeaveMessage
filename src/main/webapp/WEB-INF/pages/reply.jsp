<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div align="center">
  <h3>Welcome to visit reply page</h3>
  <div style="border-style:dotted;width: 500px;">
  <font>${board.boardName}</font>
  </div>
  <table  cellpadding="5px"  width="500px" cellspacing="0" style="margin-top: 5px">
  <c:if test="${!empty replys}">
  <c:forEach var="reply" begin="0" step="1" items="${replys}">
  <c:set var="count" value="${count+1}"/>
  <tr>
  <td>${count} floor:</td>
  <td colspan="2"><font>${reply.replyContent}</font></td>
  </tr>
  </c:forEach>
  </c:if>
  <tr>
  <td><a href="" style="align: left">pre page</a></td>
  <td><a href="http://localhost:9999/LeaveMessageSystem/reply/h2" style="align:center">add reply</a></td>
  <td><a href="" style="align: right">next page</a></td>
  </tr>
  </table>
  <div>
</body>
</html>