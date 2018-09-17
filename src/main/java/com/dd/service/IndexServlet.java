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
import java.sql.Statement;


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
        Statement statement = null;
        String sqlCreateTable = "CREATE TABLE test_task_table +(" +
                "id SERIAL PRIMARY KEY," + // Сквозной ID
                "ssoid VARCHAR(255) NOT NULL," + // Уникальный идентификатор пользователей
                "ts NUMERIC(10,0) NOT NULL," + // Время
                "grp VARCHAR(20) NOT NULL," + // Группа события
                "type VARCHAR(20) NOT NULL," + // Тип события
                "subtype VARCHAR(20) NOT NULL," + // Подтип события
                "url VARCHAR(255)," + // Адрес с которого пришло событие
                "orgid VARCHAR(20)," + // Организация предоставляющая услугу
                "formid VARCHAR(20)," + // Идентификатор формы
                "code VARCHAR(5)," + // код формы(?)
                "ltpa VARCHAR(20)," + // Ключ сессии (в данном наборе пустой)
                "sudirresponse VARCHAR(20)," + // Ответ от сервиса авторизации (в данном наборе пустой)
                "ymdh DATE NOT NULL)"; //Дата в формате YYYY-MM-DD-HH

        //подключаемся к БД
        try {
            jdbcUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Создаем таблицу в БД
        try {
             statement = jdbcUtil.getConnection().createStatement();
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

        //TODO создать таблицу с полями заранее и только после этого загружать в нее данные из CSV.





    }
}
