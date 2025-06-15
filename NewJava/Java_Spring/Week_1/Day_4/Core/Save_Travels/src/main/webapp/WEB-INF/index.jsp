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
    <h1 class="text-success">Save Travels</h1>
    <c:if test="${allExpences.size()==0 }">
        <p class="text-danger bg-warning text-center h3">no expences yet </p>
    </c:if>
    <c:if test="${allExpences.size()!=0}">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">expence</th>
                    <th scope="col">vendor</th>
                    <th scope="col">amount</th>
                    <th scope="col">actions</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="expence" items="${allExpences }">
                <tr>
                    <th scope="row"> <c:out value="${expence.id}"></c:out> </th>
                    <td><a href="expences/${expence.id}"><c:out value="${expence.name}"></c:out></a></td>
                    <td><c:out value="${expence.vendor}"></c:out></td>
                    <td><c:out value="${expence.amount}"></c:out></td>
                    <td class=" d-flex align-items-center justify-content-around">
                        <a href="/expences/edit/${expence.id}" class=" btn btn-primary">edit</a>
                        <form action="expences/delete" method="POST">
                            <input type="hidden" name="id" value="${expence.id}">
                            <input type="submit" value="delete" class=" btn btn-danger">
                        </form>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        </c:if>
        <form:form modelAttribute="travel" action="/expences/create" method="POST" class="container col-8 mt-5">
        <h1 class="text-primary">Add an expence</h1>
                    <div class="form-group">
                        <form:label path="name">name</form:label>
                        <form:input path="name" type="text" placeholder="enter name" class="form-control" />
                        <form:errors class="badge text-danger" path="name" />
                    </div>
                    <div class="form-group">
                        <form:label path="vendor">vendor</form:label>
                        <form:input path="vendor" type="text" placeholder="enter vendor" class="form-control" />
                        <form:errors class="badge text-danger" path="vendor" />
                    </div>
                    <div class="form-group">
                        <form:label path="amount">amount</form:label>
                        <form:input path="amount" type="number" placeholder="enter amount" class="form-control" />
                        <form:errors class="badge text-danger" path="amount" />
                    </div>
                    <div class="form-group">
                        <form:label path="description">description</form:label>
                        <form:textarea path="description" class="form-control"></form:textarea>
                        <form:errors class="badge text-danger" path="description" />
                    </div>
                    <input type="submit" class="btn btn-primary mt-5">
        </form:form>
    </div>
</body>
</html>