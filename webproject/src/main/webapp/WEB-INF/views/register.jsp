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

<%-- <div class="col-lg-12">
	<div class="row">
	<form:form modelAttribute="user" action="saveRegister" method="POST" >
	
	<spring:bind path="email">
		  <div class="form-group">
			<label class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<form:input path="email" type="text" class="form-control"
                                id="email" placeholder="Enter Mail Id" />
				<form:errors path="email" class="control-label" />
			</div>
		  </div>
		</spring:bind>
			
			<spring:bind path="name">
		  <div class="form-group">
			<label class="col-sm-2 control-label">Name</label>
			<div class="col-sm-10">
				<form:input path="name" type="text" class="form-control"
                                id="email" placeholder="Enter Name" />
				<form:errors path="name" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="enabled">
		  <div class="form-group">
			<label class="col-sm-2 control-label">Enabled</label>
			<div class="col-sm-10">
				<form:input path="enabled" type="text" class="form-control"
                                id="enabled" placeholder="Enter Contact No." />
				<form:errors path="enabled" class="control-label" />
			</div>
		  </div>
		</spring:bind>
	
		
			<spring:bind path="password">
		  <div class="form-group">
			<label class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<form:input path="password" type="password" class="form-control"
                                id="password" placeholder="Enter Password" />
				<form:errors path="password" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="role">
		  <div class="form-group">
			<label class="col-sm-2 control-label">Role</label>
			<div class="col-sm-10">
				<form:input path="role" type="text" class="form-control"
                                id="role" placeholder="Enter Role" />
				<form:errors path="role" class="control-label" />
			</div>
		  </div>
		</spring:bind>	
		
		<spring:bind path="address">
		  <div class="form-group">
			<label class="col-sm-2 control-label">Address</label>
			<div class="col-sm-10">
				<form:input path="address" type="text" class="form-control"
                                id="address" placeholder="Enter Address" />
				<form:errors path="address" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="phone">
		  <div class="form-group">
			<label class="col-sm-2 control-label">Contact No.</label>
			<div class="col-sm-10">
				<form:input path="phone" type="text" class="form-control"
                                id="phone" placeholder="Enter Contact No." />
				<form:errors path="phone" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<button type="submit" class="btn btn-lg btn-info" >Submit</button>
		
		<!-- <div class="form-group">
		  <div class="col-sm-offset-2 col-sm-10">
			     <button class="button" style="vertical-align:middle"><span>Submit</span></button>
			     <button class="button" style="vertical-align:middle"><span>Cancel</span></button>
		  </div>
		</div> -->
		
		</div>
		</form:form>
		</div>
		</div>
 --%>

	<div class="generic-container">

		<div class="well lead">User Registration Form</div>
		<form:form method="POST" action="saveRegister" modelAttribute="user" class="form-horizontal">

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="email" id="email"
							class="form-control input-sm" placeholder="Enter Email" />
						<div class="has-error">
							<form:errors path="email" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="address">Address</label>
					<div class="col-md-7">
						<form:input type="text" path="address" id="address"
							class="form-control input-sm" placeholder="Enter Address"/>
						<div class="has-error">
							<form:errors path="address" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="name">Name</label>
					<div class="col-md-7">
						<form:input type="text" path="name" id="name"
							class="form-control input-sm" placeholder="Enter Name" />
						<div class="has-error">
							<form:errors path="name" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Password</label>
					<div class="col-md-7">
						<form:input type="text" path="password" id="password"
							class="form-control input-sm" placeholder="Enter Password"/>
						<div class="has-error">
							<form:errors path="password" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="phone">Phone</label>
					<div class="col-md-7">
						<form:input type="text" path="phone" id="phone"
							class="form-control input-sm" placeholder="Enter Phone"/>
						<div class="has-error">
							<form:errors path="phone" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="roles">Roles</label>
					<div class="col-md-7">
						<form:input path="role" type="text" class="form-control" id="role"
							placeholder="Enter Role" />
						<form:errors path="role" class="control-label" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"
								class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/list' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"
								class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>


</body>
</html>