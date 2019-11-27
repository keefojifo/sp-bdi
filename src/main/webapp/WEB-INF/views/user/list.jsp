<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
user list
	
	<ul>
		<c:forEach items="${requestScope.list}" var="u">
			<li>${u}</li>
		</c:forEach>
	</ul>
	<!--  
	<ul>
		<c:forEach items="${requestScope.list}" var="a">
			<li>"name들의 이름 입니다"+${a.name}</li>
		</c:forEach>
	</ul>
		<ul>
		<c:forEach items="${requestScope.list}" var="b">
			<li>${requestScope.list}</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach items="${requestScope.list}" var="c">
			<li>${list}</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach items="${requestScope.list}" var="a" varStatus="status">
			<li>${status.count}+${a.name}</li>
		</c:forEach>
	</ul>
	-->
</body>
</html>