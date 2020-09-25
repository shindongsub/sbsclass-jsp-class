package com.sbs.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends Controller{
	public MemberController(HttpServletRequest request, HttpServletResponse response, String action){
		super(request, response, action);
	}


	public String doActon() throws IOException {
//		if(action.equals("list.do")) {
//			request.setAttribute("article", mb.getAllArticles());
//			return "/article/listprint.jsp";
//		}else {
//			response.getWriter().println("잘못된 요청입니다!!");
			return null;
//		}
	}

}
