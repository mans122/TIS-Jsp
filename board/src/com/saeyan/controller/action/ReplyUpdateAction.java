package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.ReplyVO;

public class ReplyUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyVO rVo = new ReplyVO();
		int pNum = Integer.parseInt(request.getParameter("pnum"));
		rVo.setNo(Integer.parseInt(request.getParameter("no")));
		rVo.setName(request.getParameter("name"));
		rVo.setPassword(request.getParameter("password"));
		rVo.setContent(request.getParameter("content"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateReply(rVo);
		
		String url = "BoardServlet?command=board_view&num="+pNum;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
