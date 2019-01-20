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
		<style type="text/css">
		.navbar-inverse {
		background-color: #ada2b2;
		border-color: #ada2b2;
		}
		</style>
	</head>
	<body>
	
		<!--  Navbar -->
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
		<!--  ./Navbar -->
		
		
			<h2 align=center>Modifica il nome dell'offerta formativa</h2>
		
		
		<br><br>
		
		<div class="container col-sm-12 col-lg-12">
			<div class=" col-sm-4 col-lg-4"></div>
			<div class="col-sm-3 col-lg-4 ">
				<input type="text" class="form-control" id="nomeOffeta" placeholder="AAAA/AA" name="nomeCurricula">
			</div>
			<div class=" col-sm-5 col-lg-4"></div>
		</div>
		
		<br><br>
		<div align=center>
			<input type="submit" class="btn btn-default" name="conferma" value="Conferma">
		</div>
	</body>
</html>