<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
            <h1 class="text-primary">edit a Burger</h1>
            <form:form modelAttribute="burger" action="/burger/edit/${burger.id}" method="POST">
                <div class="form-group">
					<form:label path="name">name</form:label>
                    <form:input path="name" type="text" class="form-control"/>
                	<form:errors class="badge text-danger" path="name"/>
                </div>
                <div class="form-group">
					<form:label path="restaurant_name">resto</form:label>
                    <form:input path="restaurant_name" type="text" class="form-control"/>
                	<form:errors class="badge text-danger" path="restaurant_name"/>
                </div>
                <div class="form-group">
					<form:label path="rateing">rating</form:label>
                    <form:input path="rateing" type="text" placeholder="enter rateing" class="form-control"/>
                	<form:errors class="badge text-danger" path="rateing"/>
                </div>
                <div class="form-group">
					<form:label path="notes">notes</form:label>
                    <form:textarea path="notes" class="form-control"/>
                	<form:errors class="badge text-danger" path="notes"/>
                </div>
                <input type="submit" class="btn btn-primary">
            </form:form>
        </div>
</body>
</html>