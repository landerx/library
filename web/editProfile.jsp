<%@ page import="com.craftioncode.library.domain.users.User" %>
<%@ page import="com.craftioncode.library.domain.users.dao.UsersDAOV2" %><%--
  Created by IntelliJ IDEA.
  User: piotrlandzwojczak
  Date: 07/02/2019
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Edit profile</title>
</head>
<body>
<%
    UsersDAOV2 usersDAOV2 = new UsersDAOV2();
    User editUser = usersDAOV2.getByLogin(request.getSession().getAttribute("username").toString());

%>
<form class="form-signin" action='editProfile' method="POST">
    <div id="legend">
        <legend class="">Edit profile</legend>
    </div>
    <%
        if (request.getParameter("userExist") != null) {
    %>
    <div class="alert alert-danger" role="alert">
        User with provided username exist!
    </div>
    <% }
    %>
    <%
        if (request.getParameter("validationError") != null) {
    %>
    <div class="alert alert-danger" role="alert">
        You need to fill all the fields!
    </div>

    <% }
    %>
    <input type="hidden" id="id" name="id" placeholder="" value="<%=editUser.getId() %>" class="input-xlarge">

    <div class="control-group">
        <!-- Name -->
        <label class="control-label" for="name">Name</label>
        <div class="controls">
            <input type="text" id="name" name="name" placeholder="" value="<%=editUser.getName()%>"
                   class="input-xlarge">
            <p class="help-block">Name can contain any letters</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Surname -->
        <label class="control-label" for="surname">Surname</label>
        <div class="controls">
            <input type="text" id="surname" name="surname" placeholder="" value="<%=editUser.getSurname()%>"
                   class="input-xlarge">
            <p class="help-block">Please provide your surname</p>
        </div>
    </div>

    <div class="control-group">
        <!-- City -->
        <label class="control-label" for="city">City</label>
        <div class="controls">
            <input type="text" id="city" name="city" placeholder="" value="<%=editUser.getCity()%>"
                   class="input-xlarge">
            <p class="help-block">Please provide your city</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Role -->
        <label class="control-label" for="role">Role</label>
        <div class="controls">
            <input type="text" id="role" name="role" placeholder="" value="<%=editUser.getRole()%>"
                   class="input-xlarge">
            <p class="help-block">Please provide your role</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Username -->
        <label class="control-label" for="username">Username</label>
        <div class="controls">
            <input type="text" id="username" name="username" placeholder="" value="<%=editUser.getLogin()%>"
                   class="input-xlarge">
            <p class="help-block">Username can contain any letters or numbers, without spaces</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Password-->
        <label class="control-label" for="password">Password</label>
        <div class="controls">
            <input type="password" id="password" name="password" placeholder="" value="<%=editUser.getPassword()%>"
                   class="input-xlarge">
            <p class="help-block">Password should be at least 4 characters</p>
        </div>
    </div>

    <label>
        <a href="index.jsp"> Back to home page</a>
    </label>

    <div class="control-group">
        <!-- Button -->
        <div class="controls">
            <button class="btn btn-success" type="submit">Edit profile</button>
        </div>
    </div>
</form>
</body>
</html>