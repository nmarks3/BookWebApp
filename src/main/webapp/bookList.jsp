<%-- 
    Document   : authorList
    Author     : nmarks
--%>

<%@page import="java.util.List"%>
<%@page import="edu.wctc.distjava.jgl.bookwebapp.model.Author"%>
<%@page import="edu.wctc.distjava.jgl.bookwebapp.model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
          <link rel="stylesheet" href="css/bootstrap.min.css" >
          <link rel="stylesheet" href="css/custom.css" >
          <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <title>Author List</title>
    </head>
    <body>
<jsp:include page="jsp/navbar.jsp"/>
        <div class="container">
            <div class="row">
                <h1>book List</h1>

                <table class="table table-hover table-condensed table-striped">
                    <thead class="thead-inverse">
                        <tr>
                            <th>ID</th>
                            <th>Book Name</th>
                            <th>ISBN</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="b" items="${bookList}">
                            <tr>
                                <td>${b.bookId}</td>
                                <td>${b.title}</td>
                                <td>${b.isbn}</td>
                                <td><a href="bookController?action=update&bookId=${b.bookId}&title=${b.title}&isbn=${b.isbn}&authorId=${b.authorId}"><button type="button" class="btn btn-primary">Update</button></td>
                                <td><a href="bookController?action=delete&bookId=${b.bookId}"><button type="button" class="btn btn-danger">Delete</button></a></td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
                <h3>${errorMsg}</h3>

                <a href="bookAdd.jsp"><button type="button" class="btn btn-primary">Add Book</button></a>
            </div>
        </div>
    </body>
</html>
