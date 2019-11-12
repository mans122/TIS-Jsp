package com.seoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.seoil.dto.EmployeesVO;

public class EmployeesDAO {
	private EmployeesDAO() {
	}
	
	private static EmployeesDAO instance = new EmployeesDAO();
	
	public static EmployeesDAO getInstance() {
		return instance;
	}

	Connection getConnection(){
		Connection conn = null;
		Context initContext;
		
		try{
			initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			System.out.println("연결성공");
			
		}catch(NamingException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public int userCheck(String userid, String pwd, String admin){
		int result=1;
		Connection conn = null;
		String sql="SELECT * FROM employees WHERE id =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println(rs.getString("PASS"));
				System.out.println(rs.getString("LEV"));
				if(pwd.equals(rs.getString("PASS"))){
					if(admin.equals(rs.getString("LEV"))){
						result = 2;
						if(admin.equals("B")){
							result=3;
						}
					}else{
						result =1;
					}
				}else{
					result = 0;
				}
			}else{
				result = -1;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public EmployeesVO getMember(String userid){
		EmployeesVO member = null;
		
		Connection conn = null;
		String sql="select * from employees where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				member = new EmployeesVO();
				member.setPass(rs.getString("PASS"));
				member.setName(rs.getString("NAME"));
				member.setLev(rs.getString("LEV"));
				member.setId(rs.getString("ID"));
				member.setEnter(rs.getDate("ENTER"));
				member.setGender(rs.getInt("GENDER"));
				member.setPhone(rs.getString("PHONE"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
	
	public void insertMember(EmployeesVO member) {
		String sql = "insert into employees values(?,?,?,?,?,?,?)";
		// connection
		Connection conn = null;
		// preparedstatement
		PreparedStatement psmt = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);

			// ?에 값 세팅
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPass());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getLev());
			psmt.setTimestamp(5, new Timestamp(member.getEnter().getTime()));
			psmt.setInt(6, member.getGender());
			psmt.setString(7, member.getPhone());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int updateMember(EmployeesVO eVo) {
		int result = -1;
		String sql = "update employees set id=?, pass=?, name=?, lev=?, enter=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, eVo.getId());
			psmt.setString(2, eVo.getPass());
			psmt.setString(3, eVo.getName());
			psmt.setString(4, eVo.getLev());
			psmt.setTimestamp(5, new Timestamp(eVo.getEnter().getTime()));
			result = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
