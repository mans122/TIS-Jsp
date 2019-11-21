<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String[] movieList= {"타이타닉","시네마 천국","혹성 탈출","킹콩"};
pageContext.setAttribute("movieList", movieList);
%>
<table border="1" style="width:100%; text-align:center;">
	<tr>
		<th> index </th> <th>count </th> <th> title </th>
	</tr>
<c:forEach var="movie" items="${movieList}" varStatus="status">
	<tr>
		<td> ${status.index} </td>
		<td> ${status.count} </td>
		<td> ${movie} </td>
	</tr>
</c:forEach>
</table>	

<table border="1" style="width:100%; text-align:center;">
	<tr>
		<th> index </th> <th>count </th> <th> cnt </th>
	</tr>
<c:forEach var="cnt" begin="7" end="10" varStatus="status">
	<tr>
		<td> ${status.index} </td>
		<td> ${status.count} </td>
		<td> ${cnt} </td>
	</tr>
</c:forEach>
</table>
<br><br>
<table border="1" style="width:100%; text-align:center;">
	<tr>
		<th> index </th> <th>count </th> <th> cnt </th>
	</tr>
<c:forEach var="cnt" begin="1" end="10" varStatus="status" step="2">
	<tr>
		<td> ${status.index} </td>
		<td> ${status.count} </td>
		<td> ${cnt} </td>
	</tr>
</c:forEach>
</table>

<c:forTokens var="info" items="서울.인천,대구.부산" delims=",">
${info} <br>
</c:forTokens>

	<c:forTokens var="info" items="서울.인천,대구.부산" delims=",">
		<c:forTokens var="data" items="${info}" delims=".">
			${data} <br>
		</c:forTokens>
	</c:forTokens>
</body>
</html>