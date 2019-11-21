package practice05.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice05.dao.PriceDAO;
import practice05.dto.PriceVO;

/**
 * Servlet implementation class PriceServlet
 */
@WebServlet("/price.do")
public class PriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("practice05_form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		
		PriceVO pVo = new PriceVO();
		pVo.setName(name);
		pVo.setPrice(Integer.parseInt(price));
		pVo.setDescription(description);
		
		PriceDAO pDao = PriceDAO.getInstance();
		int result = pDao.insertPrice(pVo);
		
		if(result==1) {
			request.setAttribute("message", "성공");
		}
		else {
			request.setAttribute("message", "실패");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("practice05_form.jsp");
		dispatcher.forward(request, response);
	}

}
