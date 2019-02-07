<%@ page import="com.craftioncode.library.domain.books.Book" %>
<%@ page import="com.craftioncode.library.domain.books.BooksDAO" %>
<%@ page import="com.craftioncode.library.domain.books.BooksDAO2" %>
<%--
  Created by IntelliJ IDEA.
  User: piotrlandzwojczak
  Date: 03/02/2019
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
<%
    String bookId = request.getParameter("id");
    Book editBook = BooksDAO2.getById(Integer.valueOf(bookId));
%>

<form class="form-signin" action='editBook' method="POST">
    <div id="legend">
        <legend class="">Edit book</legend>
    </div>

    <div class="control-group">
        <!-- ID -->
        <input type='hidden' name='id' id='bookId' value='<%= editBook.getId()%>'/>

        <!-- Title -->
        <label class="control-label" for="title">Name</label>
        <div class="controls">
            <input type="text" id="title" name="title" placeholder="" class="input-xlarge"
                   value="<%= editBook.getTitle()%>">
            <p class="help-block">Title of a book</p>
        </div>
    </div>

    <div class="control-group">
        <!-- ISBN -->
        <label class="control-label" for="isbn">ISBN</label>
        <div class="controls">
            <input type="text" id="isbn" name="isbn" placeholder="" class="input-xlarge"
                   value="<%= editBook.getIsbn()%>">
            <p class="help-block">Please provide ISBN of a book</p>
        </div>
    </div>

    <div class="control-group">
        <!-- ISBN -->
        <label class="control-label" for="author">Author</label>
        <div class="controls">
            <input type="text" id="author" name="author" placeholder="" class="input-xlarge"
                   value="<%= editBook.getAuthor()%>">
            <p class="help-block">Please provide Author</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Year -->
        <label class="control-label" for="year">Year</label>
        <div class="controls">
            <input type="number" id="year" name="year" placeholder="" class="input-xlarge"
                   value="<%= editBook.getYear()%>">
            <p class="help-block">Please provide year of publish</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Button -->
        <div class="controls">
            <button class="btn btn-success" type="submit">Edit book</button>
        </div>
    </div>

</form>
</body>
</html>
