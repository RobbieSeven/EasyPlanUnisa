<%@page import="model.CurriculumBeanDao"%>
<%@page import="model.CurriculumBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.ArrayList" pageEncoding="UTF-8"%>

<%
	synchronized (session)
	{
		if(session.getAttribute("amministratore") == null && session.getAttribute("password") == null )
		{
			RequestDispatcher view = request.getRequestDispatcher("Login.html");
			view.forward(request, response);
	
		}
	}	
	// Simulazione dati presi dal database
	String laurea = request.getParameter("laurea");
	String offerta = request.getParameter("offerta");
	String idCorsoDiLaurea = request.getParameter("idCorsoDiLaurea");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EasyPlan | Aggiungi Curricula</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- for social icon -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<!-- -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Validation script -->
<script>
	function notify(msg) {
		document.getElementById("error").innerHTML = msg;
	}

	function validate() {
		var name = document.form1.nomeCurricula;
		var format = /^[a-zA-z0-9 ]+$/;
		if (name.value.match(format))
			return true;
		else {
			notify("Il nome non può essere vuoto");
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
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<!-- "Login amministratore" -->
					<li><a href="Logout" style="color: #000000">Log
							out <span class="glyphicon glyphicon-log-out"></span>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<form action="SelezionaCurriculaAm.jsp">
		<input type="hidden" name="laurea" value="<%=request.getParameter("laurea")%>"> 
		<input type="hidden" name="offerta"value="<%=request.getParameter("offerta")%>"> 
		
		<input type="submit" class="btn btn-default" name="indietro"value="Indietro">
	</form>

	<div class="col-md-12">
		<div class="container">
			
				<h2 align=center>Aggiungi curricula</h2>
			
			<form class="form-horizontal" action="GestioneCurricula" method="POST" name="form1" onsubmit="return validate()">
				<input type="hidden" name="metodo" value="aggiuntaCurricula">
				<input type="hidden" name="laurea" value="<%=laurea%>"> 
				<input type="hidden" name="offerta" value="<%=offerta%>">
				<input type="hidden" name="idCorsoDiLaurea" value="<%=idCorsoDiLaurea %>"/>
				<div class="form-group">
					<label class="control-label col-sm-5" for="email">Nome
						curricula:</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" id="nomeCurricula" placeholder="Inserisci nome Curricula" name="nomeCurricula">
					</div>
					<p id="error" class="text-danger"></p>
				</div>				
				<div class="col-sm-offset-5 col-sm-10">
					<br> <br>

					<button type="submit" class="btn btn-default">Aggiungi
						curricula</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>