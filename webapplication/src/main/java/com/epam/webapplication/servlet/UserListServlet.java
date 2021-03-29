package com.epam.webapplication.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.webapplication.domain.User;
import com.epam.webapplication.services.impl.ListUserService;

@WebServlet(urlPatterns = { "/userList" })
public class UserListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<User> allUsers = ListUserService.getService().getAllUsers();

		req.setAttribute("users", allUsers);

		req.getServletContext().getRequestDispatcher("/list.jsp").forward(req, resp);

	}

}
