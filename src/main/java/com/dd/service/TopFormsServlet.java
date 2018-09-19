package com.dd.service;

import com.dd.utils.JDBCUtil;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.dd.utils.JDBCUtil.close;


public class TopFormsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<h4>В) Составить ТОП – 5 самых используемых форм.</h4>");

        JDBCUtil jdbcUtil = new JDBCUtil();

        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT DISTINCT formid FROM test_task_table ORDER BY formid DESC LIMIT 6;";
        //LIMIT 6 - because the first row is null(empty) and this row won't be included into "formids".

        List<String> formids = new ArrayList<>();

        try {
            System.out.println("Creating connection to database...");
            jdbcUtil.getMyConnection();
            statement = jdbcUtil.getMyConnection().createStatement();

            System.out.println("Making query request...");
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                String formid = resultSet.getString("formid");
                if (formid != null) {
                    formids.add(formid);
                }
            }

            close(resultSet, statement, jdbcUtil.getMyConnection());

        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().println("<h4>Ops! Something went wrong...</h4>");
        }

        req.setAttribute("formids", formids);

        req.getRequestDispatcher("WEB-INF/view/topforms.jsp").forward(req, resp);
    }
}
