<%@ page import="java.util.*, com.test.testjakarta.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

<a href="index.jsp">test page</a>
<br>

<head>
    <title>Student Tracker App</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>




<%
    List<Student> theStudents = (List<Student>) request.getAttribute("STUDENT_LIST");
%>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>Test University</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <table>

                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>

                <% for (Student tempStudent : theStudents) { %>

                    <tr>
                        <td> <%= tempStudent.getFirstName()%></td>
                        <td> <%= tempStudent.getLastName()%></td>
                        <td> <%= tempStudent.getEmail()%></td>
                    </tr>


                <% } %>

            </table>
        </div>
    </div>




</body>
</html>
