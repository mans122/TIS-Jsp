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
	for(int i=0;i<10;i++){
		out.print("<h1>jsp</h1>");
	}
%>

<% for(int i=0;i<10;i++){%>
<h1>html</h1>
<%}%>
</body>
</html>