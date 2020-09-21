package com.sbs.board;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sbs.board.mapper.ArticleMapper;

public class MyBatis {
	String resource = "com/sbs/config/mybatis-config.xml";
	
	private SqlSessionFactory sqlSessionFactory; //SqlSessionFactory하고 임포트하면된다.
	
	public MyBatis() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);  //https://mybatis.org/mybatis-3/ko/getting-started.html  (세션펙토리빌드하기 3줄 복사)
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
	}
	public void getAllArticles() {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class );
		List<Article> article =  mapper.getAllArticles();
		
		for(Article a : article) {
			System.out.println(a.getBody());
			System.out.println(a.getTitle());
		}
		
	}

}
