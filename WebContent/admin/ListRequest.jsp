<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession,interfaces.UserInterface,interfaces.NoteInterface, java.util.LinkedList, java.util.Collection, java.util.*"%>
<%
	String pageName = "ListRequest.jsp";
	String pageFolder = "admin";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("user");
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}
	Collection<?> Requests = (Collection<?>) request.getSession().getAttribute("requests");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Richieste</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
				
		<link rel="stylesheet" href="../css/icomoon.css">
		<link rel="stylesheet" href="../css/simple-line-icons.css">
		<link rel="stylesheet" href="../css/style.css">
		<link rel="stylesheet" href="../css/toastr.min.css">
		
		<script src="../js/jquery-3.4.1.min.js"></script>
		<script src="../js/main.js"></script>
		<script src="../js/jquery.magnific-popup.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		
		<script src="../js/pages/scripts_searchRequest.js"></script>
		<script src="../js/pages/scripts_showRequest.js"></script>
		<script src="../js/pages/scripts.js"></script>
		<script src="../js/toastr.min.js"></script>
	</head>
	<body>

	<jsp:include page="../partials/navbar.jsp"/>
	
	<div id="fh5co-page">
		<div id="fh5co-wrap">
			<div id="fh5co-main">
					<div class="wrapper">
						<h1>RICHIESTE</h1>
							<div class="form">
								<div class="top-form">
									<div class="inner-form">
										<div class="label">Cerca per autore</div>
										<input type="text" id="autor" type="text" required>										
									</div>
									<button type="submit" id="search" class="btn">Cerca</button>
								</div>
							</div>
					<div style="width: 920px; height:600px; overflow-y: scroll;">
						<table id="table" class="table table-bordered table-striped table-hover">
							<tbody>
							<%
							if(Requests != null && Requests.size() > 0) {
								int index = 0;
								String sex = "";
								Iterator<?> it = Requests.iterator();
								while(it.hasNext()){
									NoteInterface bean = (NoteInterface) it.next();
								%>
							    	<tr>
							    		<td hidden><%=index %></td>
							      		<td><b>Professore: </b><%=bean.getProfessor()%><br><b>Corso: </b><%=bean.getCourse() %><br><b>Autore: </b><%=bean.getAutor() %><br></td>
							    	</tr>
						    	<%
									index++;
								}
							} else {
								%>
							 	 <tr>
									<td colspan="3"><div style="text-align: center;">AL MOMENTO NON CI SONO RICHIESTE</div></td>
								 </tr>
								<%
							}
								%>
						  </tbody>
						</table>
					</div>
					</div>
				<!-- TABELLA -->


			</div>


	</div>

	<!-- FOOTER -->
	<jsp:include page="../partials/footer.jsp"/>




	</body>
</html>