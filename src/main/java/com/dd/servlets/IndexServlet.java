package com.dd.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

//        PrintWriter writer = resp.getWriter(); //one way
//        writer.println("TEST1 response");
//
//        resp.getWriter().write("TEST2 response"); //or other way


        req.getRequestDispatcher("/WEB-INF/view/index.jsp").include(req, resp); //включает в себя логику сервлета
//        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp); //НЕ включает в себя логику сервлета
    }
}
