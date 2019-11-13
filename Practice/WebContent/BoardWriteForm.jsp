<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원의 정보 입력 폼</h2>
<form method="post" action="BoardWriteNew.jsp" style="width:500px;border:1px solid black;">

	<table>
		<tr>
			<td>작성자 </td>
			<td><input type="text" name="name" size="20"></td>
		</tr>
		
		<tr>
			<td>비밀번호 </td>
			<td><input type="password" name="pwd" size="20"> (게시물 수정/삭제시 필요합니다.)</td>
		</tr>
		
		<tr>
			<td>이메일 </td>
			<td><input type="text" name="email" size="40"></td>
		</tr>
		
		<tr>
			<td>글 제목 </td>
			<td><input type="text" name="title" size="50"></td>
		</tr>
		
		<tr>
			<td>글 내용 </td>
			<td><textarea name="contents" cols="55" rows="8" ></textarea></td>
		</tr>
		
		
		
		<tr>
			<td><input type="submit" value="등록"></td>
			<td><input type="reset" value="다시작성"></td>
		</tr>
	</table>
</form>
</body>
</html>