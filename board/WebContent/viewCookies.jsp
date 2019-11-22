<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookie[] cookies = request.getCookies();
if(cookies == null || cookies.length==0){
	out.print("쿠키없음");
	return;
}
for(Cookie ck:cookies){
	out.println(ck.getName() + ":"+ck.getValue());
	out.println("<hr>");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>