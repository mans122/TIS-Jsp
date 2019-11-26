<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
    <script type="text/javascript">
    	//윈도우 이름이 update인 경우
    	if(window.name=="update"){
    		window.opener.parent.location.href=
    			"BoardServlet?command=board_update_form&num=${param.num}";
    	}else if(window.name=="delete"){
    		//윈도우 이름이 delete인 경우
    		window.opener.parent.location.href=
    			"BoardServlet?command=board_delete&num=${param.num}";
    	}
    	window.close();//창닫기
    </script>

    </body>
</html>