package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;
import com.saeyan.dto.ReplyVO;

public class BoardViewAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/board/boardView.jsp";
		//글번호를 받음. 글 목록에서 글제목을 클릭했을 때
		String num = null;
		if(request.getParameter("num")!=null) {
			num = request.getParameter("num");
		}
		//댓글 등록 후 상세보기로 넘어갈 때
		if(request.getAttribute("num")!=null) {
			num=(String)request.getAttribute("num");
		}
		
		//부모 글번호 지정
		int pNum = Integer.parseInt(num);
		BoardDAO bDao = BoardDAO.getInstance();
		
		
//		String num = request.getParameter("num");
//		BoardDAO bDao = BoardDAO.getInstance();
		
		//쿠키변수를 만들어서 값을 저장, 쿠키변수에 값이 있으면 조회수 증가 실행하지 않음.
		boolean isGet=false;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) { 
				//num쿠키가 있는경우
				if(cookies[i].getName().equals(num)) {
					isGet=true;
				}
			}
			//쿠키가 없는 경우
			if(!isGet) {
				bDao.updateReadCount(num);//조회수 증가
				Cookie c1=new Cookie(num,num);
				response.addCookie(c1);
			}
		}
		//글 상세보기
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		request.setAttribute("board", bVo);
		//댓글목록
		List<ReplyVO> replyList = bDao.selectAllReplys(pNum);
		request.setAttribute("replyList", replyList);
		
		//상세페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
