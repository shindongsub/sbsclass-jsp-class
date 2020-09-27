package com.sbs.board.article.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.board.Controller;
import com.sbs.board.article.service.ArticleService;

public class ArticleController extends Controller{
	
	ArticleService service = new ArticleService();
	
	public ArticleController(HttpServletRequest request, HttpServletResponse response, String action){
		super(request, response, action);
	}
	public String doActon() throws IOException {
		if(action.equals("list.do")) {
			request.setAttribute("articles", service.getAllArticles());
			return "/article/listprint.jsp";
		}else {
			response.getWriter().println("잘못된 요청입니다!!");
			return null;
		}
	}

}
