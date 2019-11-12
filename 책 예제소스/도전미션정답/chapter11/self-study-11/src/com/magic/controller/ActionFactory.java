package com.magic.controller;

import com.magic.controller.action.Action;
import com.magic.controller.action.EmployeesDeleteAction;
import com.magic.controller.action.EmployeesListAction;
import com.magic.controller.action.EmployeesUpdateAction;
import com.magic.controller.action.EmployeesUpdateFormAction;
import com.magic.controller.action.EmployeesViewAction;
import com.magic.controller.action.EmployeesWriteAction;
import com.magic.controller.action.EmployeesWriteFormAction;

public class ActionFactory {
  private static ActionFactory instance = new ActionFactory();

  public ActionFactory() {
    super();
  }

  public static ActionFactory getInstance() {
    return instance;
  }

  public Action getAction(String command) {
    Action action = null;
    System.out.println("ActionFactory  :" + command);
    if (command.equals("employees_list")) {
      action = new EmployeesListAction();
    } else if (command.equals("employees_write_form")) {
      action = new EmployeesWriteFormAction();
    } else if (command.equals("employees_write")) {
      action = new EmployeesWriteAction();
    } else if (command.equals("employees_view")) {
      action = new EmployeesViewAction();
    } else if (command.equals("employees_update_form")) {
      action = new EmployeesUpdateFormAction();
    } else if (command.equals("employees_update")) {
      action = new EmployeesUpdateAction();
    } else if (command.equals("employees_delete")) {
      action = new EmployeesDeleteAction();
    } 
    return action;
  }
}
