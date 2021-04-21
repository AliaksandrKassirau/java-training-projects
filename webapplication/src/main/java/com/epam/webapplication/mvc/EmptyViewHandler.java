package com.epam.webapplication.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmptyViewHandler implements ViewHandler {
    @Override
    public void renderView(ModelAndView modelAndView, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
