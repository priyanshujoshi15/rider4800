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
<title>Adding Page</title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">

		<div class="page-header"></div>
	</div>
	<br>

	<div class="container">
		<div class="row">

			<div class="col-md-9">
				<div class="panel with-nav-tabs panel primary"></div>
				<div class="panel-heading">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab1Prime" data-toogle="tab">Category</a>
						<li><a href="#tab2Prime" data-toogle="tab">Supplier</a>
						<li><a href="#tab3Prime" data-toogle="tab">Product</a>
					</ul>
				</div>

				<div class="panel-body">

					<div class="tab-content">
						<div class="tab-pane fade in active" id="#tab1Prime">
							<form action="<c:url value="/admin/saveCat"/>" method="POST">
								<span id="reauth-email" class="reuth-email"></span>
								<h4>
									<label>Category ID</label>
								</h4>
								<input class="form-control" type="number" name="cid" required />
								<h4>
									<label>Category Name</label>
								</h4>
								<input class="form-control" type="text" name="cname" required />
								<button class="btn btn-lg btn-primary" type="submit">OK</button>
								<button class="btn btn-lg btn-primary" type="reset">Cancel</button>
							</form>

							<div class="tab-pane fade in active" id="#tab2Prime">
								<form action="<c:url value="/admin/saveSupp"/>" method="POST">
									<span id="reauth-email" class="reuth-email"></span>
									<h4>
										<label>Supplier ID</label>
									</h4>
									<input class="form-control" type="number" name="sid" required />
									<h4>
										<label>Supplier Name</label>
									</h4>
									<input class="form-control" type="text" name="sname" required />
									<button class="btn btn-lg btn-primary" type="submit">OK</button>
									<button class="btn btn-lg btn-primary" type="reset">Cancel</button>
								</form>

								<div class="tab-pane fade in active" id="#tab3Prime">
									<form action="<c:url value="/admin/saveProd"/>" method="POST">
										<span id="reauth-email" class="reuth-email"></span>
										<h4>
											<label>Product Name</label>
										</h4>
										<input class="form-control" type="text" name="pname" required />
										<br>
										<h4>
											<label>Product Price</label>
										</h4>
										<input class="form-control" type="number" name="price"
											required /> <br>
										<h4>
											<label>Product Description</label>
										</h4>
										<input class="form-control" type="text" name="description"
											required /> <br>
										<h4>
											<label>Product Stock</label>
										</h4>
										<input class="form-control" type="number" name="stock"
											required /> <br>
										<div class="form-group">
											<td>Select Category</td>
											<td><select class="form-control" name="pCategory">
													<option value="">----Category----</option>
													<c:forEach items="${catList }" var="c">
														<option value="${c.cid }">${c.cname }</option>
													</c:forEach>
											</select>
										</div>
										<br>
										<div class="form-group">
											<td>Select Supplier</td>
											<td><select class="form-control" name="pCategory">
													<option value="">----Supplier----</option>
													<c:forEach items="${suppList }" var="c">
														<option value="${c.sid }">${c.sname }</option>
													</c:forEach>
											</select>
										</div>
										<br>
										<div class="fileinput fileinput-new" data-provides="fileinput">
										<h4><Label>Image</Label></h4>
										<input class="form-control" type="file" accept="image/*">	
										</div>
										<button class="btn btn-lg btn-primary" type="submit">OK</button>
										<button class="btn btn-lg btn-primary" type="reset">Cancel</button>
									</form>

								</div>

							</div>

						</div>

					</div>


				</div>
			</div>

		</div>
	</div>
</body>
</html>