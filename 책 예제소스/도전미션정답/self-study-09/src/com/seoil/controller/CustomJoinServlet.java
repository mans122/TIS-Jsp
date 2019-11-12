package com.seoil.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoil.dao.EmployeesDAO;
import com.seoil.dto.EmployeesVO;

/**
 * Servlet implementation class CustomJoinServlet
 */
@WebServlet("/custom.do")
public class CustomJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String url = null;
		EmployeesVO emp = (EmployeesVO)session.getAttribute("emp");
		
		if(emp == null){
			url = "notuser.jsp";
		}else{
			if(emp.getLev().equals("C")){
				url = "notuser.jsp";
			}else{
				url = "customjoin.jsp";
			}
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month= cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		
		// year가 현재 yyyy 형태 -> db에 넣으려면 yy로 바꿔야한다.. how?
		String enter="TO_DATE('"+year+"/"+month+"/"+day+"','yy/MM/dd')";
		
		request.setCharacterEncoding("EUC-KR");
		EmployeesVO member = new EmployeesVO();
		member.setId(request.getParameter("userid"));
		member.setPass(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		member.setLev(request.getParameter("lev"));
		member.setEnter(cal.getTime());
		EmployeesDAO memberDAO = EmployeesDAO.getInstance();
		memberDAO.insertMember(member);
		response.sendRedirect("join.do");
	}

}
