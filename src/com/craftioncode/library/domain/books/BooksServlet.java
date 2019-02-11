package com.craftioncode.library.domain.books;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class BooksServlet extends HttpServlet {

	@EJB
	private BooksDAO2 booksDAO2;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		writer.write(booksDAO2.getAll().toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

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

		booksDAO2.add(book);

		resp.getWriter().write(String.format("Book with id %s has been created!", book.getId()));

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String author = req.getParameter("author");
		String isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		String year = req.getParameter("year");

		booksDAO2.update(Integer.valueOf(id), author, title, isbn, Integer.valueOf(year));
		resp.getWriter().write(String.format("book with id %s has been updated!", id));
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		booksDAO2.delete(Integer.valueOf(id));
		resp.getWriter().write(String.format("book with id %s has been deleted!", id));
	}

}
