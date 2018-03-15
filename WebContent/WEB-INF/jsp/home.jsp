<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gestionnaire de bibliothèques</title>
	</head>
	
	<style>
		table, th, td {
    		border: 1px solid black;
		}
	</style>
	
	<body>
		<header>
			<h1>Gestionnaire de bibliothèques</h1>
		<header>
		
		<table style="width: 500px">
			<caption>Liste des bibliothèques</caption>
			<tr>
				<th>Nom</th>
				<th>Nombre d'éléments</th>
			</tr>
			<c:forEach items="${libraries}" var="library">
			    <tr>
			        <td>${library.name}</td>
			        <td>0</td>
			    </tr>
			</c:forEach>
		</table>
	</body>
</html>