package com.seoil.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoil.dao.MovieDAO;
import com.seoil.dto.MovieVO;

@WebServlet("/movielist.do")
public class MovieList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "movie/movieList.jsp";
		
		MovieDAO productDAO = MovieDAO.getInstance();
		ArrayList<MovieVO> mlist = productDAO.selectAllMovie();
		
		request.setAttribute("mlist", mlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
