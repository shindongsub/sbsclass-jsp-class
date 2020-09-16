<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원 로그인</h1>
<form>
<div>
id : <input type="text" name = "id"><br>
pw : <input type="text" name = "pw"><br>
<hr>
<input type="submit" name="cmd" value="dologin">
<a href="http://localhost:8090/test?cmd=list"> [목록]</a>
</div>
</form>
</body>
</html>