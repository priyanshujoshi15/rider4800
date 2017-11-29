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

<br>
<div class="container">
<c:url value="/productUpdate" var="pru"></c:url>
<form action="productUpdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="pid" value="${prod.pid }">
<label> Product Name</label>
<input type="text" name="pName" value="${prod.name }" required/>
<br>
<label> Product Price</label>
<input type="text" name="pPrice" value="${prod.price }" required/>
<br>
<label> Product Stock</label>
<input type="text" name="pStock" value="${prod.stock }" required/>
<br>
<label> Product Description</label>
<input type="text" name="pDescription" value="${prod.description }" required/>
<br>
<label> Product Category</label>
<select name="pCategory">
	<option value="0">----Select Category----</option>
	<c:forEach items="${catList }" var="cate">
	<option value="${cate.cid }">${cate.cname }</option>
	</c:forEach>
</select>
<br>

<label> Product Supplier</label>
<select name="pSupplier">
	<option value="0">----Select Supplier----</option>
	<c:forEach items="${satList }" var="sate">
	<option value="${sate.sid }">${sate.sname }</option>
	</c:forEach>
</select>
<br>

<td>Image</td><br>
<td><input type="file" name="file"/></td>
<button class="btn btn-lg btn-primary" type="submit">Update</button>
</form>
</div>
</body>
</html>