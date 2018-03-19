<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${library.name}</title>
		
		<jsp:include page="imports.jsp" />
		
	</head>
	
	<body>
		<div class="container">
		
			<jsp:include page="header.jsp" />
		
			<div>
				<h2>Créer une bibliothèque</h2>
				
				<form action="/tp5/library/create" method="POST">
					<input type="text" name="libName" placeholer="Nom">
					<input type="submit" placeholer="Créer">
				</form>
				
				<a href="/tp5">Accueil</a>
			</div>
			
		</div>
	</body>
	
</html>