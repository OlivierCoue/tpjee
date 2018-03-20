<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gestionnaire de bibliothèques</title>
		
		<jsp:include page="imports.jsp" />
		
	</head>
	
	<body>
		<div class="container">
		
			<jsp:include page="header.jsp" />
			
			<div class="panel panel-default">
  
  				<h2 class="panel-heading">Liste des bibliothèques</h2>
			
				<table class="table">
					<tr>
						<th>Nom</th>
						<th>Nombre d'éléments</th>
						<th>Regarder</th>
					</tr>
					<c:forEach items="${libraries}" var="library">
					    <tr>
					        <td>${library.name}</td>
					        <td>${library.itemsCount}</td>
					        <td><a href="library?id=${library.id}" >Regarder</a></td>
					    </tr>
					</c:forEach>
				</table>
			</div>
			
			<c:if test="${(!empty sessionScope.user) && (sessionScope.user.isAdmin)}">
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/library/create">Ajouter une bibliothèque</a>
			</c:if>
		
		</div>
	</body>
</html>