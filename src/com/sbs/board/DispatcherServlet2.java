package com.sbs.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.protobuf.Service;
import com.sbs.board.article.controller.ArticleController;
import com.sbs.board.member.controller.MemberController;

@WebServlet("/ddf") //언어테이션
public class DispatcherServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/sbs/config/spring-config.xml");
		String uri = request.getRequestURI();
		
		String [] uris = uri.split("/");
		
		if(uris.length != 3) {
			response.getWriter().println("올바른 요청이 아닙니다.");
			return;
		}
		String module = uris[1];
		String action = uris[2];
		Controller controller = null;
		
		if(module.equals("article")) {
			controller = ac.getBean(ArticleController.class);
//			controller = new ArticleController(request, response, action);
			
		}else if(module.equals("member")) {
			controller = new MemberController(request, response, action);
		}
		String rst = controller.doActon(request, response, action);
		if(rst != null) {
			request.getRequestDispatcher(rst).forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	void forwarding(HttpServletRequest request, HttpServletResponse response, String path) {
		try {
			RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/list.jsp");
			req.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
