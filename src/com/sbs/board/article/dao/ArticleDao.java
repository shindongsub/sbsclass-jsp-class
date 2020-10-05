package com.sbs.board.article.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import com.sbs.board.Reply;
import com.sbs.board.mapper.ArticleMapper;

@Component
public class ArticleDao implements Dao{
	String resource = "com/sbs/config/mybatis-config.xml";
	SqlSession session = null;
	ArticleMapper mapper = null;
	
	private SqlSessionFactory sqlSessionFactory; //SqlSessionFactory하고 임포트하면된다.
	
	public ArticleDao() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);  //https://mybatis.org/mybatis-3/ko/getting-started.html  (세션펙토리빌드하기 3줄 복사)
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
	}
	
	public List<Article> getAllArticles() {
		getSession();
//		SqlSession session = sqlSessionFactory.openSession();
//		ArticleMapper mapper = session.getMapper(ArticleMapper.class );
		List<Article> article =  mapper.getAllArticles();

		return article;
	}
	public List<Article> getAllArticle(int currentPage) {
		getSession();
		int start = (currentPage - 1)*3;
		List<Article> article =  mapper.getCurrentPage(start);

		return article;
	}

//	public Article readArticle(int id) {
//		SqlSession session = sqlSessionFactory.openSession();
//		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
//		Article article = mapper.getArticleById(id);
//		
//		System.out.println(article.getTitle()); //consone창에 출력 
//		System.out.println(article.getBody());
//		return article;
//	}
//
//	public List<Reply> getRepliesById(int id) {
//		SqlSession session = sqlSessionFactory.openSession();
//		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
//		List<Reply> reply = mapper.getReplyById(id);
//		return reply;
//	}
//
//	public void insertArticle(String title, String body, String nickname) {
//		SqlSession session = sqlSessionFactory.openSession(true);
//		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
//		
//		//1. map  (1. 2번 으로 사용해야 여러개의 개체를 옮길 수 있다.)
////		Map<String, Object> paraMap = new HashMap<>();
////		paraMap.put("title", title);
////		paraMap.put("body", body);
////		paraMap.put("nickname", nickname);
////		mapper.insertArticle(paraMap);
//		
//		//2. dto
//		Article article = new Article();
//		article.setTitle(title);
//		article.setBody(body);
//		article.setNickname(nickname);
//		mapper.insertArticle2(article);
////		session.commit();
//	}
//
//	public void updateArticle(int id, String title, String body) {
//		SqlSession session = sqlSessionFactory.openSession(true);
//		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
//		Map<String, Object> paraMap = new HashMap<>();
//		paraMap.put("id", id);
//		paraMap.put("title", title);
//		paraMap.put("body", body);
//		mapper.updateArticle(paraMap); //맵을이용한 update
//		
//	}
//
//	public void addReply(String parentId, String body, String nickname) {
//		getSession();
//		Map<String, Object> paramap = new HashMap<>();
//		paramap.put("parentId", parentId);
//		paramap.put("body", body);
//		paramap.put("nickname", nickname);
//		mapper.addReply(paramap);
//		
//		session.commit();
//		
//	}
	void getSession() {
		session = sqlSessionFactory.openSession();
		mapper = session.getMapper(ArticleMapper.class);
	}

}
