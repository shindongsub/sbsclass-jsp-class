package com.sbs.board.article.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbs.board.Controller;
import com.sbs.board.Service;
import com.sbs.board.article.service.ArticleService;

import lombok.Data;
@Component
@Data
public class ArticleController extends Controller{
	@Autowired
	private ArticleService service;

	public String doActon(HttpServletRequest request, HttpServletResponse response, String action) throws IOException {
		if(action.equals("list.do")) {
//			ApplicationContext ac= new ClassPathXmlApplicationContext("com/sbs/config/spring-config.xml");
//			ArticleDao2 dao = ac.getBean(ArticleDao2.class);
//			service.setDao(dao);
						
			request.setAttribute("articles", service.getAllArticles());
			return "list";
		}else {
			response.getWriter().println("잘못된 요청입니다!!");
			return null;
		}
	}
	public void setService(ArticleService service) {
		this.service = service;
	}

}
