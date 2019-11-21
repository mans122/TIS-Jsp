
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
request.setCharacterEncoding("utf-8");
%>

EL 방식 : <%-- 보다 깔끔하고 간단한 코드 --%> <br>
id : ${param.id} <br>
pw : ${param.password}<br>
name : ${param.name}<br>
email : ${param.email}<br>
address : ${param.address}<br>
성별 : ${param.gender }<br>
email 수신 여부 : ${param.emailReceive}<br>
취미 : ${param.hobby}<br>
직업 : ${param.job}<br>
자기소개 : ${param.introduce}<br>
  
</body>
</html>