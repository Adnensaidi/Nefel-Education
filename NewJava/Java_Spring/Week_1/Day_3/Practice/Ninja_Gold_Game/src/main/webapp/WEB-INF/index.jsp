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
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class=" container mt-5 border-1 rounded">
        <h5 class=" d-inline-block">your gold : </h5>
        <span class="h5 border border-2 px-5 border-black ml-5"> <c:out value="${playergold}"></c:out> </span>
        <div class=" d-flex justify-content-between"> 
            <div class=" border border-2 border-black col-2 mt-5">
                <form action="/game" method="POST" class="d-flex flex-column align-items-center p-2 gap-4">
                    <h5 class="text-center">Farm</h5>
                    <p class="h6">(earns 10-20 Gold)</p>
                    <input type="hidden" name="gold" value="farm">
                    <input type="submit" value="find gold" class=" bg-transparent rounded shadow-lg">
                </form>
            </div>
            <div class=" border border-2 border-black col-2 mt-5">
                <form action="/game" method="POST" class="d-flex flex-column align-items-center p-2 gap-4">
                    <h5 class="text-center">Cave</h5>
                    <p class="h6">(earns 5-10 Gold)</p>
                    <input type="hidden" name="gold" value="cave">
                    <input type="submit" value="find gold" class=" bg-transparent rounded shadow-lg">
                </form>
            </div>
            <div class=" border border-2 border-black col-2 mt-5">
                <form action="/game" method="POST" class="d-flex flex-column align-items-center p-2 gap-4">
                    <h5 class="text-center">House</h5>
                    <p class="h6">(earns 2-5 Gold)</p>
                    <input type="hidden" name="gold" value="house">
                    <input type="submit" value="find gold" class=" bg-transparent rounded shadow-lg">
                </form>
            </div>
            <div class=" border border-2 border-black col-2 mt-5">
                <form action="/game" method="POST" class="d-flex flex-column align-items-center p-2 gap-4">
                    <h5 class="text-center">Quest</h5>
                    <p class="h6">(earns/takes 0-50 Gold)</p>
                    <input type="hidden" name="gold" value="quest">
                    <input type="submit" value="find gold" class=" bg-transparent rounded shadow-lg">
                </form>
            </div>
        </div>
        <h5 class="mt-5">Activities:</h5>
        <div class=" border border-2 border-black overflow-auto max-h p-2">
			<c:forEach var="action" items="${actions}">
			
			    <c:choose>
			        <c:when test="${action.contains('lost') }">
			        <p  class="text-danger">
			            <c:out value="${action}" />
			        </p>
			        </c:when>
			        <c:otherwise>
			        <p class="text-success">
			            <c:out value="${action}"  />
			        </p>
			        </c:otherwise>
			    </c:choose>
			

			</c:forEach>
        </div>
        <form action="/reset" method="POST">
        	<input type="submit" value="reset" class=" bg-transparent rounded shadow-lg p1 mt-3">
        </form>
    </div>
</body>
</html>