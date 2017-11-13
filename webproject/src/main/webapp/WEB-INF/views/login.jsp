<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />

<title>Login Page</title>
</head>

<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>

	<form:form modelAttribute="user" action="login" method="POST">

		<c:if test="${param.error != null}">
			<div class="alert alert-danger">
				<p>Invalid username and password.</p>
			</div>
		</c:if>
		<c:if test="${param.logout != null}">
			<div class="alert alert-success">
				<p>You have been logged out successfully.</p>
			</div>
		</c:if>

		<table align="center">

			<tr>

				<td>Email</td>

				<td><input type="text" name="email" id="email" /></td>

			</tr>

			<tr>

				<td>Password</td>

				<td><input type="password" name="password" id="password" /> 
				</td>

			</tr>

			<tr>

				<td></td>

				<td align="left"><input type="submit" id="login" value="Login">

				</td>

			</tr>

			<tr></tr>

			<tr>

				<td></td>

				<td><a href="<c:url value = "/"/>">Home</a></td>

			</tr>

		</table>



	</form:form>

</body>
</html>