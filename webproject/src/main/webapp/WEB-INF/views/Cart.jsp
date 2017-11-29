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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<h4>
			<img alt="" src="${pageContext.request.contextPath }/images/cart.jpeg"> &nbsp;Add to Cart
		</h4>
		<table id="cart" class="table-hover table-condensed">

			<thead>
				<tr>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Image</th>
					<th>Total</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:if test="${empty cartInfo }">
					<tr>
						<td colspan="9" align="center">No Cart Item Exists</td>
					</tr>
				</c:if>
				<c:forEach var="c" varStatus="st" items="${cartInfo }">
					<tr>
						<td><c:out value="${c.cartProductName }"></c:out></td>
						<td><c:out value="${c.cartQuantity }"></c:out></td>
						<td><c:out value="${c.cartPrice }"></c:out></td>
						<td><img
							src="${pageContext.request.contextPath}/resources/<c:out value='${x.cartImage}'></c:out>"
							height="50px" width="50px" /></td>
						<td><c:out value="${c.cartQuantity * c.cartPrice}"></c:out></td>
						<td><c:out value="${c.cartProductName }"></c:out></td>
						<td><a
							href="${pageContext.request.ContextPath }/deletePCart/${c.cartId }"
							class="btn btn-danger btn-sm">Delete</a></td>
					</tr>
					<c:set var="gtot" value="${gtot + c.cartPrice * c.cartQuantity}"></c:set>
				</c:forEach>
				<tr>
					<td><span class="col-lg-9" align="right"><label>Grand
								Total</label>
						<c:out value="${gtot }"></c:out></span></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>

					<td><a href="${pageContext.request.ContextPath}/index"
						class="btn btn-warning">Continue Shopping</a></td>

					<td><a href="${pageContext.request.ContextPath}/checkout"
						class="btn btn-success">Checkout</a></td>
				</tr>
			</tfoot>
		</table>
		</div>
</body>
</html>