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
<h1>상품 수정 - 관리자 페이지</h1>
<form action="productDelete.do" method="post">
	<table>
		<tr>
			<td>
				<c:choose>
					<c:when test="${empty product.pictureUrl}">
						<img src="upload/noimage.png">
					</c:when>
					<c:otherwise>
						<img src="upload/${product.pictureUrl}">
					</c:otherwise>
				</c:choose>
			</td>
		
		<td>
			<table>
				<tr>
					<th>상 품 명</th>
					<td><input type="text" name="name" size="80" value="${product.name}"></td>
				</tr>
				
				<tr>
					<th> 가 격 </th>
					<td><input type="text" name="price" value="${product.price}">원</td>
				</tr>
				
				<tr>
					<th> 사 진 </th>
					<td><input type="file" name="pictureUrl"></td>
				</tr>
				
				<tr>
					<th> 설 명 </th>
					<td><textarea cols="80" rows="10" name="description" >${product.description}</textarea></td>
				</tr>
			</table>
		</td>
	</tr>
	</table>
	<br>
	<input type="hidden" name="code" value="${product.code}">
	<input type="reset" value="삭제">
	<input type="button" value="목록" onclick="location.href='productList.do'">
</form>
</div>
</body>
</html>