package com.magic.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;


public class EmployeesUpdateFormAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = "/employee/employeesUpdate.jsp";

    String id = request.getParameter("id");

    EmployeesDAO eDao = EmployeesDAO.getInstance();

    EmployeesVO employee = eDao.getMember(id);

    request.setAttribute("employee", employee);

    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }
}
