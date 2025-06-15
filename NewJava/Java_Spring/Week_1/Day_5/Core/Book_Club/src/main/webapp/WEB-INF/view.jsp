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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>

    <body>
        <div class="container mt-5">
            <div class="d-flex align-items-center justify-content-between p-1">
                <h1> <c:out value="${book.title }"></c:out> </h1>
                <a href="/home">back to shelves</a>
            </div>

            <p class="fw-semibold"> <span class="text-danger"> <c:out value="${book.user.getUsername() }"></c:out> </span> read <span class=" text-primary"> <c:out value="${book.title }"></c:out> </span> by <span class="text-success"> <c:out value="${book.author }"></c:out> </span></p>

            <p class="fw-bold">here are <c:out value="${book.user.getUsername() }"></c:out> thoughts: </p>

            <p class=" border-top border-bottom border-black p-3"> <c:out value="${book.mytho }"></c:out> </p>
            
            <c:if test="${userId == book.user.getId() }">
            <div class="d-flex justify-content-end align-items-center gap-3">
                <a href="/books/edit/${book.id }" class="btn btn-primary">edit</a>
                <a href="/books/delete/${book.id}" class="btn btn-danger">delete</a>
            </div>
            </c:if>
            <c:if test="${userId != book.user.getId() }">
            <div class="d-flex justify-content-end align-items-center gap-3">
                <button  class="btn btn-primary" disabled >edit</button>
                <button  class="btn btn-danger" disabled>delete</button>
            </div>
            </c:if>
        </div>
    </body>

</html>