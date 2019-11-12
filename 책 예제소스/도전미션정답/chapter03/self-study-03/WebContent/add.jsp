<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
int sum = 0;
public int add(int a, int b) {
	sum = a + b;
	return sum;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<% 
out.print("20+10=" + add(20,10));
%>
</body>
</html>