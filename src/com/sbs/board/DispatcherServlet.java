package com.sbs.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			controller = new ArticleController(request, response, action);
		}else if(module.equals("member")) {
			controller = new MemberController(request, response, action);
		}
		String rst = controller.doActon();
		if(rst != null) {
			request.getRequestDispatcher(rst).forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
