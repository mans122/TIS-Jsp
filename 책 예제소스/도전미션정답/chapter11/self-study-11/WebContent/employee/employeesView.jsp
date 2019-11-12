<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정보 보기</title>
<link href="css/shopping.css" rel="stylesheet">
<script type="text/javascript" src="script/employee.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>정보 보기</h1>
<form method="post" name="frm" action="EmployeesServlet">
<input type="hidden" name="command" value="employees_write"> 
   <table style="width: 600px">
     <tr>
		<th style="width: 60px"> 아이디 </th>
		<td>${employee.id}</td>
	 </tr>
		<tr>
			<th>비밀번호</th>
			<td>${employee.pass}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${employee.name}</td>
		</tr>
		
		<tr>
			<th>권한</th>
			<td>
			<c:choose>
				<c:when test='${employee.lev=="A"}'>운영자</c:when>
				<c:otherwise>일반사원</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
			<c:choose>
				<c:when test='${employee.gender=="1"}'>남자</c:when>
				<c:otherwise>여자</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${employee.phone}</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>${employee.enter}</td>
		</tr>		
   </table>
   <br>
  <input type="button" value="수정" onclick=
	  "location.href='EmployeesServlet?command=employees_update_form&id=${employee.id}'">
  <input type="button" value="삭제" onclick=
	  "location.href='EmployeesServlet?command=employees_delete&id=${employee.id}'">
  <input type="button" value="목록" onclick=
	  "location.href='EmployeesServlet?command=employees_list'">
  <input type="button" value="등록" onclick=
	  "location.href='EmployeesServlet?command=employees_write_form'">
   </form>
</div>
</body>
</html>