<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	if(window.name=="update"){
		//window.opener.parent.location.href="BoardServlet?command=reply_update_form&num=${reply.num}";
		window.opener.parent.location.href="BoardServlet?command=reply_update_form&no=${param.no}";
	}else if(window.name=='delete'){
		alert("삭제되었습니다.");
		window.opener.parent.location.href="BoardServlet?command=reply_delete&no=${param.no}";
	}
	window.close();
</script>
</body>
</html>