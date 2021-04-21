package com.epam.webapplication.mvc;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JspViewHandler implements ViewHandler {

    @Override
    public void renderView(ModelAndView modelAndView,
                           HttpServletRequest req,
                           HttpServletResponse resp) throws ServletException, IOException {
        modelAndView.getAttributes().entrySet().forEach((entry -> {
            req.setAttribute(entry.getKey(), entry.getValue());
        }));
        log.info("Подготовка данных для рендеринга прошла успешно {}", modelAndView);
        req.setAttribute("skipController", true);
        req.getServletContext()
                .getRequestDispatcher(String.format("/%s.jsp", modelAndView.getView())).forward(req, resp);
    }
}
