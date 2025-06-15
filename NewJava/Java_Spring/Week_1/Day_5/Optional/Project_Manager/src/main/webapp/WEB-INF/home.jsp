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
    <div class=" container mt-5">
        <div class=" d-flex align-items-center justify-content-between">
        <h1>welcome, <c:out value="${user.username }"></c:out> </h1>
        <a href="/logout">logout</a>
        </div>
        <div>
            <div class="d-flex align-items-center justify-content-between">
                <h4 class="fw-bold">all projects</h4>
                <a href="/projects/create" class=" btn btn-primary">+ create a new project</a>
            </div>
            <c:if test="${allProjects.size()==0 }">
                <p class="fw-bold mt-3 rounded text-center bg-warning text-danger">no projects yet</p>
            </c:if>
            <c:if test="${allProjects.size()!=0 }">

          
            <table class=" table table-striped border border-black mt-3">
                <thead>
                    <tr>
                        <th>projects</th>
                        <th>Team lead</th>
                        <th>due date</th>
                        <th>actions</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="project" items="${allProjects }">
                    <tr>
                        <td> <c:out value="${project.title }"></c:out> </td>
                        <td><c:out value="${project.creator.username }"></c:out></td>
                        <td><c:out value="${project.duedate }"></c:out></td>
                        <td>
                        <c:if test="${userId != project.creator.id }">
                            <a href="/projects/join">join team</a>
                        </c:if>
                        <c:if test="${userId == project.creator.id }">
                            <a href="/projects/leave">leave team</a>
                        </c:if>
                        
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
              </c:if>
              
            <div class=" mt-5">
                <h4 class=" fw-bold">your projects</h4>
            <c:if test="${user.myprojects.size()==0 }">
                <p class="fw-bold mt-3 rounded text-center bg-warning text-danger">no projects yet</p>
            </c:if>
            
            <c:if test="${user.myprojects.size()!=0 }">
                
            
                <table class=" table table-striped border border-black mt-3">
                    <thead>
                        <tr>
                            <th>projects</th>
                            <th>Team lead</th>
                            <th>due date</th>
                            <th>actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="project" items="${user.myprojects }">
                        <tr>
                            <td> <c:out value="${project.title }"></c:out> </td>
                            <td><c:out value="${project.creator.username }"></c:out></td>
                            <td><c:out value="${project.duedate }"></c:out></td>
                            <td>
                                <a href="/projects/leave">leave team</a>
                                <c:if test="${userId ==  project.creator.id}">
                                <a href="/projects/edit/${project.id }">edit</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </c:if>
            </div>
        </div>
    </div>
    
</body>
</html>