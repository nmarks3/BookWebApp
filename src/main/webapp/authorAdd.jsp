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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Author Add</title>
    </head>
    <body>
        <jsp:include page="jsp/navbar.jsp"/>
        <div class="container" name="addAuthor">
            <div class="row">
                <div class="col">
                    <h1>Author Add</h1>
                    <form id=”addAuthorForm” name=”addAuthorForm” method="POST" action=authorController?action=add >
                        <p>Name: &nbsp;<input class="form-control" type="text" name="name" id="authorName" value="" placeholder="Enter Author "></p>
                        <input type="submit" class="btn btn-primary" id="submit" name="submit" value="Add Author">
                    </form>
                    <br>
                    <form name="home" method="POST" action="authorController?action=list" > 
                        <input class="btn btn-primary"   type="submit" value="Cancel" />
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
