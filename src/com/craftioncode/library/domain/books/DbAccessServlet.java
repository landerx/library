package com.craftioncode.library.domain.books;

import java.io.IOException;
import java.sql.Connection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.craftioncode.library.db.DBManager;
import com.craftioncode.library.domain.users.dao.UsersDAOV2;

@WebServlet("/dbAccess")
public class DbAccessServlet extends HttpServlet {

	@EJB
	private UsersDAOV2 usersDAOV2;
	@EJB
	private BooksDAO2 booksDAO2;
	@EJB
	private DBManager dbManager;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		usersDAOV2.addTestData();
		booksDAO2.addTestData();

		Connection connection = dbManager.openConnection();
		resp.getWriter().write("test");
		dbManager.closeConnection(connection);

		//		UsersDAOV2.addTestData();
		//		resp.getWriter().write("testadd");

	}
}
