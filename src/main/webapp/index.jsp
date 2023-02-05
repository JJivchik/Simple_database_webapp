<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP test page</title>
</head>
<body>
<h1><%= "Hello World!" %> </h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<a href="TestServlet">TestServlet</a>
<br>
<a href="${pageContext.request.contextPath}/StudentControllerServlet">Student controller servlet</a>


</body>
</html>