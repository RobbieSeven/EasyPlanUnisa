<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int codiceGruppo = Integer.parseInt(request.getParameter("codiceGruppo"));
	String tipoGruppo = request.getParameter("tipoGruppo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EasyPlan | Aggiunta nuovo esame</title>
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
<style type="text/css">
.navbar-inverse {
	background-color: #ada2b2;
	border-color: #ada2b2;
}

.reset-this {
	all: initial;
}

.redo-fieldset {
	border: 1px solid black;
	padding: 10px;
}

.redo-legend {
	color: black;
}

input[type=button]:active {
	border-color: #ffffff;
}
</style>
<script>
	// funzione di aggiunta nuovo campi docenti da migliorare nel momento di aggiunta dao
	function add() {
		$("#prof1")
				.after(
						'<div class="row">'
								+ '<div class="col-sm-3 col-lg-3"> <h4>Nome docente classe 1:</h4></div>'
								+ '<div class="col-sm-3 col-lg-3"><input type="text" class="form-control" placeholder="Costantino Delizia" name="nomeProf">'
								+ '</div><div class="col-sm-3 col-lg-3">'
								+ '<input type="text" class="form-control" placeholder="Inserire url prof" name="urlProf" style="display:inline"></div>'
								+ '<div class="col-sm-3 col-lg-3"> <button type="button" name="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></button> </div></div>');
	}
</script>
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
					<li><a href="Login amministratore" style="color: #000000">Log
							out <span class="glyphicon glyphicon-log-out"></span>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<form action="GestioneEsamiServlet" method="POST">
		<input type="hidden" name="codiceGruppo" value="<%=codiceGruppo%>"></input>
		<input type="hidden" name="metodo" value="aggiuntaNuovoEsame" /> <input
			type="hidden" name="tipo" value="<%=tipoGruppo%>" />
		<div class="container">
			<center>
				<center>
					<h2>Aggiunta di un nuovo esame</h2>
				</center>
				<br>
				<br>
				<br>

				<div class="row">
					<div class="col-sm-3 col-lg-3">
						CFU <input type="number" min="1" max="12" class="btn btn-default"
							name="cfu" value="1">
					</div>
					<div class="col-sm-3 col-lg-3">
						Ore <input type="number" min="1" max="96" class="btn btn-default"
							name="ore" value="1">
					</div>
					<div class="col-sm-6 col-lg-6"></div>
				</div>
			</center>
			<div id="prof1" class="row">
				<br> <br>
				<div class="col-sm-3 col-lg-3">
					<h4>Nome esame:</h4>
				</div>
				<div class="col-sm-3 col-lg-3">
					<input type="text" class="form-control" placeholder="Nome Esame"
						name="nomeEsame">
				</div>
				<div class="col-sm-12 col-lg-12">
					<h4>
						<b>Docenti:</b>
					</h4>
				</div>
				<div class="col-sm-12 col-lg-12">
					<div class="col-sm-3 col-lg-3">
						<input type="text" class="form-control" placeholder="Classe"
							name="classeDocente">
					</div>
					<div class="col-sm-2 col-lg-2">
						<input type="text" class="form-control" placeholder="Nome"
							name="nomeDocente">
					</div>
					<div class="col-sm-2 col-lg-2">
						<input type="text" class="form-control" placeholder="Cognome"
							name="cognomeDocente">
					</div>
					<div class="col-sm-3 col-lg-3">
						<input type="text" class="form-control" placeholder="url"
							name="urlDocente" style="display: inline">
					</div>
					<div></div>
					<div class="col-sm-1 col-lg-1">
						<button type="button" name="button" onClick=add()
							class="btn btn-default">
							<span class="glyphicon glyphicon-plus"></span>
						</button>
					</div>
					<br>
					<div class="col-sm-12 col-lg-12">
						<div class="col-sm-3 col-lg-3">
							<h4>Descrizione:</h4>
						</div>
						<div class="col-sm-9 col-lg-9">
							<textarea name="descrizione" rows="5" cols="79"></textarea>
						</div>
					</div>
					<div class="col-sm-4 col-lg-4" style="margin-top: 2%"></div>
					<div class="col-sm-8 col-lg-8" style="margin-top: 2%">
						<input type="submit" class="btn btn-default" name="aggiungi"
							value="Aggiungi" style="margin-left: 15%; height: 45px">
					</div>

				</div>
	</form>
</body>
</html>