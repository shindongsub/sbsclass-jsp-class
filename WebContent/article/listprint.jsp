<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="com.sbs.board.Article"%>
<%@ page import="com.sbs.board.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>☆게시물 목록☆</h1>
<% Member loginMember = (Member)session.getAttribute("loginMember");
	if (loginMember != null){ %>
	안녕하세요. ${ loginMember.nickname } 님! 반갑습니다. --이렇게도 표현가능 el표현식<br> 
	안녕하세요. <%= loginMember.getNickname() %> 님! 반갑습니다.
	<a href = "http://localhost:8090/test?cmd=logout"> [로그아웃] </a>
	<%}else{%>
	로그인 해주세요.	<a href="http://localhost:8090/test?cmd=showlogin" >   [로그인]</a>
	<%}%>
	<br>
	<hr>
	번호를 누르시면 상세보기가 실행됩니다.

	<form action="test?cmd=delete" method="POST" >
		<c:forEach var="article" items = "${ articles }" >
		<div>
			<input type="checkbox" name="ckb" value="${ article.id }" />
			<a href="http://localhost:8090/test?cmd=read&id=${ article.id }">
				번호 : ${ article.id }</a>
				제목 : ${ article.title }
				내용 : ${ article.body }
				작성자 : ${ article.nickname }
				날짜 : ${ article.regDate }
				조회수 : ${ article.hit }
		</div>
		<hr>
		</c:forEach>
		<input type="submit" value="삭제"/> <% //delete로 왜 안넘어가는지 모르겠습니다. %>
		<a href="http://localhost:8090/test?cmd=addArticle" >   [글쓰기]</a>
	</form>
<hr>
※글쓰기 필터적용 / 업로드, 상세보기, 삭제, 댓글, 로그인 필터적용 필요
</body>
</html>



<!-- 
<h1> 제목
<br> 줄바꿈
<div> 영역 - 여기선 자동줄바꿈됨
<form> uri제조기 (상자만들기?)
<a>링크  <>a쓰고 띄운다음 링크걸면 해당링크로 들어가게됨.


 -->