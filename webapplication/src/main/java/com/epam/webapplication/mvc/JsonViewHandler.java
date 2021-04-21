package com.epam.webapplication.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonViewHandler implements ViewHandler {
    private final ObjectMapper mapper = new ObjectMapper();
    
    @Override
    public void renderView(ModelAndView modelAndView,
                           HttpServletRequest req,
                           HttpServletResponse response) throws ServletException, IOException {
        String responseString = mapper.writeValueAsString(modelAndView.getAttributes());
        response.setStatus(200);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(responseString);
        out.flush();
    }
}
