<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
    <div class="container mt-5">
        <div class="mt-3 d-flex align-items-center justify-content-between" >
            <h1>New Ninja</h1>
            <a href="/">Go back</a>
        </div>
        <div class="container mt-3">
            <form:form modelAttribute="user" method="POSt" action="/ninjas/create">
                <form:label path="dojo">add a dojo</form:label>
                <form:select path="dojo" class="form-select col-5">
                    <form:options items="${allDojos }" itemLabel="name" />
                </form:select>
            <div class="form-group">
                <form:label path="firstname">ninja firstname</form:label>
                <form:input path="firstname" type="text" placeholder="enter ninja name" class="form-control" />
                <form:errors class="badge text-danger" path="firstname" />
            </div>
            <div class="form-group">
                <form:label path="lastname">ninja lastname</form:label>
                <form:input path="lastname" type="text" placeholder="enter ninja name" class="form-control" />
                <form:errors class="badge text-danger" path="lastname" />
            </div>
            <div class="form-group">
                <form:label path="age">ninja age</form:label>
                <form:input path="age" type="text" placeholder="enter ninja name" class="form-control" />
                <form:errors class="badge text-danger" path="age" />
            </div>
            <input type="submit" class="btn btn-primary mt-3">
            </form:form>
                
        </div>
    </div>
</body>
</html>>