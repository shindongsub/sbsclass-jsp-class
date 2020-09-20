package com.sbs.board;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		
		String qstring = request.getQueryString();
		
		System.out.println(qstring);
		
		if(qstring != null && qstring.equals("cmd=addArticle")){
			if(session.getAttribute("loginMember") == null) {
				response.sendRedirect("/test?cmd=showlogin");
				return;
			}
			
		}
		
		chain.doFilter(req, res); //로그인이 안되있으면 넘어가서 이대로 진행할꺼고. 아니면 로그인필요
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
