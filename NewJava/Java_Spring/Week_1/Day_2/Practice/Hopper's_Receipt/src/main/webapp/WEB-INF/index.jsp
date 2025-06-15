<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1> customer name <c:out value="${name}"></c:out> </h1>
	<p>item name <c:out value="${itemName}"></c:out> </p>
	<p>price <c:out value="${price}"></c:out> </p>
	<p>description <c:out value="${description }"></c:out> </p>
	<p>vendor <c:out value="${vendor}"></c:out> </p>
	
	
</body>
</html>