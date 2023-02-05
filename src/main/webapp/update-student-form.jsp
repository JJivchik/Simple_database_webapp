<!DOCTYPE html>

<html>


<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">


<body>
    <div id="wrapper">
        <div id="header">
            <h2>Test University</h2>
        </div>
    </div>

    <div id="container">
        <h3>Update Student</h3>

        <form action="${pageContext.request.contextPath}/StudentControllerServlet" method="get">

            <input type="hidden" name="command" value="UPDATE">
            <input type="hidden" name="studentId" value="${THE_STUDENT.id}">

            <table>
                <tbody>
                    <tr>
                        <td><label>First name:</label></td>
                        <td><input type="text" name="firstName" value="${THE_STUDENT.firstName}"></td>
                    </tr>
                    <tr>
                        <td><label>Last name:</label></td>
                        <td><input type="text" name="lastName" value="${THE_STUDENT.lastName}"></td>
                    </tr>
                    <tr>
                        <td><label>Email:</label></td>
                        <td><input type="text" name="email" value="${THE_STUDENT.email}"></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"></td>
                    </tr>
                </tbody>
            </table>

        </form>

        <div style="clear: both;"></div>

        <p>
            <a href="${pageContext.request.contextPath}/StudentControllerServlet">Back to list</a>
        </p>

    </div>



</body>

</html>
