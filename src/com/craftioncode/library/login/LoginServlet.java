package com.craftioncode.library.login;

import java.io.IOException;
import java.util.Optional;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.craftioncode.library.domain.users.User;
import com.craftioncode.library.domain.users.dao.UsersDAOV2;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@EJB
	private UsersDAOV2 usersDAOV2;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");

		Optional<User> userOpt = usersDAOV2.getAll()
				.stream()
				.filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))
				.findFirst();

		if (userOpt.isPresent()) {
			User user = userOpt.get();
			HttpSession session = req.getSession();
			session.setAttribute("username", user.getLogin());
			resp.sendRedirect("index.jsp");
		} else {
			resp.sendRedirect("login.jsp?invalidLogin");
		}


	}
}
