
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
    <div class="container mt-5">
        <div class="d-flex align-items-center justify-content-between">
            <h1 class="text-primary">expence details</h1>
            <a href="/">go back</a>
        </div>
        <div class=" mt-5 container">
            <div class=" d-flex gap-5">
                <p>expence name:</p>
                <p> <c:out value="${travel.name }"></c:out> </p>
            </div>
            <div class=" d-flex gap-5">
                <p>expence description:</p>
                <p> <c:out value="${travel.description }"></c:out> </p>
            </div>
            <div class=" d-flex gap-5">
                <p>expence vendor:</p>
                <p> <c:out value="${travel.vendor }"></c:out> </p>
            </div>
            <div class=" d-flex gap-5">
                <p>amount:</p>
                <p> <c:out value="${travel.amount }"></c:out> </p>
            </div>
        </div>
    </div>
</body>
</html>