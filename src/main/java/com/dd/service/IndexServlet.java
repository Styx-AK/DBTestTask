package com.dd.service;

import com.dd.utils.JDBCUtil;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO index page with 3 links/buttons/radio(most likely) to 3 other Servlets

        //test
        resp.setContentType("text/html");
//        resp.setStatus(HttpServletResponse.SC_OK);
//        resp.getWriter().println("<h1>Hello Index Servlet</h1>");
//        resp.getWriter().println("session=" + req.getSession(true).getId());

        //JDBC test
        JDBCUtil jdbcUtil = new JDBCUtil();

        //подключаемся к БД
        try {
            jdbcUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //копируем данные из csv файла
        CopyManager copyManager = null;
        try {
            copyManager = new CopyManager((BaseConnection) jdbcUtil.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        FileReader fileReader = new FileReader(new File("src/main/resources/test_case.csv"));

        try {
            copyManager.copyIn("COPY test_task_table from STDIN with delimiter as ';'", fileReader);

            resp.getWriter().println("<h4>Coping data from CSV to DB was successful</h4>");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().println("<h4>Ops! Something went wrong...</h4>");
        }

        //TODO создать таблицу с полями заранее и только после этого загрухать в нее данные из CSV.



    }
}
