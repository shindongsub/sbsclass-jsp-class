package com.sbs.board;

import java.util.List;

import com.sbs.board.article.dao.Article;
import com.sbs.board.article.dao.ArticleDao;

public interface Service {
	void setDao(ArticleDao dao);
	List<Article> getAllArticles();


}
