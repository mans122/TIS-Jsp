package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//최초 pageno를 1로보내주면 아래 코드만으로도 충분하지만 최초에는 pageno를 보내주지 않기에 체크를 하고가는 코드로 작성한다.
		//int pageno = Integer.parseInt(request.getParameter("pageno"));
		
		int pageno;
		if(request.getParameter("pageno")!=null) {
			pageno=Integer.parseInt(request.getParameter("pageno"));
		}else {
			pageno=1;
		}
		
		String url="/board/boardList.jsp";
		BoardDAO bDao = BoardDAO.getInstance();
		List<BoardVO> boardList = bDao.selectAllBoards(pageno);
		int recordCount = bDao.selectCountBoard();
		request.setAttribute("boardList", boardList);
		request.setAttribute("recordCount", recordCount);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
