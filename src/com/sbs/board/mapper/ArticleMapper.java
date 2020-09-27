package com.sbs.board.mapper;

import java.util.List;
import java.util.Map;

import com.sbs.board.Reply;
import com.sbs.board.article.dao.Article;

public interface ArticleMapper {
	
	List<Article> getAllArticle();
	List<Article> getAllArticles();
	Article getArticleById(int id);
	List<Reply> getReplyById(int id);
//	void insertArticle(Map paraMap);
	void insertArticle2(Article article);
	void updateArticle(Map paraMap);
	void addReply(Map paramap);
	List<Article> getCurrentPage(int start);
}
