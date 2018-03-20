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
			
			<div class="d-flex justify-content-between">
      			<div>
         			<h2>${library.name}</h2>
      			</div>
      			<div>
         			<span>${library.itemsCount}</span> éléments
      			</div>
 			</div>
 			
 			<form class="form-inline" method="GET" id="searchForm">
	 			<div class="d-flex justify-content-between" style="width: 100%;">
	 				<div>
	 					Filtrer par type :
						<div class="btn-group btn-group-toggle" data-toggle="buttons">
							<label class="btn btn-secondary" onclick="$('#Item').prop('checked', true); $('#searchForm').submit();">
								<jsp:text><![CDATA[<input type="radio" name="type" value="Item" id="Item" autocomplete="off" ]]></jsp:text>
									<c:if test="${searchType=='Item'}"> checked </c:if> 
								<jsp:text><![CDATA[/>]]></jsp:text> Tous
							</label>
							<label class="${searchType == 'Film' ? 'btn btn-primary active focus' : 'btn btn-primary'}" onclick="$('#Film').prop('checked', true); $('#searchForm').submit();">
								<jsp:text><![CDATA[<input type="radio" name="type" value="Film" id="Film" autocomplete="off"]]></jsp:text>
									<c:if test="${searchType=='Film'}"> checked </c:if> 
								<jsp:text><![CDATA[/>]]></jsp:text> Film
							</label>
							<label class="${searchType == 'MusicFile' ? 'btn btn-success active focus' : 'btn btn-success'}" onclick="$('#MusicFile').prop('checked', true); $('#searchForm').submit();">
								<jsp:text><![CDATA[<input type="radio" name="type" value="MusicFile" id="MusicFile" autocomplete="off" ]]></jsp:text>
									<c:if test="${searchType=='MusicFile'}"> checked </c:if> 
								<jsp:text><![CDATA[/>]]></jsp:text> Fichier de musique
							</label>
							<label class="${searchType == 'MusicalVideo' ? 'btn btn-danger active focus' : 'btn btn-danger'}" onclick="$('#MusicalVideo').prop('checked', true); $('#searchForm').submit();">
								<jsp:text><![CDATA[<input type="radio" name="type" value="MusicalVideo" id="MusicalVideo" autocomplete="off"]]></jsp:text>
									 <c:if test="${searchType=='MusicalVideo'}"> checked </c:if> 
								<jsp:text><![CDATA[/>]]></jsp:text> Fichier vidéo musical
							</label>
						</div>
	 				</div>
	 				<div>
						<input type="hidden" name="id" value="${library.id}" />
	   				 	<label class="sr-only" for="searchInput">Rechercher</label>
	 					<input type="text" class="form-control mb-2 mr-sm-2" id="searchInput" name="q" value="${searchRq}" placeholder="Nom de fichier...">
	   					<button type="submit" class="btn btn-primary mb-2">Rechercher</button>
	 				</div>
	 			</div>
 			</form>
			
			<div class="list-group">
				<c:forEach items="${items}" var="item">
					<c:if test="${item.getClass().name == 'model.Film'}">
	  				<a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
	    				<div class="d-flex w-100 justify-content-between">
	      					<h5 class="mb-1">${item.title}</h5>
	      					<h4><span class="badge badge-primary">Film</span></h4>
	    				</div>
	    				<p class="mb-1"><small>réalisé par <b>${item.director}</b></small><br/>
	    				Nom du fichier : ${item.filename}</p>
	  				</a>
	  				</c:if>
	  				
	  				<c:if test="${item.getClass().name == 'model.MusicFile'}">
	  				<a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
	    				<div class="d-flex w-100 justify-content-between">
	      					<h5 class="mb-1">${item.name}</h5>
	      					<h4><span class="badge badge-success">Fichier de musique</span></h4>
	    				</div>
	    				<p class="mb-1"><small>composée par <b>${item.artist}</b></small><br/>
	    				<small>appartenant a l'album <b>${item.album}</b></small><br/>
	    				Nom du fichier : ${item.filename}</p>
	  				</a>
	  				</c:if>
	  				
	  				<c:if test="${item.getClass().name == 'model.MusicalVideo'}">
	  				<a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
	    				<div class="d-flex w-100 justify-content-between">
	      					<h5 class="mb-1">${item.musicFile.name}</h5>
	      					<h4><span class="badge badge-danger">Fichier vidéo musical</span></h4>
	    				</div>
	    				<p class="mb-1"><small>composée par <b>${item.musicFile.artist}</b></small><br/>
	    				<small>appartenant a l'album <b>${item.musicFile.album}</b></small><br/>
	    				Nom du fichier : ${item.filename}</p>
	  				</a>
	  				</c:if>
  				</c:forEach>
  			</div>
  			
  			<c:if test="${(!empty sessionScope.user) && (sessionScope.user.isAdmin)}">
				
			<div class="card" style="margin-top: 10px">
  				<div class="card-body">
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addFilmModal">
			  				Ajouter un film
						</button>
			
						<div class="modal fade" id="addFilmModal" tabindex="-1" role="dialog" aria-labelledby="addFilmModal" aria-hidden="true">
					  		<div class="modal-dialog" role="document">
					    		<div class="modal-content">
					      			<div class="modal-header">
					        			<h5 class="modal-title" id="exampleModalLabel">Ajouter un film</h5>
					        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          				<span aria-hidden="true">&times;</span>
					        			</button>
					      			</div>
					      			<form action="${pageContext.request.contextPath}/item" method="POST">
						      			<div class="modal-body">
						      				<div class="form-group">
				    							<label for="filmFileNameInput">Nom du fichier</label>
				    							<input type="text" class="form-control" id="filmFileNameInput" name="filename" placeholder="Nom du fichier" />
				  							</div>
						        			<div class="form-group">
				    							<label for="filmTitleInput">Titre du film</label>
				    							<input type="text" class="form-control" id="filmTitleInput" name="title" placeholder="Titre du film" />
				  							</div>
				  							<div class="form-group">
				    							<label for="filmDirectorInput">Réalisteur</label>
				    							<input type="text" class="form-control" id="filmDirectorInput" name="director" placeholder="Réalisteur" />
				  							</div>
				  							<input type="hidden" name="libraryId" value="${library.id}" />
				  							<input type="hidden" name="itemType" value="film" />
						      			</div>
						      			<div class="modal-footer">
						        			<button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
						        			<input type="submit" class="btn btn-primary" value="Ajouter" />
						      			</div>
					      			</form>
					    		</div>
					  		</div>
						</div>
						
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addMusicFile">
			  				Ajouter un fichier de musique
						</button>
						
						<div class="modal fade" id="addMusicFile" tabindex="-1" role="dialog" aria-labelledby="addMusicFile" aria-hidden="true">
					  		<div class="modal-dialog" role="document">
					    		<div class="modal-content">
					      			<div class="modal-header">
					        			<h5 class="modal-title" id="exampleModalLabel">Ajouter un fichier de musique</h5>
					        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          				<span aria-hidden="true">&times;</span>
					        			</button>
					      			</div>
					      			<form action="${pageContext.request.contextPath}/item" method="POST">
						      			<div class="modal-body">
						      				<div class="form-group">
				    							<label for="musicFileFileNameInput">Nom du fichier</label>
				    							<input type="text" class="form-control" id="musicFileFileNameInput" name="filename" placeholder="Nom du fichier" />
				  							</div>
						        			<div class="form-group">
				    							<label for="musicNameInput">Nom de la musique</label>
				    							<input type="text" class="form-control" id="musicNameInput" name="name" placeholder="Nom de la musique" />
				  							</div>
				  							<div class="form-group">
				    							<label for="musicFileArtistInput">Nom de l'artiste</label>
				    							<input type="text" class="form-control" id="musicFileArtistInput" name="artist" placeholder="Nom de l'artiste" />
				  							</div>
				  							<div class="form-group">
				    							<label for="musicFileAlbumInput">Nom de l'album</label>
				    							<input type="text" class="form-control" id="musicFileAlbumInput" name="album" placeholder="Nom de l'album" />
				  							</div>
				  							<input type="hidden" name="libraryId" value="${library.id}" />
				  							<input type="hidden" name="itemType" value="musicFile" />
						      			</div>
						      			<div class="modal-footer">
						        			<button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
						        			<input type="submit" class="btn btn-primary" value="Ajouter" />
						      			</div>
					      			</form>
					    		</div>
					  		</div>
						</div>
						
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addMusicVideo">
			  				Ajouter une vidéo musical
						</button>
						
						<div class="modal fade" id="addMusicVideo" tabindex="-1" role="dialog" aria-labelledby="addMusicVideo" aria-hidden="true">
					  		<div class="modal-dialog" role="document">
					    		<div class="modal-content">
					      			<div class="modal-header">
					        			<h5 class="modal-title" id="exampleModalLabel">Ajouter une vidéo musical</h5>
					        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          				<span aria-hidden="true">&times;</span>
					        			</button>
					      			</div>
					      			<form action="${pageContext.request.contextPath}/item" method="POST">
						      			<div class="modal-body">
						      				<div class="form-group">
				    							<label for="musicVideoFileNameInput">Nom du fichier</label>
				    							<input type="text" class="form-control" id="musicVideoFileNameInput" name="filename" placeholder="Nom du fichier" />
				  							</div>
				  							<div class="form-group">
											    <label for="musicFileSelect">Sélectionner un fichier musical</label>
												<select class="form-control" id="musicFileSelect" name="musicFileId">
													<c:forEach items="${library.items}" var="item">
														<c:if test="${item.getClass().name == 'model.MusicFile'}">
											  			<option value="${item.id}">${item.name}</option>
											  			</c:if>
											  		</c:forEach>
											    </select>
											</div>
				  							
				  							<input type="hidden" name="libraryId" value="${library.id}" />
				  							<input type="hidden" name="itemType" value="musicalVideo" />
						      			</div>
						      			<div class="modal-footer">
						        			<button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
						        			<input type="submit" class="btn btn-primary" value="Ajouter" />
						      			</div>
					      			</form>
					    		</div>
					  		</div>
						</div>
					</div>
				</div>
			
			</c:if>
			
		</div>
	</body>
	
</html>