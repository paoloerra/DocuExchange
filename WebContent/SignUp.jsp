<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Index</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		
		<link rel="stylesheet" href="css/icomoon.css">
		<link rel="stylesheet" href="css/simple-line-icons.css">
		<link rel="stylesheet" href="css/style.css">
		
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.magnific-popup.min.js"></script>
		<script src="js/main.js"></script>
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

			<!-- REGISTRATI-->

				<div class=" w3l-login-form">
			          <form action="ClienteInsertCliente" method="POST">
			              <div class=" w3l-form-group">
			                  <label>Nome:</label>
			                  <div class="group">
			                      <input name="nome" type="text" class="form-control" placeholder="Nome" required="required" />
			                  </div>
			              </div>

			              <div class=" w3l-form-group">
			                  <label>Cognome:</label>
			                  <div class="group">
			                      <input name="cognome" type="text" class="form-control" placeholder="Cognome" required="required" />
			                  </div>
			              </div>

			               <div class=" w3l-form-group">
			                  <label>Email:</label>
			                  <div class="group">
			                      <input name="email" type="text" class="form-control" placeholder="p.erra1@studenti.unisa.it" required="required" />
			                  </div>
			              </div>
			              
			              <div class=" w3l-form-group">
			                  <label>Sesso:</label>
			                  <div class="group">
			                  	<select class="form-control">
									<option value="volvo">Maschio</option>
									<option value="saab">Femmina</option>
								</select>
			                  </div>
			              </div>

			              <div class=" w3l-form-group">
			                  <label>Password:</label>
			                  <div class="group">
			                      <input name="password" type="password" class="form-control" placeholder="Password" required="required" />
			              	</div>
			              </div>
			              <button type="submit">Registrati</button>
			              <p class=" w3l-register-p">Hai un account?<a href="Login.jsp" class="register"> Effettua il login</a></p>
			          </form>
			      </div>

				<!-- /REGISTRATI -->







		</div>


	</div>

	<!-- FOOTER -->
	<%@include file="footer.html" %>




	</body>
</html>