<%@ page language="java" contentType="image/jpeg; charset=utf-8" 
    pageEncoding="utf-8" import="com.example.test.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ValidationCodeUtil vCode = new ValidationCodeUtil(120, 40, 5, 50);
response.setContentType("image/jpeg");
vCode.write(response.getOutputStream());
//将验证码的值存入到session 中
session.setAttribute("verificationcode",vCode.getCode());

%>
</body>
</html>