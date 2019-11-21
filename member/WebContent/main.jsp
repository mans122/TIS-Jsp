<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty loginUser}">
	<jsp:forward page='login.do' />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<script src="member.js"></script>
</head>
<body>
<form action="logout.do">
	<table>
		<tr>
			<td>안녕하세요 ${loginUser.name}(${loginUser.userid})님
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그아웃">
				<input type="button" value="회원정보변경" onclick="location.href='memberUpdate.do'">
				<input type="button" value="회원탈퇴" onclick="location.href='memberDelete.do'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>