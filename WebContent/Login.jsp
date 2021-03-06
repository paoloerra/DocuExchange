<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Student, java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Login</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		
		<link rel="stylesheet" href="css/icomoon.css">
		<link rel="stylesheet" href="css/simple-line-icons.css">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/toastr.min.css">
		
		<script src="js/jquery-3.4.1.min.js"></script>
		<script src="js/main.js"></script>
		<script src="js/jquery.magnific-popup.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	
		<script src="js/pages/scripts.js"></script>
		<script src="js/pages/scripts_login.js"></script>
		<script src="js/toastr.min.js"></script>
	</head>
	<body>
	<!-- NAVBAR -->
		<div id="fh5co-menu" class="navbar">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
                  		<a href="Index.jsp"><img src="images/DocuExchange_1.png" width="230" height="50" alt="simple logo"></a>
					</div>
				</div>
			</div>
		</div>
	<!-- END NAVBAR -->
		<div id="fh5co-page">
			<div id="fh5co-wrap">
				<div id="fh5co-main">
					<!-- LOGIN -->
						<div class=" w3l-login-form">
							<form id="Login">
								<div class=" w3l-form-group">
									<label>E-mail:</label>
										<div class="group">
											<input id="email" type="text" class="form-control" placeholder="E-mail" required="required" />
										</div>
								</div>
								<div class=" w3l-form-group">
									<label>Password:</label>
										<div class="group">
											<input id="password" type="password" class="form-control" placeholder="Password" required="required" />
										</div>
								</div>
								<button id="btn" type="submit">Login</button>
							</form>
							<p class=" w3l-register-p">Non ha in un account?<a href="student/SignUp.jsp" class="register"> Registrati</a></p>
						</div>
				<!-- END LOGIN-->
				</div>
			</div>
			<!-- FOOTER -->
		<jsp:include page="partials/footer.jsp"/>
	</body>
</html>