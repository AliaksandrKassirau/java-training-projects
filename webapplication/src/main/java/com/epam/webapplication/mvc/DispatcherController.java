package com.epam.webapplication.mvc;

import javax.servlet.http.HttpServletRequest;

public interface DispatcherController {
    boolean isHandlerApplicable(HttpServletRequest req);

    ModelAndView handle(HttpServletRequest req);
}
