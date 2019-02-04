package com.craftioncode.library.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class SecurityFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String requestURI = req.getRequestURI();
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");

		boolean doesRequestURIContainsAuthPaths = requestURI.endsWith("login.jsp") ||
				requestURI.endsWith("login") ||
				requestURI.endsWith("register") ||
				requestURI.endsWith("registerError.jsp") ||
				requestURI.endsWith("register.jsp") ||
				requestURI.contains("css") ||
				requestURI.contains("assets");
		if (!doesRequestURIContainsAuthPaths && username == null) {
			session.setAttribute("redirectLink", requestURI);
			res.sendRedirect("login.jsp");
		} else {
			chain.doFilter(req, res);
		}

	}

}