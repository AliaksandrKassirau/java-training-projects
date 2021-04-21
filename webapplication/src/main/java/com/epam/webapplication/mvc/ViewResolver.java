package com.epam.webapplication.mvc;

import javax.servlet.http.HttpServletRequest;

public interface ViewResolver {

    ViewHandler resolveView(HttpServletRequest req);
}
