<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sbs.board.testServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sbs.board.Article"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> ☆게시물 목록☆ </h1>
번호를 누르시면 상세보기가 실행됩니다.<br>
<hr>
<% 
List<Article> articles = (List<Article>)request.getAttribute("articles");

%>
<%Article article = (Article)request.getAttribute("article"); %>


<% for (int i = 0; i<articles.size(); i++){%>
<div>
<form name="cmd">
<!-- 리스트의 번호를 클릭하면 cmd=read의 id번째 상세보기로 이동 -->
<a href="http://localhost:8090/test?cmd=read&id=<%= articles.get(i).getId() %>">
번호    : <%= articles.get(i).getId()%></a><br>
제목    : <%= articles.get(i).getTitle() %><br>
내용    : <%= articles.get(i).getBody()%><br>
작성자 : <%= articles.get(i).getNickname()%><br>
날짜    : <%= articles.get(i).getRegDate()%><br>
조회수 : <%= articles.get(i).getHit()%><br>
<input type = "checkbox" name="ckb" value="<%= articles.get(i).getId()%>"> 게시물삭제 <%//여기서 ckb값을 창에서 체크하여 delete로 보내준다 %>
<hr>
<%
}
%>
<input type="submit" name="cmd" value="delete"> <%// %>
<a href="http://localhost:8090/test?cmd=addArticle">[게시물 추가]</a> <%//궁금합니다. 글씨로박에 안되나요 submit박스로 해서 링크 못다나요? %>
</form>
</div>

</body>
</html>



<!-- 
<h1> 제목
<br> 줄바꿈
<div> 영역 - 여기선 자동줄바꿈됨
<form> uri제조기 (상자만들기?)
<a>링크  <>a쓰고 띄운다음 링크걸면 해당링크로 들어가게됨.


 -->