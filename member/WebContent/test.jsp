<%@page import="java.sql.Connection" %>
<%@page import="com.saeyan.dao.MemberDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 MemberDAO md=MemberDAO.getInstance();
Connection onn=md.getConnection();
out.println("성공");
%>
</body>
</html>