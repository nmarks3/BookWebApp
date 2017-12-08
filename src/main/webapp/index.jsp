<%-- 
    Document   : index
    Created on : Sep 19, 2017, 8:01:39 PM
    Author     : jlombardo
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Web Application</title>
    </head>
    <body>
                <sec:authorize access="hasAnyRole('ROLE_MGR' , 'ROLE_USER')">
                    Welcome Back: <sec:authentication property="principal.username"></sec:authentication>
                </sec:authorize>
        <h1>Pick a Task</h1>
        <ul>
            <li><a href="authorController?action=list">View all Authors</a></li>
            <li><a href="bookController?action=list">View all Books</a></li>
            <li>...more to come</li>
        </ul>

        <sec:authorize access="hasAnyRole('ROLE_MGR')">
            <h1>For Managers only</h1>
        </sec:authorize>
            
        <sec:authorize access="hasAnyRole('ROLE_MGR' , 'ROLE_USER')">
            Logged in as: <sec:authentication property="principal.username"></sec:authentication> :: 
            <a href='<%= this.getServletContext().getContextPath() + "/j_spring_security_logout"%>'>Log Me Out</a>

        </sec:authorize>


    </body>
</html>
