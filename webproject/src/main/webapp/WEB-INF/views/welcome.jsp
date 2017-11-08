<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
	<form:form action="home" method="POST">
    Dear <strong>${user}</strong>, Welcome to Home Page.
    <a href="<c:url value="/logout" />">Logout</a>
	</form:form>
</body>
</html>