package com.saeyan.controller;

import com.saeyan.controller.action.*;

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
		System.out.println("ActionFactory : "+command);
		//이곳부터 command로 구분해서 원하는 Action Class 호출하는 내용 작성
		if(command.equals("board_list")) {
			action = new BoardListAction();
		}
		else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}
		else if(command.equals("board_write_form")){
			action = new BoardWriteFormAction();
		}
		else if(command.equals("board_view")) {
			action = new BoardViewAction();
		}else if(command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		}else if(command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		}else if(command.contentEquals("board_update_form")) {
			action = new BoardUpdateFormAction();
		}else if(command.contentEquals("board_update")) {
				action = new BoardUpdateAction();
		}else if(command.contentEquals("board_delete")) {
			action = new BoardDeleteAction();
		}else if(command.contentEquals("reply_write")) {
			action = new ReplyWriteAction();
		}else if(command.equals("reply_check_pass_form")) {
			action = new ReplyCheckPassFormAction();
		}else if(command.equals("reply_check_pass")) {
			action = new ReplyCheckPassAction();
		}else if(command.contentEquals("reply_update_form")) {
			action = new ReplyUpdateFormAction();
		}else if(command.contentEquals("reply_update")) {
				action = new ReplyUpdateAction();
		}
//		else if(command.contentEquals("reply_delete")) {
//			action = new ReplyDeleteAction();
//		}
		//내용 끝
		return action;
	}
}
