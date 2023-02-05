package com.test.testjakarta;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentControllerServlet", value = "/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {

    private StudentDbUtil studentDbUtil;

    @Resource(name = "jdbc/web_student_tracker")
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

            String theCommand = request.getParameter("command");

            if (theCommand == null) {
                theCommand = "LIST";
            }

            switch (theCommand) {

                case "LIST":
                    listStudent(request, response);
                    break;

                case "ADD":
                    addStudent(request, response);
                    break;
                case "LOAD":
                    loadStudent(request, response);
                    break;
                case "UPDATE":
                    updateStudent(request, response);
                    break;
                case "DELETE":
                    deleteStudent(request, response);
                    break;

                default:
                    listStudent(request, response);
            }


        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{

        String theStudentId = request.getParameter("studentId");

        studentDbUtil.deleteStudent(theStudentId);

        listStudent(request, response);


    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{

        int id = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        Student theStudent = new Student(id, firstName, lastName, email);

        studentDbUtil.updateStudent(theStudent);

        listStudent(request, response);
    }

    private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String theStudentId = request.getParameter("studentId");

        Student theStudent = studentDbUtil.getStudent(theStudentId);
        request.setAttribute("THE_STUDENT", theStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        Student theStudent = new Student(firstName, lastName, email);

        studentDbUtil.addStudent(theStudent);

        listStudent(request, response);


    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Student> students = studentDbUtil.getStudents();
        request.setAttribute("STUDENT_LIST", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
