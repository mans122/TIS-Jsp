<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Layout</title>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	background-color: #4c320d;
}

#wrap {
	width: 800px;
	margin: auto;
}

#top {
	width: 800px;
	height: 10px;
	background-image: url("../img/top.jpg");
}

#header {
	width: 800px;
	height: 100px;
	background-image: url("../img/header.jpg");
	padding: 20px;
	box-sizing: border-box;
}

#menu {
	width: 800px;
	height: 30px;
	background-image: url("../img/menu.jpg");
	padding-left: 20px;
	padding-top: 2px;
	box-sizing: border-box;
}

#content {
	width: 800px;
	height: 600px;
	background-image: url("../img/content.jpg");
	padding-left: 20px;
	box-sizing: border-box;
}

#bottom {
	width: 800px;
	height: 20px;
	background-image: url("../img/bottom.jpg");
}

#left {
	width: 650px;
	float: left;
}

#footer {
	width: 800px;
	text-align: center;
	color: white;
}
</style>
</head>
<body>
	<div id="wrap">
		<div id="top"></div>
		<div id="header">
			<h1>TIS 정보기술교육센터</h1>
		</div>
		<%@ include file="Practice02_nav.jsp" %>
		<div id="content">
			<div id="left">
				<h3>TIS정보기술교육센터 소개</h3>
				<img src="../img/tis/visual_1.jpg" alt="교육원 소개">
			</div>
			<div id="right">
				<ul>
					<li>Email</li>
					<li>Board</li>
					<li>Contatct</li>
				</ul>
			</div>
		</div>
		<div id="bottom"></div>
		<footer id="footer"> copyright </footer>
	</div>
</body>

</html>