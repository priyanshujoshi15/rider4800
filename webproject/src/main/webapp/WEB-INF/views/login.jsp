<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

		<table align="center">

			<tr>

				<td>Email:</td>

				<td><input type="text" name="email" id="email" />

				</td>

			</tr>

			<tr>

				<td>Password"</td>

				<td><input type="password" name="password"
						id="password" />
						<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
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

				<td><a href="index.jsp">Home</a></td>

			</tr>

		</table>

	</form:form>
<%-- 
	<table align="center">

		<tr>

			<td style="font-style: italic; color: red;">${message}</td>

		</tr>

	</table> --%>

</body>
</html>