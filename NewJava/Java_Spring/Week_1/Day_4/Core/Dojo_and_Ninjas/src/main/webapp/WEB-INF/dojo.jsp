<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body class="container mt-5">
<h1>New Dojo</h1>
    <form:form modelAttribute="dojo" method="POST" action="/dojos/create">
    <div class="form-group">
        <form:label path="name"></form:label>
        <form:input path="name" type="text" placeholder="enter dojo name" class="form-control"/>
        <form:errors class="badge text-danger" path="name"/>
    </div>
    <input type="submit" class="btn btn-primary mt-5 ">
    </form:form>
    <a href="/ninjas/new">create ninjas</a>
</body>
</html>