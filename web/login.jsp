<%--
  Created by IntelliJ IDEA.
  User: piotrlandzwojczak
  Date: 03/02/2019
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String invalidLogin = request.getParameter("invalidLogin");
    invalidLogin = invalidLogin != null ? invalidLogin : "";

%>

<%= invalidLogin %>

<form method="post" action="login">

    Login:
    <input name="login" type="text">
    <br/>

    Haslo:
    <input name="password" type="password">
    <br/>

    <input type="submit" value="Wyślij"/>
</form>


</body>
</html>
