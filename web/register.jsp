<%--
  Created by IntelliJ IDEA.
  User: piotrlandzwojczak
  Date: 03/02/2019
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


REGISTER

<a href="login.jsp">Login</a>

<h1>
    Zarejestruj się na naszej super stronie!
</h1>

<h3>Wypełnij poniższy formularz aby się zarejestrować:</h3>

<form method="post" action="register">
    <b>Login:</b>
    <br/>
    <input name="login" type="text">
    <br/>

    <b>Password</b>
    <br/>
    <input name="password" type="password">
    <br/>

    <hr/>

    <b>Name:</b>
    <br/>
    <input name="name" type="text">
    <br/>

    <b>Surname:</b>
    <br/>
    <input name="surname" type="text">
    <br/>

    <b>Role:</b>
    <br/>
    <input name = "role" list="role">
    <datalist id="role">
        <option value="Common">
        <option value="Worker">
    </datalist>
    <br/>

    <b>City:</b>
    <br/>
    <input name = "city" list="city">
    <datalist id="city">
        <option value="Warszawa">
        <option value="Wrocław">
        <option value="Kraków">
        <option value="Inne">
    </datalist>
    <br/>

    <br/>
    <input type="submit" value="Register">

</form>

</body>
</html>
