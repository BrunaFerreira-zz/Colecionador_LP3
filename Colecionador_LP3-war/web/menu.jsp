<%-- 
    Document   : menu
    Created on : 05/04/2016, 22:27:46
    Author     : Bruna
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <nav class="topMenu">
            <ul>
                <a href="index.jsp"><li class="${menu.equals('home')?'selecionado':''}">Home</li></a>
                
                <li class="${menu.equals('pagina2')?'selecionado':''}">Página 2</li>
                <c:choose>
                    <c:when test="${user==null}">
                        <a href="login.jsp"><li class="${menu.equals('login')?'selecionado':''}"  >Login</li></a>
                    </c:when>
                    <c:otherwise>
                        <a href="pagina1.jsp"><li class="${menu.equals('pagina1')?'selecionado':''}">Página 1</li></a>
                        <a href="FrontController?command=Usuario&action=logout"><li >Logout</li></a>
                    </c:otherwise>
                </c:choose>
                
            </ul>
        </nav>
    </body>
</html>