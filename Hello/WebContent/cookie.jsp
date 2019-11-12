<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie</title>
</head>
<body>
<%
	//저장된 쿠키
	Cookie c2 = new Cookie("id", "hkd");
	c2.setMaxAge(365 * 24 * 60 * 60); //365일로 설정
	response.addCookie(c2);
	
	//메모리 쿠키
	Cookie c = new Cookie("pwd", "1234");
	response.addCookie(c);
%>
쿠키생성
<a href="getCookie.jsp">쿠키확인</a>
</body>
</html>