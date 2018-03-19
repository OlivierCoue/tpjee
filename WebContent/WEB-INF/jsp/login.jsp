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
			
			<div class="col-md-4 col-md-offset-4">
				<c:if test="${loginFailed == true}">
					<div class="alert alert-danger" role="alert">Nom d'utilisateur ou mot de passe incorrecte</div>
				</c:if>
				<form action="/tp5/login" method="POST" >

  					<div class="form-group input-group">
    					<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    					<input class="form-control" type="text" name='username' placeholder="email"/>          
  					</div>
  
  					<div class="form-group input-group">
    					<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    					<input class="form-control" type="password" name='password' placeholder="mot de passe"/>     
  					</div>
  
  					<div class="form-group">
    					<input type="submit" class="btn btn-def btn-block" value="Se connecter" />
  					</div>
  
				</form>        
			</div>  
  				
		</div>
	</body>
	
</html>