<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <title>Document</title>
</head>
<body>
    <div class="container mt-5">
        <h1>edit a project</h1>
            <form:form modelAttribute="project" method="POST" action="/projects/edit/${project.id}">
                <div class="form-group">
                    <form:label path="title">title</form:label>
                    <form:input path="title" type="text" placeholder="enter title" class="form-control" />
                    <form:errors class="badge text-danger" path="title" />
                </div>
                <div class="form-group">
                    <form:label path="description">description</form:label>
                    <form:textarea path="description" class="form-control" ></form:textarea>
                    <form:errors class="badge text-danger" path="description" />
                </div>
                <div class="form-group">
                    <form:label path="duedate">due date</form:label>
                    <form:input path="duedate" type="date" placeholder="enter duedate" class="form-control" />
                    <form:errors class="badge text-danger" path="duedate" />
                </div>
                <input type="submit" class="btn btn-primary">
            </form:form>
         </div>   
</body>
</html>