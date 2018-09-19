package com.dd.service;

import com.dd.utils.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class TopFormsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("В) Составить ТОП – 5 самых используемых форм.");

        JDBCUtil jdbcUtil = new JDBCUtil();

        Statement statement = null;
        ResultSet resultSet = null;
    }
}
