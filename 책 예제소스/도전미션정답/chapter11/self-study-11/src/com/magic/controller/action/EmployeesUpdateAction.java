package com.magic.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

public class EmployeesUpdateAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {  
	request.setCharacterEncoding("UTF-8"); 
	
	System.out.println(request.getParameter("name"));
    EmployeesVO eVo = new EmployeesVO();

    eVo.setId(request.getParameter("id"));
    eVo.setPass(request.getParameter("pass"));
    eVo.setName(request.getParameter("name"));
    eVo.setLev(request.getParameter("lev"));		
    eVo.setGender(Integer.parseInt(request.getParameter("gender")));
    eVo.setPhone(request.getParameter("phone"));	
	
    EmployeesDAO eDao = EmployeesDAO.getInstance();
    eDao.updateMember(eVo);
    
    new EmployeesListAction().execute(request, response);
  }
}
