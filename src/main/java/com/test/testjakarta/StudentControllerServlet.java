package com.test.testjakarta;

import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentControllerServlet", value = "/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {

    private StudentDbUtil studentDbUtil;

    @Resource(name = "jdbc/web_student_tracker" )
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            studentDbUtil = new StudentDbUtil(dataSource);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            listStudent(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Student> students = studentDbUtil.getStudents();
        request.setAttribute("STUDENT_LIST" ,students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
