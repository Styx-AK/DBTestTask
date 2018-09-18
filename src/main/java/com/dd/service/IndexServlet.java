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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.dd.utils.JDBCUtil.*;


public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        //JDBC connection test
        JDBCUtil jdbcUtil = new JDBCUtil();

        Statement statement = null;
        ResultSet resultSet = null;
        CopyManager copyManager = null;
        String sqlCreateTable = "DROP TABLE IF EXISTS test_task_table; " +
                "CREATE TABLE test_task_table(" + // IF NOT EXISTS (поставить после CREATE TABLE в случае необходимости)
                "ssoid VARCHAR(255), " + // Уникальный идентификатор пользователей
                "ts NUMERIC(10,0) NOT NULL, " + // Время
                "grp VARCHAR(25) NOT NULL, " + // Группа события
                "type VARCHAR(25) NOT NULL, " + // Тип события
                "subtype VARCHAR(25), " + // Подтип события
                "url VARCHAR(255), " + // Адрес с которого пришло событие
                "orgid VARCHAR(25), " + // Организация предоставляющая услугу
                "formid VARCHAR(25), " + // Идентификатор формы
                "code VARCHAR(5), " + // код формы(?)
                "ltpa VARCHAR(25), " + // Ключ сессии (в данном наборе пустой)
                "sudirresponse VARCHAR(25), " + // Ответ от сервиса авторизации (в данном наборе пустой)
                "ymdh VARCHAR(13) NOT NULL)"; //Дата в формате YYYY-MM-DD-HH

        try {
            //подключаемся к БД
            System.out.println("Creating connection to database...");

            jdbcUtil.getMyConnection();

            // Создаем таблицу в БД
            System.out.println("Creating table in selected database...");

            statement = jdbcUtil.getMyConnection().createStatement();
            statement.executeUpdate(sqlCreateTable);

            resp.getWriter().println("<h4>Table have been created in the DB successfully</h4>");
            System.out.println("Table have been created in the DB successfully");

            //копируем данные из csv файла

            //через командную строку получилось скопировать данные из CSV в таблицу данной командой:
            // \copy test_task_table FROM 'C:\Users\Tom\Downloads\test_case.csv' WITH(FORMAT CSV, HEADER true, delimiter ';');


//            System.out.println("Coping data from CSV file to the table...");
//            copyManager = new CopyManager((BaseConnection) jdbcUtil.getMyConnection());
//
//            FileReader fileReader = new FileReader(new File("src/main/resources/test_case.csv"));
//
//            try {
//                copyManager.copyIn("COPY test_task_table from STDIN with delimiter as ';'", fileReader);
//                resp.getWriter().println("<h4>Coping data from CSV to the table was successful</h4>");
//            } catch (SQLException e) {
//                e.printStackTrace();
//                resp.getWriter().println("<h4>Ops! Something went wrong...with coping CSV into DB.</h4>");
//            }
            close(resultSet, statement, jdbcUtil.getMyConnection());


        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().println("<h4>Ops! Something went wrong...with table creating.</h4>");
            System.out.println("Ops! Something went wrong...with table creating.");
        }






    }
}
