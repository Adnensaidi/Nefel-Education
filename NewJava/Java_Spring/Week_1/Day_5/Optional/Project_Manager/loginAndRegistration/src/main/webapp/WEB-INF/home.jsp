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

</head>
<body class="container mt-5">
<div class="d-flex justify-content-between align-items-center">
<h1>welcome, <c:out value="${user.username }"></c:out> </h1>
<a href="/books/create">create a book</a>
</div>

<c:if test="${allBooks.size() == 0 }">
    <p class="h1 text-danger bg-warning text-center p-1"> no books yet </p>
</c:if>
<c:if test="${allBooks.size() != 0 }">


    <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">title</th>
      <th scope="col">author</th>
      <th scope="col">posted by</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${allBooks}">  
    <tr>
      <th scope="row"> <c:out value="${book.id }"></c:out> </th>
      <td> <a href="/books/view/${book.id }"><c:out value="${book.title }"></c:out></a> </td>
      <td> <c:out value="${book.author }"></c:out> </td>
      <td> <c:out value="${book.user.getUsername() }"></c:out> </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</c:if>

</body>
</html>