<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Login and Registration</title>
</head>
<body>
<h1 class="text-center text-primary mt-5">Book Club</h1>
<div class="container">

    <h2>Register</h2>
    <div class="container">
        <form:form action="/register" modelAttribute="newUser" class="form-control" method="post">
            <div class="form-row mb-3">
                <form:label path="username">User Name:</form:label>
                <form:input type="text" path="username" class="form-control"/>
                <form:errors path="username" class="text-danger"/>
            </div>
            
            <div class="form-row mb-3">
                <form:label path="email">Email:</form:label>
                <form:input type="email" path="email" class="form-control"/>
                <form:errors path="email" class="text-danger"/>
            </div>
            
            <div class="form-row mb-3">
                <form:label path="password">Password:</form:label>
                <form:input type="password" path="password" class="form-control"/>
                <form:errors path="password" class="text-danger"/>
            </div>
            
            <div class="form-row mb-3">
                <form:label path="confpw">Confirm Password:</form:label>
                <form:input type="password" path="confpw" class="form-control"/>
                <form:errors path="confpw" class="text-danger"/>
            </div>
            
            <div class="form-row">
                <input type="submit" value="Register" class="btn btn-primary mt-3"/>
            </div>
        </form:form>
    </div>
    
    <hr>
    
    <h2>Log In</h2>
    <div class="container">
        <form:form action="/login" modelAttribute="loginUser" class="form-control" method="post">
            <div class="form-row mb-3">
                <form:label path="email">Email:</form:label>
                <form:input type="email" path="email" class="form-control"/>
                <form:errors path="email" class="text-danger"/>
            </div>
            
            <div class="form-row mb-3">
                <form:label path="password">Password:</form:label>
                <form:input type="password" path="password" class="form-control"/>
                <form:errors path="password" class="text-danger"/>
            </div>
            
            <div class="form-row">
                <input type="submit" value="Login" class="btn btn-primary mt-3"/>
            </div>
        </form:form>
    </div>

</div>
</body>
</html>