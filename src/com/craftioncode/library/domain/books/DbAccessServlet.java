package com.craftioncode.library.domain.books;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.craftioncode.library.db.DBManager;
import com.craftioncode.library.domain.users.dao.UsersDAOV2;

@WebServlet("/dbAccess")
public class DbAccessServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersDAOV2.addTestData();
		BooksDAO2.addTestData();

		try (Connection connection = DBManager.openConnection()) {
			resp.getWriter().write("test123");

		} catch (Exception e) {
			e.printStackTrace();
		}


		//		UsersDAOV2.addTestData();
		//		resp.getWriter().write("testadd");

	}
}
