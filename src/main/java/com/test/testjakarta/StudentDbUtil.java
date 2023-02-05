package com.test.testjakarta;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {

    private DataSource dataSource;

    public StudentDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Student> getStudents() throws Exception {

        List<Student> students = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;


        try {

            String sql = "select * from student order by last_name";
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {

                int id = myRs.getInt("id");
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");

                Student tempStudent = new Student(id, firstName, lastName, email);
                students.add(tempStudent);

            }
            return students;
        }catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            close(myConn, myStmt, myRs);
        }
        return students;
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {

            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }

        } catch (Exception exc) {
         exc.printStackTrace();
        }

    }


}
