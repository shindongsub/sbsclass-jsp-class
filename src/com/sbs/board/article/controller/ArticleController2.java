package com.sbs.board.article.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.sbs.board.article.service.ArticleService;

public class ArticleController2 implements org.springframework.web.servlet.mvc.Controller{
	@Autowired
	ArticleService service;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", service.getAllArticles());
		mav.setViewName("list");
		
		return mav;
	}

}
