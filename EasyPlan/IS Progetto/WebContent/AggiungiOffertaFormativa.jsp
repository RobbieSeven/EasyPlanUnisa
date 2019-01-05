<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    synchronized (session)
	{
		if(session.getAttribute("amministratore") == null && session.getAttribute("password") == null )
		{
			RequestDispatcher view = request.getRequestDispatcher("Login.html");
			view.forward(request, response);
	
		}
	}
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EasyPlan | Rinomina offerta formativa</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- for social icon -->
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
		<!-- -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<!-- Validation script -->
		<script>
			function notify(msg) {
	  	  		document.getElementById("error").innerHTML = msg;
	  	 	}		
		
			function validate() {
		        var name = document.form1.nomeOfferta;
		        var format = /^\d{4}[/]\d{2}$/;
		        if(name.value.match(format))
		          	return true;
		        else {
					notify("Formato non corretto (AAAA/AA)");
		            name.focus();
		          	return false;
		        }
			}
		</script>
		<!-- ./Validation script -->
		<style type="text/css">
		.navbar-inverse {
		background-color: #ada2b2;
		border-color: #ada2b2;
		}
		</style>
	</head>
	
	<body>
	
		<nav class="navbar navbar-inverse ">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<!-- "Login amministratore" -->
					<li><a href="Logout" style="color:#000000">Log out <span class="glyphicon glyphicon-log-out"></span></a></li>
				</ul>
			</div>
			</div>
		</nav>
		
		<form action="GestioneOfferteFormative.jsp">
			<input type="submit" class="btn btn-default" name="indietro" value="Indietro">
		</form>
		
		<h2 align="center">Inserisci il nome della nuova offerta formativa</h2>
		
		<br><br>
		
		<form action="GestioneOffertaFormativa" method="post" name="form1" onsubmit="return validate()">
			<input type="hidden" name="metodo" value="aggiungiOfferta">
			<div class="container col-sm-12 col-lg-12">
				<div class=" col-sm-4 col-lg-4"></div>
				<div class="col-sm-4 col-lg-4 ">
					<input type="text" class="form-control" id="nomeOfferta" placeholder="AAAA/AA" name="nomeOfferta">
				</div>
				<br>
				<div class=" col-sm-4 col-lg-4"></div>
			</div>
			
			<div class="container col-sm-12 col-lg-12">
			<div class=" col-sm-4 col-lg-4"></div>
			<div class=" col-sm-4 col-lg-4">
					<p id="error" class="text-danger"></p>
				</div>
			</div>
			<div class=" col-sm-4 col-lg-4"></div>
			<br><br><br><br>
			
			<center>
				<input type="submit" class="btn btn-default" name="conferma" value="Conferma">
			</center>
		</form>
		
	</body>
</html>