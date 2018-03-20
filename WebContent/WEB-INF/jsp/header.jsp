<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-light bg-light justify-content-between" style="margin-bottom: 30px">
  <a class="navbar-brand" href="${pageContext.request.contextPath}">
    <img src="/tp5/img/icon.svg" width="30" height="30" class="d-inline-block align-top" alt="">
    Gestionnaire de bibliothèques
  </a>
  
  <c:if test="${empty sessionScope.user}">
	  <span>
	  	<a class="nav-link d-inline-block" href="${pageContext.request.contextPath}/login">Se connecter</a>/
	  	<a class="nav-link d-inline-block" href="${pageContext.request.contextPath}/signup">S'inscrire</a>
	  </span>
  </c:if>
  <c:if test="${!empty sessionScope.user}">
  	<div class="dropdown show">
  		<a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    		${sessionScope.user.username}
  		</a>

  		<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    		<a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Se déconnecter</a>       
  		</div>
	</div>
  </c:if>
  
</nav>

