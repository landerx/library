package com.craftioncode.library.domain.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.craftioncode.library.domain.users.dao.UsersDAO;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		writer.write(UsersDAO.getAll().toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String role = req.getParameter("role");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String city = req.getParameter("city");

		User user = UserBuilder.builder()
				.setId(Integer.valueOf(id))
				.setName(name)
				.setSurname(surname)
				.setRole(role)
				.setLogin(login)
				.setPassword(password)
				.setCity(city)
				.build();

		boolean isCreated = UsersDAO.add(user);
		if (isCreated) {
			resp.getWriter().write(String.format("user with id %s has been created!", id));
		} else {
			resp.getWriter().write(String.format("action failed, user with id %s already exists!", id));
		}

	}

	//example request
	//http://localhost:8080/library_war_exploded/users?id=1&name=updated&surname=updated&role=updated&login=updated&password=updated&city=test

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String role = req.getParameter("role");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String city = req.getParameter("city");

		boolean isUserUpdated = UsersDAO.update(Integer.valueOf(id), name, surname, login, password, city, role);

		if (isUserUpdated) {
			resp.getWriter().write(String.format("user with id %s has been updated!", id));
		} else {
			resp.getWriter().write(String.format("user with id %s DOESNT FOUND!", id));
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		boolean isUserDeleted = UsersDAO.delete(Integer.valueOf(id));
		if (isUserDeleted) {
			resp.getWriter().write(String.format("user with id %s has been deleted!", id));
		} else {
			resp.getWriter().write(String.format("user with id %s DOESNT FOUND!", id));
		}
	}

}
