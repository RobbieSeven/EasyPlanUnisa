<%@page import="model.corso.di.laurea.CorsoDiLaureaBean"%>
<%@page import="model.corso.di.laurea.CorsoDiLaureaBeanDao"%>
<%@page import="model.offerta.formativa.OffertaFormativaBeanDao"%>
<%@page import="model.offerta.formativa.OffertaFormativaBean"%>
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
     ArrayList<OffertaFormativaBean> of = new ArrayList<>();
     OffertaFormativaBeanDao ofbd = new OffertaFormativaBeanDao();
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
<link rel="stylesheet" href="AdminStyle.css">
	
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
					<li><a href="Logout" style="color: #000000">Log
							out <span class="glyphicon glyphicon-log-out"></span>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="col-md-12">
		<form action="AggiungiOffertaFormativa.jsp" method="post">
			
				<div align=center class="centerButton">
					<button class="btn btn-default btn-responsive center dimButton">
						<span class="glyphicon glyphicon-plus"><br>Aggiungi</span>
					</button>
					
				</div>
		</form>
			<br>
			<%for(int i=0; i<of.size(); i++){ %>
			
				<div  align=center class="center-block Myfieldset">
					
					<form action="GestioneOffertaFormativa" style="display: inline" method="POST">
						<input type="hidden" name="metodo" value="eliminaOfferta" >
						<input type="hidden" name="nomeOfferta" value="<%=of.get(i).getAnnoOffertaFormativa()%>">
							<button style="margin-right: 20px">
								<span class="glyphicon glyphicon-trash"></span>
							</button>
					</form>

					<input type="hidden" name="offerta" value="<%=of.get(i).getAnnoOffertaFormativa()%>">
					<a href="SelezionaLaureaAm.jsp?offerta=<%=of.get(i).getAnnoOffertaFormativa()%>"  style="margin-right: 20px"> <%=of.get(i).getAnnoOffertaFormativa() %></a>
					
					<!-- Default switch -->
					
					<label class=switch>
						   <form action="GestioneOffertaFormativa" method = "post">
								<input type="hidden" name="metodo" value="visibilita">
								<input type="hidden" name="nomeOfferta" value="<%=of.get(i).getAnnoOffertaFormativa() %>">
								<% if(of.get(i).isVisibilita()) { %> 
									<input type="hidden" name="visibile" value="si"/>
										<label class="c">
	        								<input type="checkbox" class="form-check-input filled-in" onChange="this.form.submit()" checked >
	        								<span class="checkmark slider" style="margin-top: -13px"></span>
										</label>
								<% } else { %>
									<input type="hidden" name="visibile" value="no"/>
									<label class="c">
	        							<input type="checkbox" class="form-check-input filled-in" onChange="this.form.submit()">
	        							<span class="checkmark slider" style="margin-top: -13px"></span>
									</label>
								<% } %>
							</form>
					</label>	
					
				</div>
			
			<br>
			<%}%>

		
	</div>

</body>
</html>