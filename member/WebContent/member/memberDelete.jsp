<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<script src="script/member.js"></script>
</head>
<body>
 <h2>회원 수정</h2>
<form name=frm action="memberDelete.do" method="post">
정말 탈퇴 하시겠습니까?
    		<input type="submit" value="확인">
    		<input type="reset" value="취소" onclick="location.href='login.do'">
</form>

</body>
</html>