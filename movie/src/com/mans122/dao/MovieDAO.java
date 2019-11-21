package com.mans122.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mans122.dto.MovieVO;

import util.DBManager;

public class MovieDAO {

	private static MovieDAO instance = new MovieDAO();
	public static MovieDAO getInstance() {
		return instance;
	}
	public List<MovieVO> selectAllmovies() {
		String sql = "select * from movie order by code desc";
		List<MovieVO> list = new ArrayList<MovieVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){ //이동은 행 단위로
				MovieVO mVo = new MovieVO();
				mVo.setCode(rs.getInt("code"));
				mVo.setTitle(rs.getString("title"));
				mVo.setPrice(rs.getInt("price"));
				mVo.setDirector(rs.getString("director"));
				mVo.setActor(rs.getString("actor"));
				mVo.setPoster(rs.getString("poster"));
				mVo.setSynopsis(rs.getString("synopsis"));
				list.add(mVo);
				System.out.print("DAO 성공");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt,rs);
		}
		return list;
	}
	
	public void insertMovie(MovieVO mVo) {
		String sql = "insert into movie values(product_seq.nextval,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn=DBManager.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getTitle());
			pstmt.setInt(2, mVo.getPrice());
			pstmt.setString(3, mVo.getDirector());
			pstmt.setString(4, mVo.getActor());
			pstmt.setString(5, mVo.getPoster());
			pstmt.setString(6, mVo.getSynopsis());
			pstmt.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt);
		}
	}
	
	public MovieVO selectMovieByCode(String code) {
		String sql = "select * from movie where code=?";
		MovieVO mVo = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs= null;
			try {
				conn=DBManager.getConnection();
				pstmt =conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					mVo = new MovieVO();
					mVo.setCode(rs.getInt("code"));
					mVo.setTitle(rs.getString("title"));
					mVo.setPrice(rs.getInt("price"));
					mVo.setDirector(rs.getString("director"));
					mVo.setActor(rs.getString("actor"));
					mVo.setPoster(rs.getString("poster"));
					mVo.setSynopsis(rs.getString("synopsis"));
				}

			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn,pstmt);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mVo;
	}
	public void deleteMovie(String code) {
		String sql = "delete from movie where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn=DBManager.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(code));
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt);
		}
	}
	
}

