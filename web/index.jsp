<%--
  Created by IntelliJ IDEA.
  User: piotrlandzwojczak
  Date: 24/01/2019
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%
    Object username = session.getAttribute("username");
    username = username != null ? username : "";

%>

<%= username%>

<br/>
<a href="<%=request.getContextPath()%>/books.jsp">Books</a>
<br/>
<a href="<%=request.getContextPath()%>/logout">Logout</a>
</body>
</html>
