package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;
import com.saeyan.dto.ReplyVO;

import util.DBManager;

public class BoardDAO {
	private BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardVO> selectAllBoards(int pageno){
//		String sql = "select * from board order by num desc";		
		String sql="select  X.*"
				+ "	from ( "
				+ "	    select rownum as rnum, A.*"
				+ "	    from ("
				+ " 	        select *"
				+ "		        from board"
				+ "		        order by num desc"
				+ "	        ) A"
				+ "	    where rownum <= ?) X"
				+ "	where X.rnum >= ?";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageno*10);
			pstmt.setInt(2, (pageno-1)*10+1);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	//글 등록
	public void insertBoard(BoardVO bVo) {
		String sql = "insert into board("
				+ "num, name, email, pass, title, content) "
				+ "values(board_seq.nextval, ?,?,?,?,?)";

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
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	//게시판 글 상세 내용보기 : 글번호로 찾아옴 : 실패 null
	public BoardVO selectOneBoardByNum(String num) {
		String sql = "select * from board where num =?";
		
		BoardVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}
	
	
	//비밀번호 확인, 사용안함
	public BoardVO checkPassWord(String pass, String num) {
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
			
			if (rs.next()) {
				bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bVo;
	}
	
	
	
	public void updateBoard(BoardVO bVo) {
		String sql = "update board set name=?, email=?, pass=?, title=?, content=? where num=?";
		
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
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	
	
	
	//조회수 업데이트
	public void updateReadCount(String num) {
		String sql = "update board set readcount=readcount+1 where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	
	//삭제
	public void deleteBoard(String num) {
		String sql = "delete board where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//전체 레코드 수 구하기
	public int selectCountBoard() {
		int recordCount=0;
		String sql="select count(*) as recordCount from board";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				recordCount = rs.getInt("recordCount");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recordCount;
	}
	
	
	
	//댓글목록
	public List<ReplyVO> selectAllReplys(int pNum){
		String sql = "select * from reply where pNum=? order by no";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pNum);				
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReplyVO rVo = new ReplyVO();
				rVo.setNo(rs.getInt("no"));
				rVo.setpNum(rs.getInt("pNum"));
				rVo.setName(rs.getString("name"));
				rVo.setPassword(rs.getString("password"));
				rVo.setContent(rs.getString("content"));
				rVo.setWritedate(rs.getTimestamp("writedate"));
				list.add(rVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	//댓글등록
	public void insertReply(ReplyVO rVo) {
		String sql = "insert into reply(no, pNum, name, password, content) "
				+ "values(reply_seq.nextval,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rVo.getpNum());
			pstmt.setString(2, rVo.getName());
			pstmt.setString(3, rVo.getPassword());
			pstmt.setString(4, rVo.getContent());
			
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
}
