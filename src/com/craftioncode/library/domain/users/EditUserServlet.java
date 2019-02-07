package com.craftioncode.library.domain.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.craftioncode.library.domain.users.dao.UsersDAOV2;

@WebServlet("/editProfile")
public class EditUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String role = req.getParameter("role");
		String login = req.getParameter("username");
		String password = req.getParameter("password");
		String city = req.getParameter("city");
		String id = req.getParameter("id");

		User user = UserBuilder.builder()
				.setId(Integer.valueOf(id))
				.setName(name)
				.setSurname(surname)
				.setRole(role)
				.setLogin(login)
				.setPassword(password)
				.setCity(city)
				.build();

		UsersDAOV2.update(user);
		HttpSession session = req.getSession();
		session.setAttribute("username", user.getLogin());
		resp.sendRedirect("index.jsp");

	}
}
