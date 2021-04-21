package com.epam.webapplication.mvc.controllers;

import com.epam.webapplication.mvc.DispatcherController;
import com.epam.webapplication.mvc.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class UsersCreateController implements DispatcherController {
    @Override
    public boolean isHandlerApplicable(HttpServletRequest req) {
        return "POST".equals(req.getMethod());
    }

    @Override
    public ModelAndView handle(HttpServletRequest req) {
        return null;
    }
}
