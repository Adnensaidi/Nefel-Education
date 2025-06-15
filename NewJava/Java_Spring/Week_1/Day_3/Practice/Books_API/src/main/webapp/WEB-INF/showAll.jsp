<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
</head>
<body>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">title</th>
      <th scope="col">desc</th>
      <th scope="col">num of pages</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="book" items="${allBooks }">
    	<tr>
      <th scope="row"> <c:out value="${book.id }"></c:out> </th>
      <td> <a href="/books/${book.id }"><c:out value="${book.title }"></c:out></a> </td>
      <td> <c:out value="${book.language }"></c:out> </td>
      <td> <c:out value="${book.numberOfPages }"></c:out> </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>