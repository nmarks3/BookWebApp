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
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/custom.css" >
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="http://www.parsecdn.com/js/parse-1.2.2.min.js"></script>
        <title>Book Update</title>
    </head>
    <body>
        <jsp:include page="jsp/navbar.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col">
                    <h1>Book Update</h1>
                    <form name="update" method ="POST" action = "bookController?action=update">
                        <input  type="hidden" name="bookId" value="${bookId}">            
                        Book Title:
                        <br>
                        <input class="form-control" type="text" name="title" value="${bookTitle}">
                        <br>  
                        Book ISBN:
                        <br>
                        <input class="form-control" type="text" name="isbn" value="${isbn}">
                        <br> 
                        Author:
                        <br>
                        <select name="selectedAuthor">
                        <c:forEach var="a" items="${authorList}">
                                 <option value="${a.authorId}">${a.authorName}</option>
                        </c:forEach>
                        <br> 
                        <input type="submit" class="btn btn-primary" name="submit" value="Submit" onSubmit="alert('Thanks');">
                        <br><br>
                        <h3>
                            ${message}
                        </h3>
                    </form>
                    <form name="home" method="POST" action="bookController?action=list" > 
                        <input class="btn btn-primary"   type="submit" value="Back to Books List" />
                    </form>
                </div>
            </div>
        </div>
    </body>


</html>
