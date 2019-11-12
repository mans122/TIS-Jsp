package com.seoil.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoil.dao.EmployeesDAO;
import com.seoil.dto.EmployeesVO;
@WebServlet("/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MypageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="mypage.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
		
		EmployeesVO eVo = new EmployeesVO();
		eVo.setId(request.getParameter("userid"));
		eVo.setPass(request.getParameter("pwd"));
		eVo.setName(request.getParameter("name"));
		eVo.setLev(request.getParameter("lev"));
		eVo.setEnter(cal.getTime());
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		eDao.updateMember(eVo);
		
		response.sendRedirect("mypage.jsp");
	}

}

