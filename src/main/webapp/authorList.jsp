<%-- 
    Document   : authorList
    Created on : Sep 19, 2017, 8:35:54 PM
    Author     : jlombardo
--%>

<%@page import="java.util.List"%>
<%@page import="edu.wctc.distjava.jgl.bookwebapp.model.Author"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
          <link rel="stylesheet" href="css/bootstrap.min.css" >
        <title>Author List</title>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <h1>Author List</h1>
                <table class="table table-hover table-condensed table-striped">
                    <thead class="thead-inverse">
                        <tr>
                            <th>ID</th>
                            <th>Author Name</th>
                            <th>Date Added</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="a" items="${authorList}">
                            <tr>
                                <td>${a.authorId}</td>
                                <td>${a.authorName}</td>
                                <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${a.dateAdded}" /></td>
                                <td><a href="authorController?action=update&id=${a.authorId}"><button type="button" class="btn btn-primary">Update</button></td>
                                <td><a href="authorController?action=delete&id=${a.authorId}"><button type="button" class="btn btn-danger">Delete</button></a></td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
                <h3>${errorMsg}</h3>

                <a href="authorAdd.jsp"><button type="button" class="btn btn-primary">Add Author</button></a>
            </div>
        </div>
    </body>
</html>
