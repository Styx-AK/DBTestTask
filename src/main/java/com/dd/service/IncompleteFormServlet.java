package com.dd.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IncompleteFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("Б) Вывести список пользователей, которые начали активность на форме и не дошли до конца. Например, для услуг grp dszn_* начальное состояние start, конечное состояние send. Вывести на каком шаге остановился.");
    }

}
