package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;
import com.saeyan.dto.ReplyVO;

import util.DBManager;

public class BoardDAO {
	private BoardDAO(){	}
	
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
//	게시판 검색
	public List<BoardVO> selectAllBoards(int pageno){
		//String sql = "select * from board order by num desc";
		String sql = "select x.* from "
				+ "(select rownum as rnum, a.* from "
				+ "(select * from board order by num desc) a where rownum<=?) x "
				+ "where x.rnum>=?";
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pageno*10);
			pstmt.setInt(2, (pageno-1)*10+1);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				list.add(bVo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt,rs);
		}	
		return list;
	}
	
	
//	게시판 등록
	public void insertBoard(BoardVO bVo) {
		String sql = "insert into board(num,name,email,pass,title,content) values (board_seq.nextval,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail() );
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt);
		}	
	}
	
	//게시판 업데이트
	
	public void updateReadCount(String num) {
		String sql = "update board set readcount=readcount+1 where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt);
		}	
	}
	
	//게시판 글 상세 내용 보기 : 글번호로 찾아온다 , 실패 : null
	public BoardVO selectOneBoardByNum(String num) {
		String sql="select * from board where num = ?";
		BoardVO bVo = null;
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setPass(rs.getString("pass"));
				bVo.setEmail(rs.getString("email"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				bVo.setReadcount(rs.getInt("readcount"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt,rs);
		}	
		return bVo;
	}
	
	public BoardVO checkPassWord(String pass,String num) {
		String sql = "select * from board where pass=? and num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO bVo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bVo = new BoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setPass(rs.getString("pass"));
				bVo.setEmail(rs.getString("email"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				bVo.setReadcount(rs.getInt("readcount"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt,rs);
		}	
		return bVo;
	}
	
	//no로 댓글 찾아온다.
		public ReplyVO selectOneReplyByNo(String no) {
			String sql="select * from reply where no = ?";
			ReplyVO rVo = null;
			Connection conn=null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, no);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					rVo = new ReplyVO();
					rVo.setNo(rs.getInt("no"));
					rVo.setpNum(rs.getInt("pNum"));
					rVo.setName(rs.getString("name"));
					rVo.setPassword(rs.getString("password"));
					rVo.setContent(rs.getString("content"));
					rVo.setWritedate(rs.getTimestamp("writedate"));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn,pstmt,rs);
			}	
			return rVo;
		}
	
//	
	public ReplyVO replyCheckPassWord(String pass,String num) {
		String sql = "select * from reply where password=? and no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReplyVO rVo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rVo = new ReplyVO();
				rVo.setNo(rs.getInt("no"));
				rVo.setpNum(rs.getInt("pNum"));
				rVo.setName(rs.getString("name"));
				rVo.setPassword(rs.getString("password"));
				rVo.setContent(rs.getString("content"));
				rVo.setWritedate(rs.getTimestamp("writedate"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt,rs);
		}	
		return rVo;
	}
//	
	
	public void updateBoard(BoardVO bVo) {
		String sql = "update board set name=?,email=?,pass=?,title=?,content=? where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			pstmt.setInt(6, bVo.getNum());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt);
		}	
	}
	
//	update reply
	public void updateReply(ReplyVO rVo) {
		String sql = "update reply set name=?,password=?,content=? where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rVo.getName());
			pstmt.setString(2, rVo.getPassword());
			pstmt.setString(3, rVo.getContent());
			pstmt.setInt(4, rVo.getNo());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt);
		}	
	}
	
	public void deleteBoard(String num) {
		String sql = "delete board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt);
		}
	}
	
	//Page 구현을 위해 게시글의 개수를 구해주는 코드
	public int selectCountBoard() {
		String sql = "select count(*) as recordCount from board";
		
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs = null;
		int recordCount=0;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				recordCount = rs.getInt("recordCount");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,stmt,rs);
		}
		return recordCount; //VO 리턴
	}
	
	public List<ReplyVO> selectAllReplys(int pNum){
		String sql = "select * from reply where pNum = ? order by no";
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pNum);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO rVo = new ReplyVO();
				rVo.setNo(rs.getInt("no"));
				rVo.setpNum(rs.getInt("pNum"));
				rVo.setName(rs.getString("name"));
				rVo.setPassword(rs.getString("password"));
				rVo.setContent(rs.getString("content"));
				rVo.setWritedate(rs.getTimestamp("writedate"));
				list.add(rVo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt,rs);
		}	
		return list;
	}
	
	public void insertReply(ReplyVO rVo) {
		String sql="insert into reply(no,pNum,name,password,content) "
				+"values(reply_seq.nextval,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);			
			
			pstmt.setInt(1, rVo.getpNum());
			pstmt.setString(2, rVo.getName());
			pstmt.setString(3, rVo.getPassword());
			pstmt.setString(4, rVo.getContent());
			
			pstmt.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
}
