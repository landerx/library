package com.craftioncode.library.domain.books;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class BooksServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		writer.write(BooksDAO.getAll().toString());
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
				.setId(Integer.valueOf(id))
				.setAuthor(author)
				.setIsbn(isbn)
				.setTitle(title)
				.setYear(Integer.valueOf(year))
				.build();

		boolean isBookCreated = BooksDAO.add(book);

		if (isBookCreated) {
			resp.getWriter().write(String.format("Book with id %s has been created!", id));
		} else {
			resp.getWriter().write(String.format("action failed, book with id %s already exists!", id));
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String author = req.getParameter("author");
		String isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		String year = req.getParameter("year");

		boolean isUpdated = BooksDAO.update(Integer.valueOf(id), author, title, isbn, Integer.valueOf(year));

		if (isUpdated) {
			resp.getWriter().write(String.format("book with id %s has been updated!", id));
		} else {
			resp.getWriter().write(String.format("book with id %s DOESNT FOUND!", id));
		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		boolean isDeleted = BooksDAO.delete(Integer.valueOf(id));
		if (isDeleted) {
			resp.getWriter().write(String.format("book with id %s has been deleted!", id));
		} else {
			resp.getWriter().write(String.format("book with id %s DOESNT FOUND!", id));
		}
	}

}
