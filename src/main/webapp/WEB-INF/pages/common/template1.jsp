<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="result"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	  rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js">
</script>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header" ignore="true"></tiles:insertAttribute>
	</header>
	<main class="py-5">
		<div class="container">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
	</main>
	
	<footer class="bg-dark fixed-bottom">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</footer>
</body>
</html>