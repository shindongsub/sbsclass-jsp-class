<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sbs.board.Article"%> 
<%@ page import="com.sbs.board.testServlet"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Article article = (Article)request.getAttribute("article");
%>
<div>
<h1>게시물 상세보기</h1>
번호 : <%= article.getId() %><br>
제목 : <%= article.getTitle() %><br>
내용 : <%= article.getBody() %><br>
작성자 : <%= article.getNickname() %><br>
날짜 : <%= article.getRegDate() %><br>
조회수 : <%= article.getHit() %><br>
<hr>
</div>
<a href="http://localhost:8090/test?cmd=list">[뒤로가기]<%  %></a>
<a href="http://localhost:8090/test?cmd=updateArticle&id=<%= article.getId() %>">[수정]</a>
<a href="http://localhost:8090/test?cmd=delete&id=<%= article.getId() %>">[삭제]</a>
</body>
</html>