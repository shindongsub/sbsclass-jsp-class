package com.sbs.board;

import org.springframework.stereotype.Component;

@Component
public class ViewResolver {

	private String prefix = "/WEB-INF/";
	private String suffix = ".jsp";
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}