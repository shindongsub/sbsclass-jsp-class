<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sbs.board.Article"%>
<%@ page import="java.util.List"%>
<%@ page import="com.sbs.board.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>☆게시물 목록☆</h1>
<% Member loginMember = (Member)application.getAttribute("loginMember");
	if (loginMember != null){ %>
	안녕하세요. <%= loginMember.getNickname() %> 님! 반갑습니다.
	<a href = "http://localhost:8090/test?cmd=logout"> [로그아웃] </a>
<%}%>

	<form action="test?cmd=delete" method="POST">
		<%
			List<Article> articles = (List<Article>) request.getAttribute("articles");
		for (int i = 0; i < articles.size(); i++) {
		%>
		<div>
			<input type="checkbox" name="ckb" value="<%=articles.get(i).getId()%>" />
			<a href="http://localhost:8090/test?cmd=read&id=<%=articles.get(i).getId()%>">
				번호 : <%=articles.get(i).getId()%></a>
				제목 : <%=articles.get(i).getTitle()%>
				내용 : <%=articles.get(i).getBody()%>
				작성자 : <%=articles.get(i).getNickname()%>
				날짜 : <%=articles.get(i).getRegDate()%>
				조회수 : <%=articles.get(i).getHit()%>
		</div>
		<hr>
		<%
			}
		%>
		<input type="submit" value="삭제"/> <% //delete로 왜 안넘어가는지 모르겠습니다. %>
		<a href="http://localhost:8090/test?cmd=addArticle" >   [게시물추가]</a>

	</form>
</body>
</html>