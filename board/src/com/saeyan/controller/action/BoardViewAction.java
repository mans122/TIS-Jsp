package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardViewAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/board/boardView.jsp";
		String num = request.getParameter("num");
		BoardDAO bDao = BoardDAO.getInstance();
		
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
//				c1.setMaxAge(1*60*60);
				response.addCookie(c1);
			}
		}
		
//		bDao.updateReadCount(num);
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		request.setAttribute("board", bVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
