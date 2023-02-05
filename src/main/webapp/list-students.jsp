<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<a href="index.jsp">test page</a>
<br>

<head>
    <title>Student Tracker App</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>





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


                <c:forEach var="tempStudent" items="${STUDENT_LIST}">

                    <tr>
                        <td> ${tempStudent.firstName}</td>
                        <td> ${tempStudent.lastName}</td>
                        <td> ${tempStudent.email}</td>
                    </tr>

                </c:forEach>




            </table>
        </div>
    </div>




</body>
</html>
