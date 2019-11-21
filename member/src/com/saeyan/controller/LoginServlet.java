package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/login.jsp";
		HttpSession session=request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			url="main.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/login.jsp";
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		//MemberDAO의 userCheck()을 통해서 로그인 처리
		MemberDAO mDao= MemberDAO.getInstance();
		int result = mDao.userCheck(userid,  pwd);
		if(result==1) {
			//세션변수 생성
			MemberVO mVo=mDao.getMember(userid);
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", mVo);
			url="main.jsp"; //main.jsp로 이동하기위해 url에 값 저장			
			//Redirect로 할 경우 Servlet으로 이동 후 Servlet에서 jsp를 열어준다.
			//response.sendRedirect("main.jsp");
		}else if(result==0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		//main.jsp로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
