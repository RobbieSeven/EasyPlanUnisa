<%@page import="model.OffertaFormativaBeanDAO"%>
<%@page import="model.OffertaFormativaBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.ArrayList" pageEncoding="UTF-8"%>

<%
     	// Simulazione dati presi dal database
     	ArrayList<OffertaFormativaBean> of = new ArrayList<OffertaFormativaBean>();
     	OffertaFormativaBeanDAO ofbd = new OffertaFormativaBeanDAO();
     	of = ofbd.doRetriveByAll();
     %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EasyPlan | Offerta formativa</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style>
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
					<li><a href="Login amministratore" style="color: #000000">Log
							out <span class="glyphicon glyphicon-log-out"></span>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="col-md-12">
		<form action="AggiungiOffertaFormativa.jsp" method="post">
			<center>
				<div>
					<button class="btn btn-default btn-responsive center">
						<span class="glyphicon glyphicon-plus"><br>Aggiungi
					</button>
					</span>
				</div>
			</center>
			<br>
			<%for(int i=0; i<of.size(); i++){ %>
			<center>
				<div class=center-block style="border: 2px solid black; width: 15%;">
					<button>
						<span class="glyphicon glyphicon-trash"></span>
					</button>
					<a href="#" id="offertaformativa##"><%=of.get(i).getAnnoOffertaFormativa() %></a>
					<!-- Default switch -->
					<label class="switch"> <input type="checkbox"> <span
						class="slider"></span>
					</label>
				</div>
			</center>
			<br>
			<%}%>

		</form>
	</div>

</body>
</html>