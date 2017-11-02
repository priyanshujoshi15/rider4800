<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Spring MVC Form Example</title>
</head>
<body>

	<nav id="navbar-red"
		class="navbar navbar-inverse navbar-static-top w3-bar w3-black"
		role="navigation">
	<div class="container">
		<ul class="nav navbar-nav">
			<button type="button" class="navbar-toogle collpased"
				data-toggle="collapse" data-target="#bs-example-navbar-1">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</ul>
	</div>

	<div class="collpase navbar-collapse" id="bs-example-navbar-1">
		<ul class="nav navbar-nav">
			<li><a href="<c:url value = "/register"/>"><span
					class="glyphicon glyphicon-user"></span>Register</a></li>

			<li><a href="#"><i class="glyphicon glyphicon-log-in"
					aria-hidden="true"></i>Sign In</a></li>
					
					
			<li><a href="<c:url value = "/admin"/>"><span
					class="glyphicon glyphicon-user"></span>Admin</a></li>

			<li><a href="#">Product Category</a></li>

			<li><a href="<c:url value = "/"/>">Home</a></li>

			<li class="dropdown-menu"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
				<ul class="dropdown-menu">

					<c:forEach var="catVal" items="${catList}">


						<li><a href="/prodCustList?cid=${catVal.cid }">${catVal.name}</a></li>

					</c:forEach>
				</ul></li>
		</ul>
	</div>
	</nav>

</body>

</html>