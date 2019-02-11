<%@ page import="java.util.List" %>
<%@ page import="com.craftioncode.library.domain.books.Book" %>
<%--
  Created by IntelliJ IDEA.
  User: piotrlandzwojczak
  Date: 03/02/2019
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Title</th>
        <th scope="col">ISBN</th>
        <th scope="col">Year</th>
        <th scope="col">Author</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <% for (Book book : books) {%>
    <tr>
        <th scope="row"><%= book.getId()%>
        </th>
        <td><%= book.getTitle()%>
        </td>
        <td><%= book.getIsbn()%>
        </td>
        <td><%= book.getYear()%>
        </td>
        </td>
        <td><%= book.getAuthor()%>
        </td>
        <td><a href="editBook.jsp?id=<%=book.getId()%>">
            <button class="btn btn-info">Edit</button>
        </a>
            <a href="deleteBook?id=<%=book.getId()%>">
                <button class="btn btn-danger">Delete</button>
            </a>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>


</a>
<a href="createBook.jsp">
    <button class="btn btn-success">Create Book</button>
</a>

</body>
</html>
