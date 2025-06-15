<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<form:form modelAttribute="travel" action="/expences/test/${travel.id}" method="POST" class="container col-8 mt-5">
        <h1 class="text-primary">edit an expence</h1>
                    <div class="form-group">
                        <form:label path="name">name</form:label>
                        <form:input path="name"  type="text" class="form-control" />
                        <form:errors class="badge text-danger" path="name" />
                    </div>
                    <div class="form-group">
                        <form:label path="vendor">vendor</form:label>
                        <form:input path="vendor" type="text" class="form-control" />
                        <form:errors class="badge text-danger" path="vendor" />
                    </div>
                    <div class="form-group">
                        <form:label path="amount">amount</form:label>
                        <form:input path="amount" type="number" class="form-control" />
                        <form:errors class="badge text-danger" path="amount" />
                    </div>
                    <div class="form-group">
                        <form:label path="description">description</form:label>
                        <form:textarea path="description" class="form-control"></form:textarea>
                        <form:errors class="badge text-danger" path="description" />
                    </div>
                    <div class="d-flex mt-5 justify-content-between">
                    <input type="submit" class="btn btn-primary">
                    <a href="/" class="btn btn-primary">go back</a>
                    </div>
        </form:form>
</body>
</html>