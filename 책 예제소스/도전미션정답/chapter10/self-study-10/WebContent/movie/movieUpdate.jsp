<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>영화 수정</title>
</head>
<body>
<div id="wrap" align="center">
<h1>정보 수정</h1>
<form enctype="multipart/form-data" method="post" action=>
<input type="hidden" name="code" value="${movie.code }">
<input type="hidden" name="nonmakeImg" value="${movie.poster }">
  <table>
    <tr>
     <td>
     <c:choose>
     	<c:when test="${empty movie.poster}">
     		<img src="images/noimage.gif">
     	</c:when>
     	<c:otherwise>
     		<img src="images/${movie.poster}" width="200" height="300">
     	</c:otherwise>
     </c:choose>
 	
     </td>
     <td>
       <table>
        <tr>
          <th style="width: 80px">제  목</th>
          <td><input type="text" name="mtitle" value="${movie.title }" size="80"></td>
        </tr>
        <tr>
           <th>가 격</th>
           <td><input type="text" name="price" value="${movie.price }"> 원</td>
        </tr>
        <tr>
           <th>감 독</th>
            <td><input type="text" name="director" value="${movie.director }" size="80"></td>
           <td></td>
        </tr> 
        <tr>
           <th>배  우</th>
           <td><input type="text" name="actor" value="${movie.actor }" size="80"></td>
        </tr>
        <tr>
           <th>시놉시스</th>
           <td>
            <textarea cols="90" rows="10" name="synopsis">${movie.synopsis }</textarea>
           </td>
        </tr>
        <tr>
        	<th>사  진</th>
	        <td>
	        <input type="file" name="poster"  ><br>
	        </td>
        </tr>
      </table> 
	 </td>
    </tr>
  </table>	
  <br>
  
  <input type="submit" value="수정" >
  <input type="button" value="목록" onclick="location.href='movielist.do'">
 </form> 
</div>
</body>
</html>