package com.craftioncode.library.domain.books.view;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.craftioncode.library.domain.books.Book;
import com.craftioncode.library.domain.books.BooksDAO2;

@WebServlet("/booksList")
public class BooksListServlet extends HttpServlet {

	@EJB
	private BooksDAO2 booksDAO2;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Book> allBooks = booksDAO2.getAll();

		req.setAttribute("books", allBooks);
		req.getRequestDispatcher("books.jsp").forward(req, resp);

	}
}
