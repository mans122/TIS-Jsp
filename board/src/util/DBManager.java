package util;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Statement;

public class DBManager {
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Context initContext = new InitialContext();
			Context envContext= (Context)initContext.lookup("java:/comp/env");
			//jdbc/myoracle이란 이름을 객체가 찾아서 DataSource가 받는다
			DataSource ds=(DataSource)envContext.lookup("jdbc/myoracle");
			//ds를 생성했으면 Connection을 구해준다.
			conn=ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//select 수행 후 리소스 해제를 위한 메소드
	public static void close(Connection conn,Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//insert, update, delete 작업 수행 후 리소스 해제를 위한 메소드
	public static void close(Connection conn,Statement stmt) {
		try {
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
