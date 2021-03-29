package com.epam.webapplication.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.webapplication.services.impl.ListUserService;

@WebServlet(urlPatterns = { "/admin/user-delete" })
public class UserDeletionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String parameter = req.getParameter("id");
		Integer userId = Integer.valueOf(parameter);

		ListUserService.getService().deleteUser(userId);

		req.getServletContext().getRequestDispatcher("/userList").forward(req, resp);
	}

}
