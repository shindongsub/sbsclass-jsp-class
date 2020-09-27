package com.sbs.board.article.service;

import java.util.List;

import com.sbs.board.Service;
import com.sbs.board.article.dao.Article;
import com.sbs.board.article.dao.ArticleDao;

public class ArticleService extends Service{
	ArticleDao dao = new ArticleDao();
	
	public List<Article> getAllArticles() {
		return dao.getAllArticles();
		
	}
	
}
