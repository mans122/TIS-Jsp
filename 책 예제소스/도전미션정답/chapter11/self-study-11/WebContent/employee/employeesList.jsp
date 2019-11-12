<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원 관리</title>
<link href="css/shopping.css" rel="stylesheet">
</head>
<body>
<div id="wrap" align="center">
<h1>리스트</h1>
<table class="list">
   <tr>
     <td colspan="6" style="border: white; text-align: right"> 
       <a href="EmployeesServlet?command=employees_write_form" >정보등록</a>      
     </td> 
   </tr> 
   <tr><th>아이디</th><th>이름</th><th>권한</th><th>성별</th><th>전화번호</th>
   <c:forEach items="${elist}" var="employee">
   <tr class="record">
     <td>${employee.id }</td>
     <td>
     <a href="EmployeesServlet?command=employees_view&id=${employee.id}">
     ${employee.name}
     </a>
     </td>
     <td>
     <c:choose> 
     <c:when test='${employee.lev=="A"}'>
      운영자
     </c:when>
     <c:otherwise>
       일반사원
     </c:otherwise>
     </c:choose>
     </td>
     <td>
       <c:choose> 
     <c:when test='${employee.gender=="1"}'>
      남자
     </c:when>
     <c:otherwise>
       여자
     </c:otherwise>
     </c:choose>
     </td>
     <td>${employee.phone }</td>
   </tr>
   </c:forEach>
</table>
</div>
</body>
</html>