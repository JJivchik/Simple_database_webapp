package com.test.testjakarta;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {
    @Resource(name = "jdbc/web_student_tracker")
    DataSource dataSource;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        out.println("<html><body>");
        out.println("<a href=\"index.jsp\">JSP test page</a>");
        out.println("<br>");
        out.println("<br>");

        try {
            myConn = dataSource.getConnection();
            String sql = "select * from student";
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {
                String email = myRs.getString("email");
                out.println(email);
                out.println("<br>");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
