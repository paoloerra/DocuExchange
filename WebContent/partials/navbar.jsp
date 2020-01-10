<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="interfaces.UserInterface"%>
    
<%
    UserInterface u = (UserInterface) session.getAttribute("user");
%>
<!DOCTYPE html>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/simple-line-icons.css">

<% if(u != null) { %>
	<% if(u.getUserType() == 0) { %>
	<div id="fh5co-offcanvass">
		<ul>
			<li class="active"><a href="<%= request.getContextPath() %>/student/HomeStudent.jsp" data-nav-section="home"><i class="icon-grid"></i> Home</a></li>
			<li><a href="#"><i class="icon-user"></i> Studente: <%=u.getName() %> <%=u.getSurname() %> </a></li>
			<li><a href="#"><i class="icon-download"></i> Download disponibili: <%=u.getLimitDownload()%></a></li>
			<li><a href="#" id="btnLogout"><i class="icon-logout"></i> Logout</a></li>
		</ul>
	</div>
	<%}%>
	<% if(u.getUserType() == 1) { %>
	<div id="fh5co-offcanvass">
		<ul>
			<li class="active"><a href="<%= request.getContextPath() %>HomeAdmin.jsp" data-nav-section="home"><i class="icon-grid"></i> Home</a></li>
			<li><a href="#"><i class="icon-user"></i> Admin: <%=u.getName() %> <%=u.getSurname() %> </a></li>
			<li><a href="#" id="btnLogout"><i class="icon-logout"></i> Logout</a></li>
		</ul>
	</div>
	<%}%>
<%}%>		
		

	<div id="fh5co-menu" class="navbar">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<% if(u != null) { %>
						<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#fh5co-navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
					<%}%>					
	                <img src="<%= request.getContextPath() %>/images/DocuExchange_1.png" width="230" height="50" alt="simple logo">
				</div>
			</div>
		</div>
	</div>

<script src="../js/pages/scripts_logout.js"></script>
		
