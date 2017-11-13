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

<title>Contact Us</title>
</head>
<body>
	<form id="contact_form" action="#" method="POST"
		enctype="multipart/form-data">
		<div class="row">
			<label for="name">Your name:</label><br /> <input id="name"
				class="input" name="name" type="text" value="" size="30" /><br />
		</div>
		<div class="row">
			<label for="email">Your email:</label><br /> <input id="email"
				class="input" name="email" type="text" value="" size="30" /><br />
		</div>
		<div class="row">
			<label for="message">Your message:</label><br />
			<textarea id="message" class="input" name="message" rows="7"
				cols="30"></textarea>
			<br />
		</div>
		<input id="submit_button" type="submit" value="Send email" />
	</form>



</body>
</html>