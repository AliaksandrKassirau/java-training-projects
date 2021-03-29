package com.epam.webapplication.servlet;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.webapplication.domain.User;
import com.epam.webapplication.services.UserService;
import com.epam.webapplication.services.impl.ListUserService;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String passw = req.getParameter("password");

		UserService service = ListUserService.getService();

		User byLogin = service.getByLogin(login);

		if (byLogin == null || !byLogin.getPassword().equals(passw)) {
			req.setAttribute("userNotFound", "true");
			req.getServletContext().getRequestDispatcher("/").forward(req, resp);
		}

		req.getSession().setAttribute("user", byLogin);

		req.getServletContext().getRequestDispatcher("/userList").forward(req, resp);
	}

}
