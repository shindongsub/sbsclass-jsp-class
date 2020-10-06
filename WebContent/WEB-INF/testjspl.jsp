<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<Integer> nlist = new ArrayList<>();
	for (int i=0; i<10; i++){
		nlist.add(i+1);
	}
	for(int i : nlist){
		out.println(i);
	}
	%>
<c:set var="age" value="18"/>
<c:if test="${age < 20 }"> 할인대상 </c:if>
<c:if test="${age >= 59 }"> 할인대상 </c:if>
<c:if test="${age > 19 }"> 
 	 <c:if test="${age < 59 }"> 
	할인대상이 아닙니다.
	</c:if>
</c:if>

<c:choose>
<c:when test="${age < 20 }">할인대상</c:when>
<c:when test="${age > 59 }">할인대상</c:when>
<c:otherwise>
할인대상X
</c:otherwise>
</c:choose>

<c:set var = "nlist"> </c:set>
<c:forEach var="i" begin="0" end="10" step="1">
${ i }
</c:forEach>

<c:set var = "nlist"> </c:set>
<c:forEach var="i" items="${ nlist } ">
${ i }
</c:forEach>


</body>
</html>