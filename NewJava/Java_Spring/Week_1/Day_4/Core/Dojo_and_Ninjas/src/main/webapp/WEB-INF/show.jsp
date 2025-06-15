<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body class="mt-5">
<h1 class="text-center"> dojo name <c:out value="${ninjas.get(0).dojo.name }"></c:out> </h1>
    <table class="table table-striped container">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Handle</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="ninja" items="${ninjas }">
        
            <tr>
                <th scope="row"> <c:out value="${ninja.id}"></c:out> </th>
                <td><c:out value="${ninja.firstname}"></c:out></td>
                <td><c:out value="${ninja.lastname}"></c:out></td>
                <td><c:out value="${ninja.age}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>