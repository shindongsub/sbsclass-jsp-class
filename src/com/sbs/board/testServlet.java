package com.sbs.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	ArticleDao dao = new ArticleDao();
	final String ARTICLEPATH = "article/";  //forwarding을 위해 변수로 만듬. final을 붙이면 수정못함.
	final String EXTENTION = ".jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = (String)request.getAttribute("msg");
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String cmd = request.getParameter("cmd");
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession();
		
		ServletContext application = request.getServletContext(); //session을 사용하기위해 지운다.
		
		if(cmd == null) {
			String url = ARTICLEPATH +"testjspl"+EXTENTION;
			forwarding(request, response, url);
//			response.sendRedirect("test?cmd=showlogin");
		}
//		String rst1 = (String)request.getAttribute("key");
//		String rst2 = (String)application.getAttribute("key");
//		if(rst1 == null) {
//			System.out.println("값이 없습니다.");
//		}else {
//			System.out.println(rst1);
//		}
//		if(rst2 == null) {
//			System.out.println("값이 없습니다.");
//		}else{
//			System.out.println(rst2);
//		}
		
		else if(cmd.equals("list")) {
//			List<Article> articles = dao.getAllArticles();
			//리퀘스트에 아티클스를 넣어놓은 상태.
			request.setAttribute("articles", dao.getAllArticles()); //리퀘스트에 아티클스를 넣어놓은 상태.

			//forwording 해야되는데, 해주는게 리퀘스트 디스펙쳐 requestdispatcher
//			RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/listprint.jsp");
//			dis.forward(request, response); 
			String url = ARTICLEPATH +"listprint"+EXTENTION;  //forwarding메서드를 만들어 간단하게 만들어놓은 상태
			forwarding(request, response, url);
		}
		else if(cmd.equals("add")) {
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			String nickname = request.getParameter("nickname");
			dao.insertArticle(title, body, nickname);
			response.sendRedirect("test?cmd=list");
		}
		else if(cmd.equals("addArticle")) {
			String url = ARTICLEPATH +"addArticle"+EXTENTION;
			forwarding(request, response, url);
		}
		else if(cmd.equals("update")) {
			String id = request.getParameter("id");
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			dao.updateArticle(id, title, body);
			

			response.sendRedirect("test?cmd=list");
		}
		else if(cmd.equals("updateArticle")) {
			String id = request.getParameter("id");
			Article article = dao.readArticle(id);
			request.setAttribute("article", article); 
			
			String url = ARTICLEPATH+"updateArticle"+EXTENTION; 
			forwarding(request, response, url);
		}
		else if(cmd.equals("delete")) {
			String[] ids = request.getParameterValues("ckb");

			for (int i=0; i<ids.length; i++) {
				System.out.println(ids[i]);
			}
			dao.deleteArticle(ids);
			response.sendRedirect("test?cmd=list");
		}
		else if(cmd.equals("read")) {
			String id = request.getParameter("id");
			Article article = dao.readArticle(id);
			request.setAttribute("article", article);
			
			List<Reply> reply = dao.getRepliesById(id);
			request.setAttribute("reply", reply);
			
			String url = ARTICLEPATH+"detailjsp"+EXTENTION;
			forwarding(request, response, url);
		}
		else if(cmd.equals("reply")) {
			String parentId = request.getParameter("parentId");
			String body = request.getParameter("body");
			String nickname = request.getParameter("nickname");
			dao.addReply(parentId, body, nickname);
			response.sendRedirect("test?cmd=read&id="+parentId);
		}
		else if(cmd.equals("addReply")) {
			String id = request.getParameter("parentId");
			Article article = dao.readArticle(id);
			request.setAttribute("article", article);
			
			String url = ARTICLEPATH +"reply"+EXTENTION;
			forwarding(request, response, url);
		}
		else if(cmd.equals("readReply")) {
			String id = request.getParameter("id");
			Reply reply = dao.readReply(id);
			request.setAttribute("reply", reply);
			
			String url = ARTICLEPATH+"updateReply"+EXTENTION;
			forwarding(request, response, url);
		}
		else if(cmd.equals("updateReply")) {
			String id = request.getParameter("id");
			String body = request.getParameter("body");
			String writer = request.getParameter("writer");
			dao.updateReply(id, body, writer);
			
			response.sendRedirect("test?cmd=list");
			
		}
		else if(cmd.equals("deleteReply")) {
			String id = request.getParameter("id");
			dao.deleteReplyById(id);
			response.sendRedirect("test?cmd=list");
		}
		else if(cmd.equals("showlogin")) {

			String url = ARTICLEPATH + "showlogin" + EXTENTION;
			forwarding(request, response, url);
		}
		else if(cmd.equals("dologin")) {
			
			String id1 = request.getParameter("id");
			String pw1 = request.getParameter("pw");
			Member member = dao.loginCheck(id1, pw1);
			List<Article> articles = dao.getAllArticles();
			request.setAttribute("articles", articles);
			if(member != null) {
				session.setAttribute("loginMember", member); //session으로 바꿈 어플리케이션을
				String url = ARTICLEPATH+"listprint"+EXTENTION;
				forwarding(request, response, url);
			}
//			String url = ARTICLEPATH+"listprint"+EXTENTION;
//			forwarding(request, response, url);
		}
		else if(cmd.equals("logout")) {
			session.invalidate();
//			application.removeAttribute("loginMember"); //session로그아웃으로 바꾸기위해 지움
			response.sendRedirect("test?cmd=showlogin");
		}
	}

	private void forwarding(HttpServletRequest request, HttpServletResponse response, String url) {
		RequestDispatcher req = request.getRequestDispatcher(url);
		try {
			req.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
