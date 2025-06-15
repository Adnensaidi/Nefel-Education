<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container mt-5">
<div class="d-flex justify-content-between">
    <h1>Add a Book to your shelf!</h1>
    <a href="/home">return back home</a>
</div>
    <form:form modelAttribute="book" method="POST" action="/books/new" class="col-8 mx-auto mt-5">
	    <div class="form-group">
		    <form:label path="title" class="form-lable">enter title</form:label>
		    <form:input path="title" type="text" placeholder="enter title" class="form-control"/>
		    <form:errors class="badge text-danger" path="title"/>
	    </div>
	    <div class="form-group">
		    <form:label path="author" class="form-lable">enter the author</form:label>
		    <form:input path="author" type="text" placeholder="enter author" class="form-control"/>
		    <form:errors class="badge text-danger" path="author"/>
	    </div>
	    <div class="form-group">
		    <form:label path="mytho" class="form-lable">enter your thoughts</form:label>
		    <form:input path="mytho" type="text" placeholder="enter your thoughts" class="form-control"/>
		    <form:errors class="badge text-danger" path="mytho"/>
	    </div>
	    <input type="submit" class="btn btn-primary mt-2 "/>
    </form:form>
</body>
</html>