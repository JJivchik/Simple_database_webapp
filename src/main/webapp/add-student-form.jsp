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
        <h3>Add Student</h3>

        <form action="${pageContext.request.contextPath}/StudentControllerServlet" method="get">

            <input type="hidden" name="command" value="ADD">

            <table>
                <tbody>
                    <tr>
                        <td><label>First name:</label></td>
                        <td><input type="text" name="firstName"></td>
                    </tr>
                    <tr>
                        <td><label>Last name:</label></td>
                        <td><input type="text" name="lastName"></td>
                    </tr>
                    <tr>
                        <td><label>Email:</label></td>
                        <td><input type="text" name="email"></td>
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
