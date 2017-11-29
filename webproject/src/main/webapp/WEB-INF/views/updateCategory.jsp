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
	<%@page isELIgnored="false" %>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<form method="post" action="<c:url value="/admin/updateCategory" />"
			class="form-signin">
			<span id="reauth-email" class="reauth-email"></span> <input
				class="form-control" type="hidden" name="cid" value="${c.cid }"
				required />
			</td>
			<h4 class="input_title">category Name</h4>
			<input class="form-control" type="text" name="cname"
				value="${c.cname }" required />
			</td>
			<button class="btn btn-lg btn-primary" type="submit">Update</button>
			<button class="btn btn-lg btn-primary" type="reset">Cancel</button>
		</form>
	</div>
</body>
</html>