package com.sbs.board.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbs.board.Service;
import com.sbs.board.article.dao.Article;
import com.sbs.board.article.dao.ArticleDao;
import com.sbs.board.article.dao.Dao;


@Component
public class ArticleService implements Service{
//	Dao dao;
	@Autowired
	private ArticleDao dao;
	
	public List<Article> getAllArticles() {
		return dao.getAllArticles();
		
	}
	public void setDao(ArticleDao dao){ //의존성 주입. DI -dependency injection
		// 1. xml
		this.dao = dao;
		
		
		// 2. java
		
		
	}
	
	
}
