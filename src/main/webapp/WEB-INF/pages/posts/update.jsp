<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js">
	
</script>
</head>
<body>
	<div class="container py-5">
		<h3>Post Edit</h3>
		<c:url value="/posts/edit" var="updateDb"></c:url>
		<form:form method="POST" action="${updateDb}" modelAttribute="updateForm">
			<form:hidden path="id"/>
			<div class="form-group mb-3 col-5">
				<form:label path="description">Description</form:label>
				<form:input path="description" class="form-control" placeholder="Enter Description"/>
			</div>
			<div class="form-group mb-3 col-5">
				<form:label path="title">Title</form:label>
				<form:input path="title" class="form-control" placeholder="Enter title"/>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>