package com.craftioncode.library.domain.books;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createBook")
public class CreateBookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String author = req.getParameter("author");
		String isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		String year = req.getParameter("year");

		Book book = BookBuilder.builder()
				.setAuthor(author)
				.setIsbn(isbn)
				.setTitle(title)
				.setYear(Integer.valueOf(year))
				.build();

		BooksDAO.add(book);
		resp.sendRedirect("books.jsp");
	}
}
