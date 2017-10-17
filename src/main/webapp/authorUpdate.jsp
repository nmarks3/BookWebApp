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
        <link rel="stylesheet" href="css/custom.css" >
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Author Update</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                    <h1>Author Update</h1>

                    <form name="update" method ="POST" action = "authorController?action=update">

                        <input  type="hidden" name="id" value="${id}">            
                        Author Name:
                        <br>
                        <input class="form-control" type="text" name="name" value="">
                        <br>           
                        <input type="submit" class="btn btn-primary" name="submit" value="Submit">
                        <br><br>

                    </form>

                    </form>

                    <form name="home" method="POST" action="authorController?action=list" > 
                        <input class="btn btn-primary"   type="submit" value="Back to Authors List" />
                    </form>
                </div>
            </div>
        </div>
    </body>


</html>
