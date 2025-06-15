<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<title>Insert title here</title>
</head>
<body>
	<h2>you have visited <a href="http://localhost:8080/your_server">http://localhost:8080/your_server</a> <c:out value="${counter}"></c:out> times </h2>
	<a href="http://localhost:8080/your_server">test anothor visit</a>
	<form action="/reset" method="POST">
		<input type="submit" value="submit">
	</form>
</body>
</html>