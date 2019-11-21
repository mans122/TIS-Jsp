<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script src="script/product.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>정보 수정</h1>
<form method="post" enctype="multipart/form-data" name="frm">
	<table>
		<tr>
			<td>
				<c:choose>
					<c:when test="${empty movie.poster}">
						<img src="images/noimage.png">
					</c:when>
					<c:otherwise>
						<img src="images/${movie.poster}">
					</c:otherwise>
				</c:choose>
			</td>
		
		<td>
			<table>
				<tr>
			<th>제목</th>
			<td><input type="text" name="title" size="80" value="${movie.title}" readonly="readonly"></td>
		</tr>
		
		<tr>
			<th> 가 격 </th>
			<td><input type="text" name="price" size="30" value="${movie.price}" readonly="readonly">원</td>
		</tr>
		
		<tr>
			<th> 감 독 </th>
			<td><input type="text" name="director" size="80" value="${movie.director}" readonly="readonly"></td>
		</tr>
		
		<tr>
			<th> 배 우 </th>
			<td><input type="text" name="actor" size="80" ${movie.actor} readonly="readonly"></td>
		</tr>
		
		<tr>
			<th> 설 명 </th>
			<td><textarea cols="80" rows="10" name="synopsis" readonly="readonly">${movie.synopsis}</textarea></td>
		</tr>
		
		<tr>
			<th> 사 진 </th>
			<td><input type="file" name="poster" readonly="readonly"></td>
		</tr>
		
			</table>
		</td>
	</tr>
	</table>
	<br>
	<input type="hidden" name="code" value="${movie.code}">
	<input type="submit" value="삭제">
	<input type="button" value="목록" onclick="location.href='movieList.do'">
</form>
</div>
</body>
</html>