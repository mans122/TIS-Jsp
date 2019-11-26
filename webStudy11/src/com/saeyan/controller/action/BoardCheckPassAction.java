package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=null;
		
		//글번호와 비밀번호를 받음
		String num=request.getParameter("num");
		String pass=request.getParameter("pass");
		
		//글번호로 글상세 내용 조회
		BoardDAO bDao=BoardDAO.getInstance();
		BoardVO bVo=bDao.selectOneBoardByNum(num);
		
		//비밀번호 비교
		if(bVo.getPass().equals(pass)){
			//일치하는 경우
			url="/board/checkSuccess.jsp";
		}else{
			//일치하지 않는 경우
			url="/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
		}
		
		//포워딩
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
				
				
		
	}

}
