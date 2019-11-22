<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String bbsno = request.getParameter("bbsno");
Cookie[] cookies = request.getCookies();
Cookie viewCookie = null;

if(cookies != null && cookies.length>0){
	for(int i=0; i<cookies.length;i++){
		if(cookies[i].getName().equals("VIEWCOOKIE")){
			viewCookie=cookies[i];
		}
	}
}

if(viewCookie == null){
	System.out.println("viewcookie없음");
	Cookie newCookie = new Cookie("VIEWCOOKIE",bbsno);
	response.addCookie(newCookie);
}else{
	System.out.println("viewcookie있음");
	String value=viewCookie.getValue();
	
	if(value.indexOf(bbsno)<0){
		value=value+bbsno;
		viewCookie.setValue(value);
		response.addCookie(viewCookie);
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>