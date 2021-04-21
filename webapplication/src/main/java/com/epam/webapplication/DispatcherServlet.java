package com.epam.webapplication;

import com.epam.webapplication.mvc.*;
import com.epam.webapplication.mvc.controllers.UsersCreateController;
import com.epam.webapplication.mvc.controllers.UsersReadController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = { "/dispatcher/*" })
@Slf4j
public class DispatcherServlet extends HttpServlet {
    private List<DispatcherController> controllers;
    private final ViewResolver viewResolver;

    public DispatcherServlet() {
        initControllers();
        this.viewResolver = new ViewResolverImpl();
        // найти все пути, поддерживаемые системой
        // найти все представления
        // различная метаинформация, используемая при составлении запроса
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Получен запрос {}", req.getRequestURI());

        for (DispatcherController dispatcherController: controllers) {
            if (dispatcherController.isHandlerApplicable(req)) {
                log.info("Выбран контроллер для обработки {}", dispatcherController.getClass().toString());
                ModelAndView modelAndView = dispatcherController.handle(req);
                ViewHandler viewHandler = viewResolver.resolveView(req);
                viewHandler.renderView(modelAndView, req, resp);
            }
        }

        // 404 logic handling
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    private void initControllers() {
        this.controllers = new ArrayList<>();
        this.controllers.add(new UsersCreateController());
        this.controllers.add(new UsersReadController());
    }
}
