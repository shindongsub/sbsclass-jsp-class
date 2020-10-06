package com.sbs.board.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.board.Controller;
import com.sbs.board.member.service.MemberService;

public class MemberController extends Controller{
	
	MemberService service = new MemberService();

	
	public MemberController(HttpServletRequest request, HttpServletResponse response, String action){
		super(request, response, action);
	}


	public String doActon() throws IOException {
		if(action.equals("list.do")) {
			request.setAttribute("article", service.getAllMembers());
			return "/WEB-INF/list.jsp";
		}else {
			response.getWriter().println("잘못된 요청입니다!!");
			return null;
		}
	}

}
