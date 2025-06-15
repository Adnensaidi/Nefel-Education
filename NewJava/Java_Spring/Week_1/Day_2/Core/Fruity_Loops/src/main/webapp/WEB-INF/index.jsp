<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <title>Insert title here</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/css/style.css">
    </head>

    <body class="container">
        <h1 class=" text-success">Fruit store</h1>

        <div class="w-75 h-50 border bg-secondary-subtle p-3 d-flex">
            <table class="table table-borderless mb-0">
                <thead>
                    <tr class="border-bottom">
                        <th>name</th>
                        <th>price</th>
                    </tr>
                </thead>
                
                <tbody>
                    <c:forEach var="item" items="${fruits}" >
                    <tr class=" border-bottom">
                        <td> <c:out value="${item.name}"></c:out> </td>
                        <td> <c:out value="${item.price}"></c:out> </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>

</html>