<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script src="script/board.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>댓글수정</h1>
<form name="frm" action="BoardServlet" method="post">
			<input type="hidden" name="no" value="${reply.no}">
			<input type="hidden" name="pnum" value="${reply.pNum}">
			<input	type="hidden" name="command" value="reply_update">
			<table>
				<tr><td>작성자</td><td><input type="text" name="name" value="${reply.name }"></td></tr>
				<tr><td>비밀번호</td><td><input type="password" name="password" value="${reply.password}"></td></tr>
				<tr><td>내용</td><td><textarea name="content" rows="5" cols="60"></textarea></td></tr>
				<tr><td colspan="2"><input type="submit" value="댓글수정"	onclick="return replyCheck()"></td>	</tr>
			</table>
		</form>
</div>
</body>
</html>