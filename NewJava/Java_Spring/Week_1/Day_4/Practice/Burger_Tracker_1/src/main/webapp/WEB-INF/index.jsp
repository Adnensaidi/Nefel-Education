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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
</head>
<body>
    <div class="mt-5 container">
        <h1 class="text-primary">Burger Tracker</h1>
        <c:if test="${allBurgers.size() == 0 }">
        	<p class="text-danger bg-warning text-center h4 mt-3">no burgers (T-T)</p>
        </c:if>
        <c:if test="${allBurgers.size() != 0 }">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">name</th>
                    <th scope="col">Rname</th>
                    <th scope="col">rating</th>
                    <th scope="col">notes</th>
                    <th scope="col">actions</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="b" items="${allBurgers }">
            	<tr>
                    <th scope="row"> <c:out value="${b.id}"></c:out> </th>
                    <td><c:out value="${b.name}"></c:out></td>
                    <td><c:out value="${b.restaurant_name}"></c:out></td>
                    <td><c:out value="${b.rateing}"></c:out></td>
                    <td><c:out value="${b.notes}"></c:out></td>
                    <td>
                    	<a href="/burger/edit/${b.id }" class=" btn btn-primary"> edit </a>
                    </td>
                </tr>
            	</c:forEach>
                
            </tbody>
        </table>
		</c:if>
        <div class="container mt-5">
            <h1 class="text-primary">Add a Burger</h1>
            <form:form modelAttribute="burger" action="/burger/new" method="post">
                <div class="form-group">
					<form:label path="name">name</form:label>
                    <form:input path="name" type="text" placeholder="enter burger name" class="form-control"/>
                	<form:errors class="badge text-danger" path="name"/>
                </div>
                <div class="form-group">
					<form:label path="restaurant_name">resto</form:label>
                    <form:input path="restaurant_name" type="text" placeholder="enter restaurant name" class="form-control"/>
                	<form:errors class="badge text-danger" path="restaurant_name"/>
                </div>
                <div class="form-group">
					<form:label path="rateing">rating</form:label>
                    <form:input path="rateing" type="text" placeholder="enter rateing" class="form-control"/>
                	<form:errors class="badge text-danger" path="rateing"/>
                </div>
                <div class="form-group">
					<form:label path="notes">notes</form:label>
                    <form:textarea path="notes" class="form-control"/>
                	<form:errors class="badge text-danger" path="notes"/>
                </div>
                <input type="submit" class="btn btn-primary">
            </form:form>
        </div>
    </div>
</body>
</html>