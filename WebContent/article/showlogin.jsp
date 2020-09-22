<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List"%>
<%@ page import="com.sbs.board.Article"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원 로그인</h1>
<div>
<form action="/test?cmd=dologin" method="POST">
<input type="text" name = "id" placeholder="아이디를 입력해주세요"><br>
<input type="password" name = "pw" placeholder="비밀번호를 입력해 주세요"><br>
<input type="hidden" name = "cmd" placeholder="dologin"><br>
<hr>
<input type="submit" value="로그인" />
</form>
</div>

</body>
</html>