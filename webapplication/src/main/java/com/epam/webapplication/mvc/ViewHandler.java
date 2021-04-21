package com.epam.webapplication.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ViewHandler {
    void renderView(ModelAndView modelAndView,
                    HttpServletRequest req,
                    HttpServletResponse resp) throws ServletException, IOException;
}
