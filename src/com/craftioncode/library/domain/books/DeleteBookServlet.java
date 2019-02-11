package com.craftioncode.library.domain.books;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {

	@EJB
	public BooksDAO2 booksDAO2;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		booksDAO2.delete(Integer.valueOf(id));
		resp.sendRedirect("books.jsp");

	}
}
