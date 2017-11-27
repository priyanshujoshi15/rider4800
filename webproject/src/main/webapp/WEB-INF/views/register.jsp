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
<title>Register Page</title>
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="generic-container">
		<h1>Registration Form</h1>
		<div class="col-lg-12">
			<div class="row">
				<form:form modelAttribute="user" action="saveRegister" method="POST">
					<div class="col-lg-12">
						<div class="form-group">
							<form:errors path="email" cssclass="err" />
							<br> <label>Email:</label>
							<form:input path="email" placeholder="Enter Mail ID.."
								class="form-control" />
						</div>

						<div class="form-group">
							<form:errors path="address" cssclass="err" />
							<br> <label>Address:</label> 
							<form:input path="address" placeholder="Enter Address.."
								class="form-control" />
						</div>

						<div class="form-group">
							<form:errors path="name" cssclass="err" />
							<br> <label>Name:</label> 
							<form:input path="name" placeholder="Enter Name.."
								class="form-control" />
						</div>

						<div class="form-group">
							<form:errors path="password" cssclass="err" />
							<br> <label>Password:</label> 
							<form:input path="password" placeholder="Enter Password.."
								class="form-control" />
						</div>

						<div class="form-group">
							<form:errors path="phone" cssclass="err" />
							<br> <label>Phone:</label> 
							<form:input path="phone" placeholder="Enter Contact No.."
								class="form-control" />
						</div>

						<div class="form-group">
							<form:errors path="role" cssclass="err" />
							<br> <label>Role:</label> 
							<form:input path="role" placeholder="Enter Role.."
								class="form-control" />
						</div>

						<div class="form-group">
							<input type="submit" value="Register"
								class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/' />">Cancel</a>
						</div>

					</div>

				</form:form>
			</div>
		</div>
	</div>
</body>
</html>