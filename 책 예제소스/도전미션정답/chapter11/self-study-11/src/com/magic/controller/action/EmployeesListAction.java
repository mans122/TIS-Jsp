package com.magic.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;



public class EmployeesListAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = "/employee/employeesList.jsp";
    
    EmployeesDAO bDao=EmployeesDAO.getInstance();
    
    List<EmployeesVO> EmployeesList = bDao.selectAllEmployeess();
      
    request.setAttribute("elist", EmployeesList);
      
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }
}
