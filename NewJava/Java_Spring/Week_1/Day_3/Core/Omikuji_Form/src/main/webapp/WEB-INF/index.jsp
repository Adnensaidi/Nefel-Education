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
    <form action="/Send" method="POST" class=" card container mt-5 p-4 col-sm-6">
        <h1 class=" text-center card-header">Send an Omikiji</h1>
        <h3 class="text-danger"> <c:out value="${ yearsInvalid}"></c:out> </h3>
        <h3 class="text-danger"> <c:out value="${ blankInvalid}"></c:out> </h3>
        <div class=" col-5 mt-3"> 
            <label for="years">pick any number from 1 to 25</label>
            <input type="number" name="years" placeholder="0" class=" form-control">
        </div>
        <div class=" mt-3 col-8">
            <label for="city" class="form-label">enter the name of any city</label>
            <input type="text" name="city" class=" form-control">
        </div>
        <div class=" mt-3 col-8">
            <label for="rmate" class="form-label">enter the name of any person</label>
            <input type="text" name="rmate" class=" form-control">
        </div>
        <div class=" mt-3 col-8">
            <label for="job" class="form-label">enter any job or hobby</label>
            <input type="text" name="job" class=" form-control">
        </div>
        <div class=" mt-3 col-8">
            <label for="animal" class="form-label">enter the name of any animal</label>
            <input type="text" name="animal" class=" form-control">
        </div>
        <div class=" mt-3 col-8">
            <label for="snice" class="form-label">tell something nice to some one</label>
            <textarea name="snice" class="form-control"></textarea>
        </div>
        <p class=" mt-3">send and show a friend</p>
        <input type="submit" value="send" class=" col-2 rounded bg-primary text-white align-self-end">
    </form>
</body>
</html>