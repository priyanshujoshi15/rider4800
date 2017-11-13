<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AccessDenied page</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
 	Your credentials are empty or wrong.. !! Please try again.

    <a href="${pageContext.request.contextPath }/admin/index/">Retry Login !!</a>
</body>
</html>