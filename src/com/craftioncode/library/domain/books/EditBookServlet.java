package com.craftioncode.library.domain.books;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {

	@EJB
	private BooksDAO2 booksDAO2;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String author = req.getParameter("author");
		String isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		String year = req.getParameter("year");

		booksDAO2.update(Integer.valueOf(id), author, title, isbn, Integer.valueOf(year));
		resp.sendRedirect("books.jsp");
	}
}
