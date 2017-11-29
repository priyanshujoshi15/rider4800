<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Invoice Page</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<form action="${pageContext.request.contextPath}/ack" method="post">
	
	
							<c:set var="gtot" value="0"></c:set>
							<c:forEach var="c" items="${Cart }">

								<c:set var="gtot"
									value="${gtot + c.cartPrice * c.cartQuantity }">
								</c:set>
								<br>
							</c:forEach>

							<div class="well">
								<table>
									<tr>
										<td colspan="3">Name:</td>
										<td>${user.name}</td>
									</tr>
									<tr>
										<td colspan="3">Email:</td>
										<td>${user.email}</td>
									</tr>
									<tr>
										<td colspan="3">Phone:</td>
										<td>${user.phone}</td>
									</tr>
									<tr>
										<td colspan="3">Address:</td>
										<td>${user.address}</td>
									</tr>
								</table>
							</div>
							<input type="submit" value="OK"
								style:"width:75%"; font-size:20px; class="btn btn-success">
	
	
	</form>
	</div>
	
</body>
</html>