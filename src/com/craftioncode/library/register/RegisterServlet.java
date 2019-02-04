package com.craftioncode.library.register;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.craftioncode.library.domain.users.User;
import com.craftioncode.library.domain.users.UserBuilder;
import com.craftioncode.library.domain.users.dao.UsersDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String role = req.getParameter("role");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String city = req.getParameter("city");

		Optional<User> userByLoginOpt = UsersDAO.getByLogin(login);

		if (userByLoginOpt.isPresent()) {
			resp.sendRedirect("registerError.jsp");
		} else {

			User user = UserBuilder.builder()
					.setName(name)
					.setSurname(surname)
					.setRole(role)
					.setLogin(login)
					.setPassword(password)
					.setCity(city)
					.build();

			resp.sendRedirect("login.jsp?registered=" + login);
		}// else if(userByLoginOpt.isPresent())

	}
}
