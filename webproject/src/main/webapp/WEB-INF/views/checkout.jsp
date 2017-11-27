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
<title>Checkout Page</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>


	<br>

	<div class="container">
		<div class="row">
			<div class="col-xs-6 jumbotron">
				<div class="head">

					<h2>
						<p class="myText">Customer Details</p>
					</h2>

				</div>

				<div class="outer">
					<div class="well" style="width: 100%">

						<form action="${pageContext.request.contextPath}/invoiceprocess"
							method="POST">

							<c:set var="gtot" value="0"></c:set>
							<c:forEach var="c" items="${Cart }">

								<c:set var="gtot"
									value="${gtot + c.cartPrice * c.cartQuantity }">
								</c:set>
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



							<div class="well">
								<label><b>Payment Options</b></label> <select name="payment">
									<option value="COD">Cash On Delivery</option>
									<option value="NetBanking">Cash On Delivery</option>
									<option value="COD">Cash On Delivery</option>
								</select>
							</div>
							<br>

							<div>
								<br>
							</div>
							<input type="text" name="cardnum"
								placeholder="Enter debit/credit card number" style:"width:75%"><br>
							<input type="text" name="username"
								placeholder="Enter name on Card" style:"width:75%"><br> 
							<div>
								<table>
									<tr>
										<th colspan="2">Expiry</th>
										<th>&nbsp;&nbsp;</th>
										<th>CVV</th>
										<input type="number" name="cvv">
										<th>Month and Date</th>
										<input type="number" min="4" max="4" name="year"
											placeholder="YY">
										<input type="number" min="1" max="12" name="month"
											placeholder="MM">
										<input type="number" min="1" max="31" name="date"
											placeholder="DD">

									</tr>
								</table>
								<input type="submit" value="Get Invoice"
									class="btn btn-success btn-info">

							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>