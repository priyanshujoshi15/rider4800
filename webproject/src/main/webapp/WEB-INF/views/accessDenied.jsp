<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AccessDenied page</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
    Dear <strong>${user}</strong>, You credentials are empty !! Please try again.
        <%-- <a href="<c:url value="/logout" />">Logout</a> --%>
    <a href="<c:url value = "/login"/>">Retry Login !!</a>
</body>
</html>