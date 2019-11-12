package Practice01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practice01
 */
@WebServlet("/Practice01")
public class Practice01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Practice01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out=response.getWriter();
//		out.print("<h1> email "+request.getParameter("email")+"</h1>");
//		out.print("<h1> psw "+request.getParameter("psw")+"</h1>");
//		out.print("<h1> pswchk "+request.getParameter("pswchk")+"</h1>");
//		out.print("<h1> usrnm "+request.getParameter("usrnm")+"</h1>");
//		out.print("<h1> phone "+request.getParameter("phone")+"</h1>");
//		out.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<h1> email "+request.getParameter("email")+"</h1>");
		out.print("<h1> psw "+request.getParameter("psw")+"</h1>");
		out.print("<h1> pswchk "+request.getParameter("pswchk")+"</h1>");
		out.print("<h1> usrnm "+request.getParameter("usrnm")+"</h1>");
		out.print("<h1> phone "+request.getParameter("phone")+"</h1>");
		out.close();
	
	
	}

}
