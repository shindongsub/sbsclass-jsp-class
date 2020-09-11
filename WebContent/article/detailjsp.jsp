<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sbs.board.Article"%> 
<%@ page import="com.sbs.board.testServlet"%>
<%@ page import="com.sbs.board.Reply"%>  
<%@ page import="java.util.List"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Article article = (Article)request.getAttribute("article");
List<Reply> reply = (List<Reply>)request.getAttribute("reply"); 
%>

<h1>게시물 상세보기</h1><br>
선생님 질문있습니다! 리스트 전체보기에서는 정상적으로 보입니다. 하지만 상세보기 번호 클릭해서 들어가면 내용이 자꾸 null로 바뀝니다. 이유가 알고싶습니다.<br>
댓글도 작성자가 null로 자꾸 바뀌어서 input을 writer도 입력할때 추가하였더니 정상적으로 나오더라구요.ㅜ.ㅜ<br>
<div>
번호 : <%= article.getId() %><br>
제목 : <%= article.getTitle() %><br>
내용 : <%= article.getBody() %><br>
작성자 : <%= article.getNickname() %><br>
날짜 : <%= article.getRegDate() %><br>
조회수 : <%= article.getHit() %><br>
</div>

<a href="http://localhost:8090/test?cmd=list">[목록]</a>
<a href="http://localhost:8090/test?cmd=addReply&parentId=<%= article.getId() %>">[댓글]</a>
<a href="http://localhost:8090/test?cmd=updateArticle&id=<%= article.getId() %>">[수정]</a>
<a href="http://localhost:8090/test?cmd=delete&id=<%= article.getId() %>">[삭제]</a>
<hr>
-댓글내용-<br>
<hr>
<div>
<% for (int i=0; i<reply.size() ;i++){%>
	<div>
	내용 : <%= reply.get(i).getBody() %> <br>
	작성자 : <%= reply.get(i).getWriter() %> <br>
	작성일 : <%= reply.get(i).getRegDate() %> <br>
	</div>
</div>


<a href="http://localhost:8090/test?cmd=readReply&id=<%= reply.get(i).getId() %>">[댓글수정]</a>
<a href="http://localhost:8090/test?cmd=deleteReply&id=<%= reply.get(i).getId() %>">[댓글삭제]</a><br>

<hr>
<div>
<%}%>
</div>
</body>
</html>




