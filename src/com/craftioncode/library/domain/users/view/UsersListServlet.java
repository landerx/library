package com.craftioncode.library.domain.users.view;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.craftioncode.library.domain.users.User;
import com.craftioncode.library.domain.users.dao.UsersDAOV2;

@WebServlet("/usersList")
public class UsersListServlet extends HttpServlet {

	@EJB
	private UsersDAOV2 usersDAOV2;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<User> allUsers = usersDAOV2.getAll();
		req.setAttribute("users", allUsers);
		req.getRequestDispatcher("users.jsp").forward(req, resp);

	}
}
