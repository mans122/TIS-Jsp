<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie</title>
</head>
<body>
<h3>클라이언트로부터 언어온 Cookie </h3>
<%
	Cookie[] cookies = request.getCookies();
	for (Cookie c : cookies) {
		//out.println(c.getName() + " : " + c.getValue() + "<br>");
		if(c.getName().equals("id")){
			out.print("id : "+c.getValue()+"<br>");
		}
		if(c.getName().equals("pwd")){
			out.print("pwd : "+c.getValue()+"<br>");
		}
	}
%>
</body>
</html>