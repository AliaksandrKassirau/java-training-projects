package com.epam.webapplication.mvc;

import javax.servlet.http.HttpServletRequest;

public class ViewResolverImpl implements ViewResolver {

    @Override
    public ViewHandler resolveView(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        if (requestURI.contains(".html")) {
            return new JspViewHandler();
        } else if (requestURI.contains(".json")) {
            return new JsonViewHandler();
        }
        return new JspViewHandler();
    }
}
