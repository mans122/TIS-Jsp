package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;
import com.saeyan.dto.ReplyVO;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/boardView.jsp";
//		System.out.println("test");
//		String num = request.getParameter("num");
		BoardDAO bDao = BoardDAO.getInstance();
		
		//글번호를 받음.글목록에서 글제목을 클릭했을 때.
		String num=null;
		if(request.getParameter("num")!=null){
			 num=request.getParameter("num");
		}		
		
		//댓글을 등록한 후 상세보기로 넘어갈 때
		if(request.getAttribute("num")!=null){
			num=(String) request.getAttribute("num");
		};
		
		
		
		int pNum = Integer.parseInt(num);
		
		bDao.updateReadCount(num); //조회수 증가
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		
		request.setAttribute("board", bVo);
		
		//댓글목록
		List<ReplyVO> replyList = bDao.selectAllReplys(pNum);
		request.setAttribute("replyList", replyList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}


