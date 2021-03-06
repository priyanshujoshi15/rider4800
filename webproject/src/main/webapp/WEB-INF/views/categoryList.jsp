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
		<h2>Category List</h2>

		<table class="table table-hover" id="category" class="display"
			border="1">
			<tr>
				<th>Sr No.</th>
				<th>Category ID</th>
				<th>Name</th>
				<th class="span2">Action</th>
			</tr>
			<c:if test="${empty catList }">
				<tr>
					<td colspan="9" align="center">No Record Exists</td>
				</tr>
			</c:if>

			<c:forEach var="c" varStatus="st" items=${catList }">
				<tr>
					<td><c:out value="${st.count }"></c:out></td>
					<td><c:out value="${c.cid }"></c:out></td>
					<td><c:out value="${c.cname }"></c:out></td>
					<td class="span4"><c:set var="contextRoot"
							value="${pageContext.request.contextPath }"></c:set> <a
						class="btn btn-info" role="button" href="<c:url"></a> <a
						class="btn btn-info" role="button" href="${contextRoot }"></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>