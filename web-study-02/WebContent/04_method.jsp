<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function goServlet() {
		location.href = "MethodServlet?id=hkd";
	}
</script>
</head>
<body>
	<form method="get" action="MethodServlet">
		<input type="id" name="id"> <input type="submit"
			value="get 방식으로 호출">
	</form>
	<br>
	<br>
	<form method="post" action="MethodServlet">
		<input type="id" name="id"> <input type="submit"
			value="post 방식으로 호출">
	</form>
	<a href="MethodServlet?id=hkd">get방식 호출</a>
	<a href="#" onclick="goServlet()">javascript 호출</a>
</body>
</html>