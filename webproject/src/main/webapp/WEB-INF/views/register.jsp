<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
<title>Register Page</title>
</head>

<body>

<%@ include file="/WEB-INF/views/header.jsp" %>

<div class="col-lg-12">
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
	
	
<%-- 	<div class="col-lg-12">
		<div class="form-group">
	<form:errors path="email" cssClass="err" /><br>
	<label>Email:</label>
	<br>
	<form:input path="email" placeholder="Enter Mail Id.." class="form-control" />
		</div> --%>
		
<%-- 		<div class="form-group">
	<form:errors path="name" cssClass="err" /><br>
	<label>Name</label>
	<br>
	<form:input path="name" placeholder="Enter Name.." class="form-control" />
		</div> --%>
		
		<%-- <div class="form-group">
	<form:errors path="password" cssClass="err" /><br>
	<label>Password:</label>
	<br>
	<form:input path="password" placeholder="Enter Password.." class="form-control" />
		</div> --%>
		
	<%-- 	<div class="form-group">
	<form:errors path="role" cssClass="err" /><br>
	<label>Role:</label>
	<br>
	<form:input path="role" placeholder="Enter Role.." class="form-control" />
		</div> --%>
		
<%-- 		<div class="form-group">
	<form:errors path="address" cssClass="err" /><br>
	<label>Address:</label>
	<br>
	<form:input path="address" placeholder="Enter Address.." class="form-control" />
		</div> --%>
		
<%-- 		<div class="form-group">
	<form:errors path="phone" cssClass="err" /><br>
	<label>Phone:</label>
	<br>
	<form:input path="phone" placeholder="Enter phone number.." class="form-control" />
		</div> --%>
		
		<button type="submit" class="btn btn-lg btn-info" >Submit</button>
		<button type="reset" class="btn btn-lg btn-info">Cancel</button>
		
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
	


</body>
</html>