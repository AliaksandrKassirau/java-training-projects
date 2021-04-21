package com.epam.webapplication.mvc.controllers;

import com.epam.webapplication.domain.User;
import com.epam.webapplication.mvc.DispatcherController;
import com.epam.webapplication.mvc.ModelAndView;
import com.epam.webapplication.services.impl.ListUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UsersReadController implements DispatcherController {

    @Override
    public boolean isHandlerApplicable(HttpServletRequest req) {
        String uri = req.getRequestURI();
        return uri.contains("/users");
    }

    @Override
    public ModelAndView handle(HttpServletRequest req) {
        List<User> allUsers = ListUserService.getService().getAllUsers();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView("usersList");
        modelAndView.setAttribute("users", allUsers);

        return modelAndView;
    }
}
