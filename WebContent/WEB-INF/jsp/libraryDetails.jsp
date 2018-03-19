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
	
			<div><small>Details de la bibliothèque</small></div>
			<h2><b>${library.name}</b></h2>
			
			<div class="panel panel-default">
 
  				<div class="panel-heading">Liste des élèments</div>
  				
				<table class="table">
					<tr>	
						<th>id</th>
						<th>Nom du fichier</th>
					</tr>
					<c:forEach items="${library.items}" var="item">
					    <tr>
					        <td>${item.id}</td>
					        <td>${item.filename}</td>
					    </tr>
					</c:forEach>
				</table>
			</div>
					
		</div>
	</body>
	
</html>