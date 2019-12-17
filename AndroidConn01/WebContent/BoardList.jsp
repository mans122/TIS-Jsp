<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!//선언부는 첫 방문자에 의해서 단 한번 수행함.
//{"list":[{"num":""+rs.getString("num")"","title":""+rs.getString("title")+""}]}
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	String url = "jdbc:oracle:thin:@localhost:1521:myoracle";
	String uid = "ora_user";
	String pass = "hong";
	String sql;
%>
<%
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, uid, pass);
		
		sql = "select num,title from board order by num desc";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		String result="";

		while(rs.next()){
			if(!result.equals("")){
				result+=",";
			}
			result+="{\"num\":\""+rs.getString("num")+"\",\"title\":\""+rs.getString("title")+"\"}";
		}
		result="{\"list\":["+result+"]}";
		out.print(result);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} //finally 끝
%>