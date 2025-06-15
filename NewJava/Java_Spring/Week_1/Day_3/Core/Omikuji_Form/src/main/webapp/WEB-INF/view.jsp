<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.4/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-DQvkBjpPgn7RC31MCQoOeC9TI2kdqa4+BSgNMNj8v77fdC77Kj5zpWFTJaaAoMbC" crossorigin="anonymous">
</head>
<body>
    <div class=" container col-4 mt-5 h2 fw-bold bg-primary-subtle rounded p-3 d-flex flex-column align-items-center">
        <p>
            in <c:out value="${years}"></c:out> years you will live in <c:out value="${city}"></c:out> with <c:out value="${rmate}"></c:out> as your room mate, <c:out value="${job}"></c:out> for a living the next time you see a <c:out value="${animal}"></c:out> you will have good luck also <c:out value="${snice}"></c:out>
        </p>
        <a href="/omikuji" class="align-self-center">Go back</a>
    </div>
</body>
</html>