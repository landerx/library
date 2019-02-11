package com.craftioncode.library.domain.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.craftioncode.library.domain.users.dao.UsersDAOV2;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

	@EJB
	private UsersDAOV2 usersDAOV2;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		writer.write(usersDAOV2.getAll().toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String role = req.getParameter("role");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String city = req.getParameter("city");

		User user = UserBuilder.builder()
				.setName(name)
				.setSurname(surname)
				.setRole(role)
				.setLogin(login)
				.setPassword(password)
				.setCity(city)
				.build();

		usersDAOV2.add(user);
		resp.getWriter().write(String.format("user with id %s has been created!", user.getId()));
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

		User user = UserBuilder.builder()
				.setId(Integer.valueOf(id))
				.setName(name)
				.setSurname(surname)
				.setLogin(login)
				.setPassword(password)
				.setCity(city)
				.setRole(role)
				.build();

		usersDAOV2.update(user);
		resp.getWriter().write(String.format("user with id %s has been updated!", id));

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		usersDAOV2.delete(Integer.valueOf(id));
		resp.getWriter().write(String.format("user with id %s has been deleted!", id));

	}

}
