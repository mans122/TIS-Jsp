package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "/board/boardList.jsp";
		
		int pageno=0;
		if (request.getParameter("pageno")!=null) {
			pageno = Integer.parseInt(request.getParameter("pageno"));
		} else {
			pageno=1;
		}

		BoardDAO bDao = BoardDAO.getInstance();
		
		List<BoardVO> boardList = bDao.selectAllBoards(pageno);
		
		int recordCount = bDao.selectCountBoard();
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("recordCount", recordCount);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
