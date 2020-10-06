package com.sbs.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sbs.board.article.controller.ArticleController;

@Component
public class HandlerMapping {

	Map<String, Controller> controllers;
	
	public HandlerMapping() {
		controllers = new HashMap<>();
		controllers.put("article", new ArticleController());
	}
	
	public Controller getController(String url) {
		return controllers.get(url);
	}
}