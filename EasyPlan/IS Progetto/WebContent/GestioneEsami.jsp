<%@page import="model.GruppoEsamiObbligatoriBeanDAO"%>
<%@page import="model.GruppoEsamiObbligatoriBean"%>
<%@page import="model.GruppoEsamiOpzionaliBeanDAO"%>
<%@page import="model.GruppoEsamiOpzionaliBean"%>
<%@page import="model.EsameBeanDAO"%>
<%@page import="model.EsameBean"%>
<%@page import="model.DocenteBeanDAO"%>
<%@page import="model.DocenteBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.ArrayList" pageEncoding="UTF-8"%>

<%
		String laurea=request.getParameter("laurea");
		int tipo;
		if(laurea.equals("triennale")){
			tipo=1;	
		}else {tipo=2;}
		
		String offerta= request.getParameter("offerta");
		String curriculum= request.getParameter("curriculum");
		int id= Integer.parseInt(request.getParameter("idCurriculum"));
		ArrayList<GruppoEsamiObbligatoriBean> grob1 = new ArrayList<GruppoEsamiObbligatoriBean>();
		ArrayList<GruppoEsamiObbligatoriBean> grob2 = new ArrayList<GruppoEsamiObbligatoriBean>();
		ArrayList<GruppoEsamiObbligatoriBean> grob3 = new ArrayList<GruppoEsamiObbligatoriBean>();
		ArrayList<GruppoEsamiOpzionaliBean> grop1 = new ArrayList<GruppoEsamiOpzionaliBean>();
		ArrayList<GruppoEsamiOpzionaliBean> grop2 = new ArrayList<GruppoEsamiOpzionaliBean>();
		ArrayList<GruppoEsamiOpzionaliBean> grop3 = new ArrayList<GruppoEsamiOpzionaliBean>();
		GruppoEsamiObbligatoriBeanDAO grupObDao = new GruppoEsamiObbligatoriBeanDAO();
		GruppoEsamiOpzionaliBeanDAO grupOpDao = new GruppoEsamiOpzionaliBeanDAO();
		EsameBeanDAO esameB = new EsameBeanDAO();
		DocenteBeanDAO docentiB = new DocenteBeanDAO();
		
		//GRUPPI ESAMI OBB E OPP PRIMO ANNO
		grob1.addAll(grupObDao.doRetriveGruppoEsamiObbByOffertaAndAnno(offerta, tipo, curriculum, 1));
		for(int i =0; i < grob1.size(); i++)
			grob1.get(i).setEsami(esameB.doRetriveEsamiOffertaFormativaObb(offerta, tipo, curriculum, grob1.get(i).getCodiceGEOb()));
		for(int  j = 0; j < grob1.size(); j++) {
			for(int d = 0; d < grob1.get(j).getEsami().size(); d++)
				grob1.get(j).getEsami().get(d).setDocenti(docentiB.doRetrieveDocEsameObb(offerta, tipo, curriculum, grob1.get(j).getCodiceGEOb(), grob1.get(j).getEsami().get(d).getNome()));
		}
		//gruppo opzionali
		grop1.addAll(grupOpDao.doRetriveGruppoEsamiOpzByOffertaAndAnno(offerta, tipo, curriculum, 1));
		for(int i=0; i<grop1.size(); i++)
			grop1.get(i).setEsami(esameB.doRetriveEsamiOffertaFormativaOpz(offerta, tipo, curriculum, grop1.get(i).getCodiceGEOp()));
		for(int z=0; z<grop1.size(); z++) {
			for(int d1 = 0; d1<grop1.get(z).getEsami().size(); d1++)
				grop1.get(z).getEsami().get(d1).setDocenti(docentiB.doRetrieveDocEsameOpz(offerta, tipo, curriculum, grop1.get(z).getCodiceGEOp(), grop1.get(z).getEsami().get(d1).getNome()));
		}
		
		//GRUPPI ESAMI OBB E OPP SECONDO ANNO
		grob2.addAll(grupObDao.doRetriveGruppoEsamiObbByOffertaAndAnno(offerta, tipo, curriculum, 2));
		for(int i =0; i < grob2.size(); i++)
			grob2.get(i).setEsami(esameB.doRetriveEsamiOffertaFormativaObb(offerta, tipo, curriculum, grob2.get(i).getCodiceGEOb()));
		for(int  j = 0; j < grob2.size(); j++) {
			for(int d = 0; d < grob2.get(j).getEsami().size(); d++)
				grob2.get(j).getEsami().get(d).setDocenti(docentiB.doRetrieveDocEsameObb(offerta, tipo, curriculum, grob2.get(j).getCodiceGEOb(), grob2.get(j).getEsami().get(d).getNome()));
		}
		//gruppo opzionali
		grop2.addAll(grupOpDao.doRetriveGruppoEsamiOpzByOffertaAndAnno(offerta, tipo, curriculum, 2));
		for(int i =0; i < grop2.size(); i++)
			grop2.get(i).setEsami(esameB.doRetriveEsamiOffertaFormativaOpz(offerta, tipo, curriculum, grop2.get(i).getCodiceGEOp()));
		for(int  z = 0; z < grop2.size(); z++) {
			for(int d1 = 0; d1 < grop2.get(z).getEsami().size(); d1++)
				grop2.get(z).getEsami().get(d1).setDocenti(docentiB.doRetrieveDocEsameOpz(offerta, tipo, curriculum, grop2.get(z).getCodiceGEOp(), grop2.get(z).getEsami().get(d1).getNome()));
		}
		
		//GRUPPI ESAMI OBB E OPP TERZO ANNO (LAUREA TRIENNALE ONLY)
		if(tipo == 1){
			grob3.addAll(grupObDao.doRetriveGruppoEsamiObbByOffertaAndAnno(offerta, tipo, curriculum, 3));
			for(int i =0; i < grob3.size(); i++)
				grob3.get(i).setEsami(esameB.doRetriveEsamiOffertaFormativaObb(offerta, tipo, curriculum, grob3.get(i).getCodiceGEOb()));
			for(int  j = 0; j < grob3.size(); j++) {
				for(int d = 0; d < grob3.get(j).getEsami().size(); d++)
					grob3.get(j).getEsami().get(d).setDocenti(docentiB.doRetrieveDocEsameObb(offerta, tipo, curriculum, grob3.get(j).getCodiceGEOb(), grob3.get(j).getEsami().get(d).getNome()));
			}
			//gruppo opzionali
			grop3.addAll(grupOpDao.doRetriveGruppoEsamiOpzByOffertaAndAnno(offerta, tipo, curriculum, 3));
			for(int i =0; i < grop3.size(); i++){
				grop3.get(i).setEsami(esameB.doRetriveEsamiOffertaFormativaOpz(offerta, tipo, curriculum, grop3.get(i).getCodiceGEOp()));
			}
			for(int  z = 0; z < grop3.size(); z++) {
				for(int d1 = 0; d1 < grop3.get(z).getEsami().size(); d1++)
					grop3.get(z).getEsami().get(d1).setDocenti(docentiB.doRetrieveDocEsameOpz(offerta, tipo, curriculum, grop3.get(z).getCodiceGEOp(), grop3.get(z).getEsami().get(d1).getNome()));
			}
		}
     %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>EasyPlan | Gestione gruppi esami</title>
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
		  	function add()
		  	{
		  		$("#prof1").after('<div class="row">'+
		                '<div class="col-sm-3 col-lg-3"> <h4>Nome docente classe 1:</h4></div>'+
		                '<div class="col-sm-3 col-lg-3"><input type="text" class="form-control" placeholder="Costantino Delizia" name="nomeProf">'+
		                '</div><div class="col-sm-3 col-lg-3">'+
		                '<input type="text" class="form-control" placeholder="Inserire url prof" name="urlProf" style="display:inline"></div>'+
		                '<div class="col-sm-3 col-lg-3"> <button type="button" name="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></button> </div></div>');
		  	}
		  
		  </script>
	</head>

	<body>
		<div class="panel panel-default">
			<nav class="navbar navbar-inverse ">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#myNavbar">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse" id="myNavbar">
						<ul class="nav navbar-nav navbar-right">
							<!-- "Login amministratore" -->
							<li><a href="Login amministratore" style="color: #000000">Log out <span class="glyphicon glyphicon-log-out"></span>
							</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<form action="SelezionaCurriculaAm.jsp" method = "post">
	       		<input type="hidden" name="laurea" value="<%=request.getParameter("laurea")%>">
	       		<input type="hidden" name="offerta" value="<%=request.getParameter("offerta")%>">
	        	<button name="button" id="laureaScelta" class="btn btn-default btn-responsive left-block">Indietro</button>
	        </form>
			<center>
				<h1>
					Curriculum
					<%=request.getParameter("curriculum") %>
					anno:
					<%=request.getParameter("offerta") %></h1>
	
				<% if(tipo == 1){ // Triennale
	    	  for(int i = 1; i <= 3; i++){
	    		%>
				<fieldset class="reset-this redo-fieldset"
					style="margin-left: 10px; width: 95%">
					<legend class="reset-this redo-legend">Anno <%= i %></legend>
	
					<% if(i == 1){ // Primo anno
						ArrayList<EsameBean> esami1 = new ArrayList<EsameBean>();
	        	for(int j = 0; j<grob1.size(); j++){ 	
	        		esami1.addAll(grob1.get(j).getEsami());
	        %>
					<fieldset class="reset-this redo-fieldset" style="margin-left: 10px; width: 97%">
						<legend class="reset-this redo-legend">Gruppo obbligatorio <%=grob1.get(j).getCodiceGEOb() %></legend>
						
						<!--  Esame -->
						<% for(int k=0; k<esami1.size(); k++) {  
							EsameBean esame = esami1.get(k);
							ArrayList<DocenteBean> docenti = esame.getDocenti(); %>			
						
						<form action ="GestioneEsamiServlet" method = "POST">
						<fieldset class="reset-this redo-fieldset" style="margin-left: -11px; width: 100%">
							<input type="button" value="<%= esame.getNome() %>" data-toggle="collapse" data-target="#<%= esame.getCodiceEsame() %>" style="border: 0px; background: #ffffff;">
						</fieldset>
						<div class="contents">
							<div id="<%= esame.getCodiceEsame() %>" class="collapse">
								<div class="container">
									<center>
										<div class="row">
											<div class="col-sm-3 col-lg-3">
												CFU <input type="number" min="1" max="12" class="btn btn-default" name="insertCFU" value="<%= esame.getCFU() %>">
											</div>
											<div class="col-sm-3 col-lg-3">
												Ore <input type="number" min="1" max="96" class="btn btn-default" name="insertOre" value="<%= esame.getOreLezione() %>">
											</div>
											<div class="col-sm-6 col-lg-6">
												Anno
												<select class="form-control selcls" name="Scelta anno" style="width: 40%; display: inline">
													<%for(int b = 0; b < grob1.size(); b++){
													if(b == j){%>
													<option value="<%=grob1.get(b).getCodiceGEOb() %>" selected>Gruppo obbiligatorio <%=grob1.get(b).getCodiceGEOb()%></option>
													<%}else {%>
													<option value="<%=grob1.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob1.get(b).getCodiceGEOb()%></option>
													<%}} for(int b = 0; b < grob2.size(); b++){
													%>
													<option value="<%=grob2.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob2.get(b).getCodiceGEOb()%></option>
													<%}
														for(int b = 0;b < grob3.size(); b++){
														%>
													<option value="<%=grob3.get(b).getCodiceGEOb() %>">Gruppo obbligatorio <%=grob3.get(b).getCodiceGEOb()%> </option>
													<%}
														for(int b = 0;b < grop1.size(); b++){
														%>
													<option value="<%=grop1.get(b).getCodiceGEOp() %>">Gruppo <%=grop1.get(b).getTotCFU() %> CFU a scelta </option>
													<%}
														for(int b = 0;b < grop2.size(); b++){
														%>
													<option value="<%=grop2.get(b).getCodiceGEOp() %>">Gruppo <%=grop2.get(b).getTotCFU() %> CFU a scelta </option>
													<%}
														for(int b = 0;b < grop3.size(); b++){
														%>
													<option value="<%=grop3.get(b).getCodiceGEOp() %>">Gruppo <%=grop3.get(b).getTotCFU() %> CFU a scelta </option>
													<%} %>													
												</select>
											</div>
										</div>
									</center>
									<div id="prof1" class="row">
										<br> <br>
										<div class="col-sm-12 col-lg-12">
											<h4>Docenti:</h4>
										</div>
										
										<% for(int l=0; l<docenti.size(); l++) {  
											DocenteBean docente = docenti.get(l); %>
										<div class="col-sm-12 col-lg-12">
											<div class="col-sm-3 col-lg-3">
												<h4><%= docente.getInsegnamento() %>:</h4>
											</div>
											<div class="col-sm-3 col-lg-3">
												<input type="text" class="form-control" value="<%= docente.getNome() %> <%= docente.getCognome() %>" name="nomeProf">
											</div>
											<div class="col-sm-3 col-lg-3">
												<input type="text" class="form-control" value="<%= docente.getIndirizzoPaginaWeb() %>" name="urlProf" style="display: inline">
											</div>
											<div class="col-sm-3 col-lg-3">
												<button type="button" name="button" onClick=add() class="btn btn-default">
													<span class="glyphicon glyphicon-plus"></span>
												</button>
											</div>
										</div>
										<% } %>
									</div>
									<div class="col-sm-3 col-lg-3">
										<h4>Descrizione:</h4>
									</div>
									<div class="col-sm-9 col-lg-9">
										<textarea name="descrizione" rows="5" cols="79"><%= esame.getDescrizione() %></textarea>										
									</div>
									
									<div class="col-sm-4 col-lg-4" style="margin-top: 2%">
										<center>
										
													<div>
														<button type="submit" class="btn btn-default btn-responsive center" name="metodo" value="cancellaEsame">
															<span class="glyphicon glyphicon-trash"><br>Cancella esame </span>
														</button>												
													</div>
											
										</center>										
									</div>
									
										<div class="col-sm-8 col-lg-8" style="margin-top: 2%">
										
											<button class="btn btn-default" style="margin-left: 15%; height: 45px" type="submit" name="metodo" value="updateEsame">
											Applica
											</button>
										</div>
								</div>
							</div>
						</div>
						</form>	
						<% } %>
						
						<center>
							<div>
								<form action = "GestioneGruppoEsamiObbligatori" method = "POST">
									<input type="hidden" name="codiceGruppo" value="<%=grob1.get(j).getCodiceGEOb() %>"></input>
									<button type="submit" class="btn btn-default btn-responsive center" name="metodo" value="deleteGruppo">
										<span class="glyphicon glyphicon-trash"><br>Cancella gruppo </span>
									</button>
									</form>
									<form action = "AggiuntaNuovoEsame.jsp" method = "POST">
										<input type="hidden" name="codiceGruppo" value="<%=grob1.get(j).getCodiceGEOb() %>"></input>
										<input type="hidden" name="laurea" value="<%=laurea%>"></input>
										<input type="hidden" name="offerta" value="<%=offerta%>"></input>
										<input type="hidden" name="curriculum" value="<%=curriculum%>"></input>
										<input type="hidden" name="idCurriculum" value="<%=id%>"></input>
										<input type="hidden" name="tipoGruppo" value="obbligatorio"></input>									
										<button type="submit" class="btn btn-default btn-responsive center" name="metodo" value="aggiungiEsame">Aggiungi un nuovo esame
										</button>
									</form>
									<form action = "AggiuntaEsameEsistente.jsp" method = "POST">
										<input type="hidden" name="codiceGruppo" value="<%=grob1.get(j).getCodiceGEOb() %>"></input>
										<button type="submit" class="btn btn-default btn-responsive center" name="metodo" value="aggiungiEsameEsistente">Aggiungi esame esistente
										</button>
									</form>
								
							</div>
						</center>
						
					</fieldset>
					<% } 
	        	esami1.clear();
	    	for (int j = 0; j < grop1.size(); j++) { 
	    		esami1.addAll(grop1.get(j).getEsami());
	    		%>
					<fieldset class="reset-this redo-fieldset"
						style="margin-left: 10px; width: 97%">
						<legend class="reset-this redo-legend"><%=grop1.get(j).getTotCFU() %> a scelta tra: </legend>
						
						<!--  Esame -->
						<% for(int k=0; k<esami1.size(); k++) {  
							EsameBean esame = esami1.get(k);
							ArrayList<DocenteBean> docenti = esame.getDocenti(); %>
						<form action="GestioneGruppoEsamiOpzionali" method = "post">
						<%System.out.println("Ciaoooo") ;%>
						<fieldset class="reset-this redo-fieldset"
							style="margin-left: -11px; width: 100%">
							<input type="button" value="<%= esame.getNome() %>" data-toggle="collapse"
								data-target="#<%= esame.getCodiceEsame() %>" style="border: 0px; background: #ffffff;">
						</fieldset>
						<div class="contents">
							<div id="<%= esame.getCodiceEsame() %>" class="collapse">
								<div class="container">
									<center>
										<div class="row">
											<div class="col-sm-3 col-lg-3">
												CFU <input type="number" min="1" max="12"
													class="btn btn-default" name="insertCFU" value="<%= esame.getCFU() %>">
											</div>
											<div class="col-sm-3 col-lg-3">
												Ore <input type="number" min="1" max="96"
													class="btn btn-default" name="insertOre" value="<%= esame.getOreLezione() %>">
											</div>
											<div class="col-sm-6 col-lg-6">
												Anno 
													<select class="form-control selcls" name="Scelta anno" style="width: 40%; display: inline">
														<%for(int b = 0; b < grob1.size(); b++){
														%>
														<option value="<%=grob1.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob1.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0; b < grob2.size(); b++){
														%>
														<option value="<%=grob2.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob2.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0;b < grob3.size(); b++){
															%>
														<option value="<%=grob3.get(b).getCodiceGEOb() %>">Gruppo obbligatorio <%=grob3.get(b).getCodiceGEOb()%> </option>
														<%}
															for(int b = 0;b < grop1.size(); b++){
															if(b == j){%>
															<option value="<%=grop1.get(b).getCodiceGEOp() %>" selected>Gruppo <%=grop1.get(b).getTotCFU() %> CFU a scelta </option>
															<%}else {%>
															<option value="<%=grop1.get(b).getCodiceGEOp() %>">Gruppo <%=grop1.get(b).getTotCFU() %> CFU a scelta </option>
															<%}} for(int b = 0; b < grop2.size(); b++){
															%>
														<option value="<%=grop2.get(b).getCodiceGEOp() %>">Gruppo <%=grop2.get(b).getTotCFU() %> CFU a scelta </option>
														<%}
															for(int b = 0;b < grop3.size(); b++){
															%>
														<option value="<%=grop3.get(b).getCodiceGEOp() %>">Gruppo <%=grop3.get(b).getTotCFU() %> CFU a scelta </option>
														<%} %>													
													</select>
											</div>
										</div>
									</center>
									<div id="prof1" class="row">
										<br> <br>
										<div class="col-sm-12 col-lg-12">
											<h4>Docenti:</h4>
										</div>
										
										<% for(int l=0; l<docenti.size(); l++) {  
											DocenteBean docente = docenti.get(l); %>
										<div class="col-sm-12 col-lg-12">
											<div class="col-sm-3 col-lg-3">
												<h4><%= docente.getInsegnamento() %>:</h4>
											</div>
											<div class="col-sm-3 col-lg-3">
												<input type="text" class="form-control" value="<%= docente.getNome() %> <%= docente.getCognome() %>" name="nomeProf">
											</div>
											<div class="col-sm-3 col-lg-3">
												<input type="text" class="form-control" value="<%= docente.getIndirizzoPaginaWeb() %>" name="urlProf" style="display: inline">
											</div>
											<div class="col-sm-3 col-lg-3">
												<button type="button" name="button" onClick=add() class="btn btn-default">
													<span class="glyphicon glyphicon-plus"></span>
												</button>
											</div>
										</div>
										<% } %>
									</div>
									<div class="col-sm-3 col-lg-3">
										<h4>Descrizione:</h4>
									</div>
									<div class="col-sm-9 col-lg-9">
										<textarea name="descrizione" rows="5" cols="79"><%= esame.getDescrizione() %></textarea>
									</div>
									
									<div class="col-sm-4 col-lg-4" style="margin-top: 2%">
										<center>
											
												<div>
													<button type="submit" class="btn btn-default btn-responsive center" name="metodo" value="cancellaEsame">
														<span class="glyphicon glyphicon-trash"><br>Cancella esame </span>
													</button>												
												</div>										
											
										</center>
									</div>
									
										<div class="col-sm-8 col-lg-8" style="margin-top: 2%">
										
											<button class="btn btn-default" style="margin-left: 15%; height: 45px" type="submit" name="metodo" value="updateEsame">
											Applica
											</button>
											</div>
								</div>
							</div>
						</div>
						</form>	
						<% } %>
						
						<center>
							<div>
									
							 <form action="GestioneGruppoEsamiOpzionali" method="POST"> 
									<input type="hidden" name="codiceGruppo" value="<%=grop1.get(j).getCodiceGEOp() %>"></input>
									<button type="submit" class="btn btn-default btn-responsive center" name="metodo" value="deleteGruppo">
										<span class="glyphicon glyphicon-trash"><br>Cancella gruppo </span>
									</button>		
							</form>	
							<form action = "AggiuntaNuovoEsame.jsp" method = "POST">
								<input type="hidden" name="codiceGruppo" value="<%=grop1.get(j).getCodiceGEOp() %>"></input>		
									<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsame">Aggiungi un nuovo esame
									</button>
							</form>
							<form action = "AggiuntaEsameEsistente.jsp" method = "POST">
								<input type="hidden" name="codiceGruppo" value="<%=grop1.get(j).getCodiceGEOp() %>"></input>
									<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsameEsistente">Aggiungi esame esistente
									</button>
							</form>
							<form action = "ModificaGruppoEsame.jsp" method = "POST">
								<input type="hidden" name="codiceGruppo" value="<%=grop1.get(j).getCodiceGEOp() %>"></input>
									<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="updateGruppo">
										<span class="glyphicon glyphicon-pencil"></span><br>Modifica gruppo
									</button>
							</form>
							</div>
						</center>
					</fieldset>
					<%} %>
					<center>
						<div>
						 <form action="AggiuntaGruppoEsami.jsp" method="POST"> 
						 <input type="hidden" name="offerta" value="<%=offerta %>"></input>
						 <input type="hidden" name="laurea" value="<%=laurea %>"></input>
						 <input type="hidden" name="idCurriculum" value="<%=id %>"></input>
						 <input type="hidden" name="anno" value="1"></input>
							<button class="btn btn-default btn-responsive center" type="submit" metodo" value="aggiungiGruppo"> Aggiungi nuovo gruppo d'esami
							</button>
							</form>
						</div>
					</center>
					<% }
	
			 else if(i == 2){ // Secondo anno
				 ArrayList<EsameBean> esami2 = new ArrayList<EsameBean>();
		        	for(int j = 0; j<grob2.size(); j++){ 	
		        		esami2.addAll(grob2.get(j).getEsami());
		        %>
						<fieldset class="reset-this redo-fieldset"
							style="margin-left: 10px; width: 97%">
							<legend class="reset-this redo-legend">Gruppo obbligatorio <%=grob2.get(j).getCodiceGEOb() %></legend>
							
							<!--  Esame -->
							<% for(int k=0; k<esami2.size(); k++) {  
								EsameBean esame = esami2.get(k);
								ArrayList<DocenteBean> docenti = esame.getDocenti(); %>
							<form action="GestioneGruppoEsamiObbligatori" method = "post">
							<fieldset class="reset-this redo-fieldset"
								style="margin-left: -11px; width: 100%">
								<input type="button" value="<%= esame.getNome() %>" data-toggle="collapse"
									data-target="#<%= esame.getCodiceEsame() %>" style="border: 0px; background: #ffffff;">
							</fieldset>
							<div class="contents">
								<div id="<%= esame.getCodiceEsame() %>" class="collapse">
									<div class="container">
										<center>
											<div class="row">
												<div class="col-sm-3 col-lg-3">
													CFU <input type="number" min="1" max="12"
														class="btn btn-default" name="insertCFU" value="<%= esame.getCFU() %>">
												</div>
												<div class="col-sm-3 col-lg-3">
													Ore <input type="number" min="1" max="96"
														class="btn btn-default" name="insertOre" value="<%= esame.getOreLezione() %>">
												</div>
												<div class="col-sm-6 col-lg-6">
													Anno 
													<select class="form-control selcls" name="Scelta anno" style="width: 40%; display: inline">
														<%for(int b = 0; b < grob1.size(); b++){
														%>
														<option value="<%=grob1.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob1.get(b).getCodiceGEOb()%></option>
														<%}
														for(int b = 0;b < grob2.size(); b++){
															if(b == j){%>
															<option value="<%=grob2.get(b).getCodiceGEOb() %>" selected>Gruppo obbiligatorio <%=grob2.get(b).getCodiceGEOb()%></option>
															<%}else {%>
															<option value="<%=grob2.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob2.get(b).getCodiceGEOb()%></option>
															<%}} 
															for(int b = 0; b < grop3.size(); b++){
															%>
														<option value="<%=grob3.get(b).getCodiceGEOb() %>">Gruppo obbligatorio <%=grob3.get(b).getCodiceGEOb()%> </option>
														<%}
															for(int b = 0;b < grop1.size(); b++){
															%>
														<option value="<%=grop1.get(b).getCodiceGEOp() %>">Gruppo <%=grop1.get(b).getTotCFU() %> CFU a scelta </option>
														<%}
															for(int b = 0;b < grop2.size(); b++){
															%>
														<option value="<%=grop2.get(b).getCodiceGEOp() %>">Gruppo <%=grop2.get(b).getTotCFU() %> CFU a scelta </option>
														<%}
															for(int b = 0;b < grop3.size(); b++){
															%>
														<option value="<%=grop3.get(b).getCodiceGEOp() %>">Gruppo <%=grop3.get(b).getTotCFU() %> CFU a scelta </option>
														<%} %>													
													</select>
												</div>
											</div>
										</center>
										<div id="prof1" class="row">
											<br> <br>
											<div class="col-sm-12 col-lg-12">
												<h4>Docenti:</h4>
											</div>
											
											<% for(int l=0; l<docenti.size(); l++) {  
												DocenteBean docente = docenti.get(l); %>
											<div class="col-sm-12 col-lg-12">
												<div class="col-sm-3 col-lg-3">
													<h4><%= docente.getInsegnamento() %>:</h4>
												</div>
												<div class="col-sm-3 col-lg-3">
													<input type="text" class="form-control" value="<%= docente.getNome() %> <%= docente.getCognome() %>" name="nomeProf">
												</div>
												<div class="col-sm-3 col-lg-3">
													<input type="text" class="form-control" value="<%= docente.getIndirizzoPaginaWeb() %>" name="urlProf" style="display: inline">
												</div>
												<div class="col-sm-3 col-lg-3">
													<button type="button" name="button" onClick=add() class="btn btn-default">
														<span class="glyphicon glyphicon-plus"></span>
													</button>
												</div>
											</div>
											<% } %>
										</div>
										<div class="col-sm-3 col-lg-3">
											<h4>Descrizione:</h4>
										</div>
										<div class="col-sm-9 col-lg-9">
											<textarea name="descrizione" rows="5" cols="79"><%= esame.getDescrizione() %></textarea>
										</div>
										
										<div class="col-sm-4 col-lg-4" style="margin-top: 2%">
											<center>
													<div>
														<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="cancellaEsame">
															<span class="glyphicon glyphicon-trash"><br>Cancella esame </span>
														</button>												
													</div>	
											</center>
										</div>
										
											<div class="col-sm-8 col-lg-8" style="margin-top: 2%">
												
											<button class="btn btn-default btn-responsive center" name="metodo" value="updateEsame" type="submit">
												Applica
											</button>
												</div>
								</div>
							</div>
						</div>
						</form>	
						<% } %>
							
							<center>
								<div>
									<form action = "GestioneGruppoEsamiObbligatori" method = "POST">
										<input type="hidden" name="codiceGruppo" value="<%=grob2.get(j).getCodiceGEOb() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="deleteGruppo">
											<span class="glyphicon glyphicon-trash"><br>Cancella gruppo </span>
										</button>
									</form>
									<form action = "AggiuntaNuovoEsame.jsp" method = "POST">
										<input type="hidden" name="codiceGruppo" value="<%=grob2.get(j).getCodiceGEOb() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsame">Aggiungi un nuovo esame
										</button>
									</form>
									<form action = "AggiuntaEsameEsistente.jsp" method = "POST">
										<input type="hidden" name="codiceGruppo" value="<%=grob2.get(j).getCodiceGEOb() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsameEsistente">Aggiungi esame esistente
										</button>
									</form>
								</div>
							</center>
						</fieldset>
						<% } 
		        	esami2.clear();
		    	for (int j = 0; j < grop2.size(); j++) { 
		    		esami2.addAll(grop2.get(j).getEsami());
		    		%>
						<fieldset class="reset-this redo-fieldset"
							style="margin-left: 10px; width: 97%">
							<legend class="reset-this redo-legend"><%=grop2.get(j).getTotCFU() %>a scelta tra: </legend>
							
							<!--  Esame -->
							<% for(int k=0; k<esami2.size(); k++) {  
								EsameBean esame = esami2.get(k);
								ArrayList<DocenteBean> docenti = esame.getDocenti(); %>
							<form action="SelezionaCurriculaAm.jsp" method = "post">
							<fieldset class="reset-this redo-fieldset"
								style="margin-left: -11px; width: 100%">
								<input type="button" value="<%= esame.getNome() %>" data-toggle="collapse"
									data-target="#<%= esame.getCodiceEsame() %>" style="border: 0px; background: #ffffff;">
							</fieldset>
							<div class="contents">
								<div id="<%= esame.getCodiceEsame() %>" class="collapse">
									<div class="container">
										<center>
											<div class="row">
												<div class="col-sm-3 col-lg-3">
													CFU <input type="number" min="1" max="12"
														class="btn btn-default" name="insertCFU" value="<%= esame.getCFU() %>">
												</div>
												<div class="col-sm-3 col-lg-3">
													Ore <input type="number" min="1" max="96"
														class="btn btn-default" name="insertOre" value="<%= esame.getOreLezione() %>">
												</div>
												<div class="col-sm-6 col-lg-6">
													Anno 
													<select class="form-control selcls" name="Scelta anno" style="width: 40%; display: inline">
														<%for(int b = 0; b < grob1.size(); b++){
														%>
														<option value="<%=grob1.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob1.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0; b < grob2.size(); b++){
														%>
														<option value="<%=grob2.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob2.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0;b < grob3.size(); b++){
															%>
														<option value="<%=grob3.get(b).getCodiceGEOb() %>">Gruppo obbligatorio <%=grob3.get(b).getCodiceGEOb()%> </option>
														<%}
															for(int b = 0;b < grop1.size(); b++){
															%>
														<option value="<%=grop1.get(b).getCodiceGEOp() %>">Gruppo <%=grop1.get(b).getTotCFU() %> CFU a scelta </option>
														<%}
															for(int b = 0;b < grop2.size(); b++){
															if(b == j){%>
															<option value="<%=grop2.get(b).getCodiceGEOp() %>" selected>Gruppo <%=grop2.get(b).getTotCFU() %> CFU a scelta </option>
															<%}else {%>
															<option value="<%=grop2.get(b).getCodiceGEOp() %>">Gruppo <%=grop2.get(b).getTotCFU() %> CFU a scelta </option>
															<%}} 
															for(int b = 0; b < grop3.size(); b++){
															%>
														<option value="<%=grop3.get(b).getCodiceGEOp() %>">Gruppo <%=grop3.get(b).getTotCFU() %> CFU a scelta </option>
														<%} %>													
													</select>
												</div>
											</div>
										</center>
										<div id="prof1" class="row">
											<br> <br>
											<div class="col-sm-12 col-lg-12">
												<h4>Docenti:</h4>
											</div>
											
											<% for(int l=0; l<docenti.size(); l++) {  
												DocenteBean docente = docenti.get(l); %>
											<div class="col-sm-12 col-lg-12">
												<div class="col-sm-3 col-lg-3">
													<h4><%= docente.getInsegnamento() %>:</h4>
												</div>
												<div class="col-sm-3 col-lg-3">
													<input type="text" class="form-control" value="<%= docente.getNome() %> <%= docente.getCognome() %>" name="nomeProf">
												</div>
												<div class="col-sm-3 col-lg-3">
													<input type="text" class="form-control" value="<%= docente.getIndirizzoPaginaWeb() %>" name="urlProf" style="display: inline">
												</div>
												<div class="col-sm-3 col-lg-3">
													<button type="button" name="button" onClick=add() class="btn btn-default">
														<span class="glyphicon glyphicon-plus"></span>
													</button>
												</div>
											</div>
											<% } %>
										</div>
										<div class="col-sm-3 col-lg-3">
											<h4>Descrizione:</h4>
										</div>
										<div class="col-sm-9 col-lg-9">
											<textarea name="descrizione" rows="5" cols="79"><%= esame.getDescrizione() %></textarea>
										</div>
										
										<div class="col-sm-4 col-lg-4" style="margin-top: 2%">
											<center>
													<div>
														<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="cancellaEsame">
															<span class="glyphicon glyphicon-trash"><br>Cancella esame </span>
														</button>												
													</div>
												
											</center>
										</div>
										
											<div class="col-sm-8 col-lg-8" style="margin-top: 2%">
												
												<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="updateEsame">
													Applica
												</button>
										</div>
								</div>
							</div>
						</div>
						</form>	
						<% } %>
							
							<center>
								<div>
									<form action="GestioneGruppoEsamiOpzionali" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop2.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="deleteGruppo">
											<span class="glyphicon glyphicon-trash"><br>Cancella gruppo </span>
										</button>	
									</form>
									<form action="AggiuntaNuovoEsame.jsp" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop2.get(j).getCodiceGEOp() %>"></input>				
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsame">Aggiungi un nuovo esame
										</button>
									</form>
									<form action="AggiuntaEsameEsistente.jsp" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop2.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsameEsistente">Aggiungi esame esistente
										</button>
									</form>
									<form action="ModificaGruppoEsame.jsp" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop2.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit"  name="metodo" value="updateGruppo">
											<span class="glyphicon glyphicon-pencil"><br>Modifica gruppo </span>
										</button>
									</form>
									
								</div>
							</center>
						</fieldset>
						<%} %>
						<center>
						<div>
						 <form action="AggiuntaGruppoEsami.jsp" method="POST"> 
						 <input type="hidden" name="offerta" value="<%=offerta %>"></input>
						 <input type="hidden" name="laurea" value="<%=laurea %>"></input>
						 <input type="hidden" name="idCurriculum" value="<%=id %>"></input>
						 <input type="hidden" name="anno" value="2"></input>
							<button class="btn btn-default btn-responsive center">Aggiungi nuovo gruppo d'esami</button>
							</form>
						</div>
					</center>
						<% }
	    	
	    	else if(i == 3){ // Terzo anno
	    		ArrayList<EsameBean> esami3 = new ArrayList<EsameBean>();
	        	for(int j = 0; j<grob3.size(); j++){ 	
	        		esami3.addAll(grob3.get(j).getEsami());
	        %>
					<fieldset class="reset-this redo-fieldset" style="margin-left: 10px; width: 97%">
						<legend class="reset-this redo-legend">Gruppo obbligatorio <%=grob3.get(j).getCodiceGEOb() %></legend>
						
						<!--  Esame -->
						<% for(int k=0; k<esami3.size(); k++) {  
							EsameBean esame = esami3.get(k);
							ArrayList<DocenteBean> docenti = esame.getDocenti(); %>
						<form action="SelezionaCurriculaAm.jsp" method = "post">
						<fieldset class="reset-this redo-fieldset"
							style="margin-left: -11px; width: 100%">
							<input type="button" value="<%= esame.getNome() %>" data-toggle="collapse"
								data-target="#<%= esame.getCodiceEsame() %>" style="border: 0px; background: #ffffff;">
						</fieldset>
						<div class="contents">
							<div id="<%= esame.getCodiceEsame() %>" class="collapse">
								<div class="container">
									<center>
										<div class="row">
											<div class="col-sm-3 col-lg-3">
												CFU <input type="number" min="1" max="12"
													class="btn btn-default" name="insertCFU" value="<%= esame.getCFU() %>">
											</div>
											<div class="col-sm-3 col-lg-3">
												Ore <input type="number" min="1" max="96"
													class="btn btn-default" name="insertOre" value="<%= esame.getOreLezione() %>">
											</div>
											<div class="col-sm-6 col-lg-6">
												Anno
												<select class="form-control selcls" name="Scelta anno" style="width: 40%; display: inline">
														<%for(int b = 0; b < grob1.size(); b++){
														%>
														<option value="<%=grob1.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob1.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0; b < grob2.size(); b++){
														%>
														<option value="<%=grob2.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob2.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0;b < grob3.size(); b++){
															if(b == j){%>
															<option value="<%=grob3.get(b).getCodiceGEOb() %>" selected>Gruppo obbligatorio <%=grob3.get(b).getCodiceGEOb()%> </option>
															<%}else {%>
															<option value="<%=grob3.get(b).getCodiceGEOb() %>">Gruppo obbligatorio <%=grob3.get(b).getCodiceGEOb()%> </option>
															<%}} 
															for(int b = 0; b < grop1.size(); b++){
															%>
														<option value="<%=grop1.get(b).getCodiceGEOp() %>">Gruppo <%=grop1.get(b).getTotCFU() %> CFU a scelta </option>
														<%}
															for(int b = 0;b < grop2.size(); b++){
															%>
														<option value="<%=grop2.get(b).getCodiceGEOp() %>">Gruppo <%=grop2.get(b).getTotCFU() %> CFU a scelta </option>
														<%}
															for(int b = 0;b < grop3.size(); b++){
															%>
														<option value="<%=grop3.get(b).getCodiceGEOp() %>">Gruppo <%=grop3.get(b).getTotCFU() %> CFU a scelta </option>
														<%} %>													
												</select>
											</div>
										</div>
									</center>
									<div id="prof1" class="row">
										<br> <br>
										<div class="col-sm-12 col-lg-12">
											<h4>Docenti:</h4>
										</div>
										
										<% for(int l=0; l<docenti.size(); l++) {  
											DocenteBean docente = docenti.get(l); %>
										<div class="col-sm-12 col-lg-12">
											<div class="col-sm-3 col-lg-3">
												<h4><%= docente.getInsegnamento() %>:</h4>
											</div>
											<div class="col-sm-3 col-lg-3">
												<input type="text" class="form-control" value="<%= docente.getNome() %> <%= docente.getCognome() %>" name="nomeProf">
											</div>
											<div class="col-sm-3 col-lg-3">
												<input type="text" class="form-control" value="<%= docente.getIndirizzoPaginaWeb() %>" name="urlProf" style="display: inline">
											</div>
											<div class="col-sm-3 col-lg-3">
												<button type="button" name="button" onClick=add() class="btn btn-default">
													<span class="glyphicon glyphicon-plus"></span>
												</button>
											</div>
										</div>
										<% } %>
									</div>
									<div class="col-sm-3 col-lg-3">
										<h4>Descrizione:</h4>
									</div>
									<div class="col-sm-9 col-lg-9">
										<textarea name="descrizione" rows="5" cols="79"><%= esame.getDescrizione() %></textarea>
									</div>
									
									<div class="col-sm-4 col-lg-4" style="margin-top: 2%">
										<center>
												<div>
													<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="cancellaEsame">
														<span class="glyphicon glyphicon-trash"><br>Cancella esame </span>
													</button>												
												</div>
										</center>
									</div>
											<div class="col-sm-8 col-lg-8" style="margin-top: 2%">
												<button class="btn btn-default btn-responsive center" name="metodo" value="updateEsame">
													Applica
												</button>
												</div>
								</div>
							</div>
						</div>
						</form>	
						<% } %>
						
						<center>
							<div>
								<form action = "GestioneGruppoEsamiObbligatori" method = "POST">
									<input type="hidden" name="codiceGruppo" value="<%=grob3.get(j).getCodiceGEOb() %>"></input>
									<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="deleteGruppo" >
										<span class="glyphicon glyphicon-trash"><br>Cancella gruppo </span>
									</button>
								</form>
								<form action = "AggiuntaNuovoEsame.jsp" method = "POST">
									<input type="hidden" name="codiceGruppo" value="<%=grob3.get(j).getCodiceGEOb() %>"></input>
									<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsame">Aggiungi un nuovo esame
									</button>
								</form>
								<form action = "AggiuntaEsameEsistente" method = "POST">
									<input type="hidden" name="codiceGruppo" value="<%=grob3.get(j).getCodiceGEOb() %>"></input>
									<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsameEsistente">Aggiungi esame esistente
									</button>
								</form>
								
							</div>
						</center>
					</fieldset>
					<% } 
	        	esami3.clear();
	    	for (int j=0; j<grop3.size(); j++) { 
	    		esami3.addAll(grop3.get(j).getEsami());
	    		%>
					<fieldset class="reset-this redo-fieldset" style="margin-left: 10px; width: 97%">
						<legend class="reset-this redo-legend"><%=grop3.get(j).getTotCFU() %> a scelta tra:
						</legend>
						<!--  Esame -->
						<% for(int k=0; k<esami3.size(); k++) {  
							EsameBean esame = esami3.get(k);
							ArrayList<DocenteBean> docenti = esame.getDocenti(); %>
						<form action="SelezionaCurriculaAm.jsp" method = "post">
						<fieldset class="reset-this redo-fieldset"
							style="margin-left: -11px; width: 100%">
							<input type="button" value="<%= esame.getNome() %>" data-toggle="collapse"
								data-target="#<%= esame.getCodiceEsame() %>" style="border: 0px; background: #ffffff;">
						</fieldset>
						<div class="contents">
							<div id="<%= esame.getCodiceEsame() %>" class="collapse">
								<div class="container">
									<center>
										<div class="row">
											<div class="col-sm-3 col-lg-3">
												CFU <input type="number" min="1" max="12"
													class="btn btn-default" name="insertCFU" value="<%= esame.getCFU() %>">
											</div>
											<div class="col-sm-3 col-lg-3">
												Ore <input type="number" min="1" max="96"
													class="btn btn-default" name="insertOre" value="<%= esame.getOreLezione() %>">
											</div>
											<div class="col-sm-6 col-lg-6">
												Anno
												<select class="form-control selcls" name="Scelta anno" style="width: 40%; display: inline">
														<%for(int b = 0; b < grob1.size(); b++){
														%>
														<option value="<%=grob1.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob1.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0; b < grob2.size(); b++){
														%>
														<option value="<%=grob2.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob2.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0;b < grob3.size(); b++){
															%>
														<option value="<%=grob3.get(b).getCodiceGEOb() %>">Gruppo obbligatorio <%=grob3.get(b).getCodiceGEOb()%> </option>
														<%}
															for(int b = 0;b < grop1.size(); b++){
															%>
														<option value="<%=grop1.get(b).getCodiceGEOp() %>">Gruppo <%=grop1.get(b).getTotCFU() %> CFU a scelta </option>
														<%}
															for(int b = 0;b < grop2.size(); b++){
															%>
														<option value="<%=grop2.get(b).getCodiceGEOp() %>">Gruppo <%=grop2.get(b).getTotCFU() %> CFU a scelta </option>
														<%}
															for(int b = 0;b < grop3.size(); b++){
																if(b == j){%>
																<option value="<%=grop3.get(b).getCodiceGEOp() %>" selected>Gruppo <%=grop3.get(b).getTotCFU() %> CFU a scelta</option>
																<%}else {%>
																<option value="<%=grop3.get(b).getCodiceGEOp() %>">Gruppo <%=grop3.get(b).getTotCFU() %> CFU a scelta </option>
															<%}}%>													
												</select>
											</div>
										</div>
									</center>
									<div id="prof1" class="row">
										<br> <br>
										<div class="col-sm-12 col-lg-12">
											<h4>Docenti:</h4>
										</div>
										
										<% for(int l=0; l<docenti.size(); l++) {  
											DocenteBean docente = docenti.get(l); %>
										<div class="col-sm-12 col-lg-12">
											<div class="col-sm-3 col-lg-3">
												<h4><%= docente.getInsegnamento() %>:</h4>
											</div>
											<div class="col-sm-3 col-lg-3">
												<input type="text" class="form-control" value="<%= docente.getNome() %> <%= docente.getCognome() %>" name="nomeProf">
											</div>
											<div class="col-sm-3 col-lg-3">
												<input type="text" class="form-control" value="<%= docente.getIndirizzoPaginaWeb() %>" name="urlProf" style="display: inline">
											</div>
											<div class="col-sm-3 col-lg-3">
												<button type="button" name="button" onClick=add() class="btn btn-default">
													<span class="glyphicon glyphicon-plus"></span>
												</button>
											</div>
										</div>
										<% } %>
									</div>
									<div class="col-sm-3 col-lg-3">
										<h4>Descrizione:</h4>
									</div>
									<div class="col-sm-9 col-lg-9">
										<textarea name="descrizione" rows="5" cols="79"><%= esame.getDescrizione() %></textarea>
									</div>
									
									<div class="col-sm-4 col-lg-4" style="margin-top: 2%">
										<center>
										
												<div>
													<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="cancellaEsame">
														<span class="glyphicon glyphicon-trash"><br>Cancella esame </span>
													</button>												
												</div>				
										</center>	
									</div>
					                            <div class="col-sm-8 col-lg-8" style="margin-top: 2%">
												<button class="btn btn-default btn-responsive center"  type="submit" name="metodo" value="updateEsame">
													Applica
												</button>
												</div>
								</div>
							</div>
						</div>
						</form>	
						<% } %>
						
						<center>
							<div>
								<form action="GestioneGruppoEsamiOpzionali" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop3.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="deleteGruppo">
											<span class="glyphicon glyphicon-trash"><br>Cancella gruppo </span>
										</button>	
								</form>	
								<form action="AggiuntaNuovoEsame.jsp" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop3.get(j).getCodiceGEOp() %>"></input>					
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsame">Aggiungi un nuovo esame</button>
								</form>
								<form action="AggiuntaEsameEsistente.jsp" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop3.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsameEsistente">Aggiungi esame esistente</button>
								</form>
								<form action="ModificaGruppoEsame.jsp" method="POST">	
										<input type="hidden" name="codiceGruppo" value="<%=grop3.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="updateGruppo">
											<span class="glyphicon glyphicon-pencil"><br>Modifica gruppo </span>
										</button>
								</form>
									
							</div>
						</center>
					</fieldset>
					<%} %>
						<center>
						<div>
						 <form action="AggiuntaGruppoEsami.jsp" method="POST"> 
						 <input type="hidden" name="offerta" value="<%=offerta %>"></input>
						 <input type="hidden" name="laurea" value="<%=laurea %>"></input>
						 <input type="hidden" name="idCurriculum" value="<%=id %>"></input>
						 <input type="hidden" name="anno" value="3"></input>
							<button class="btn btn-default btn-responsive center">Aggiungi nuovo gruppo d'esami</button>
							</form>
						</div>
					</center>
					<% } %>
	
				</fieldset>
	
				<% } // Chiusura for Anni %>
	
				<% } // Chiusura Triennale  
				// MAGISTRALE
	  else if (tipo == 2){
		  for(int i = 1; i <= 2; i++){
		    	%>
	
				<fieldset class="reset-this redo-fieldset"
					style="margin-left: 10px; width: 95%">
					<legend class="reset-this redo-legend">
						Anno
						<%= i %></legend>
	
					<% if(i == 1){ // Primo anno
						ArrayList<EsameBean> esami1 = new ArrayList<EsameBean>();
	        	for(int j = 0; j<grob1.size(); j++){ 	
	        		esami1.addAll(grob1.get(j).getEsami());
	        %>
					<fieldset class="reset-this redo-fieldset"
						style="margin-left: 10px; width: 97%">
						<legend class="reset-this redo-legend">Gruppo obbligatorio <%=grob1.get(j).getCodiceGEOb() %></legend>
						
						<!--  Esame -->
						<% for(int k=0; k<esami1.size(); k++) {  
							EsameBean esame = esami1.get(k);
							ArrayList<DocenteBean> docenti = esame.getDocenti(); %>
						<form action="GestioneEsamiServlet" method = "post">
						<fieldset class="reset-this redo-fieldset"
							style="margin-left: -11px; width: 100%">
							<input type="button" value="<%= esame.getNome() %>" data-toggle="collapse"
								data-target="#<%= esame.getCodiceEsame() %>" style="border: 0px; background: #ffffff;">
						</fieldset>
						<div class="contents">
							<div id="<%= esame.getCodiceEsame() %>" class="collapse">
								<div class="container">
									<center>
										<div class="row">
											<div class="col-sm-3 col-lg-3">
												CFU <input type="number" min="1" max="12"
													class="btn btn-default" name="insertCFU" value="<%= esame.getCFU() %>">
											</div>
											<div class="col-sm-3 col-lg-3">
												Ore <input type="number" min="1" max="96"
													class="btn btn-default" name="insertOre" value="<%= esame.getOreLezione() %>">
											</div>
											<div class="col-sm-6 col-lg-6">
												Anno
												<select class="form-control selcls" name="Scelta anno" style="width: 40%; display: inline">
														<%for(int b = 0;b < grob1.size(); b++){
															if(b == j){%>
																<option value="<%=grob1.get(b).getCodiceGEOb() %>" selected>Gruppo obbligatorio <%=grob1.get(b).getCodiceGEOb()%> </option>
																<%}else {%>
																<option value="<%=grob1.get(b).getCodiceGEOb() %>">Gruppo obbligatorio <%=grob1.get(b).getCodiceGEOb()%> </option>
																<%}} 
															for(int b = 0; b < grob2.size(); b++){
															%>
														<option value="<%=grob2.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob2.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0;b < grop1.size(); b++){
															%>
														<option value="<%=grop1.get(b).getCodiceGEOp() %>">Gruppo <%=grop1.get(b).getTotCFU() %> CFU a scelta </option>
														<%}
															for(int b = 0;b < grop2.size(); b++){
															%>
														<option value="<%=grop2.get(b).getCodiceGEOp() %>">Gruppo <%=grop2.get(b).getTotCFU() %> CFU a scelta </option>
														<%}%>													
												</select>
											</div>
										</div>
									</center>
									<div id="prof1" class="row">
										<br> <br>
										<div class="col-sm-12 col-lg-12">
											<h4>Docenti:</h4>
										</div>
										
										<% for(int l=0; l<docenti.size(); l++) {  
											DocenteBean docente = docenti.get(l); %>
										<div class="col-sm-12 col-lg-12">
											<div class="col-sm-3 col-lg-3">
												<h4><%= docente.getInsegnamento() %>:</h4>
											</div>
											<div class="col-sm-3 col-lg-3">
												<input type="text" class="form-control" value="<%= docente.getNome() %> <%= docente.getCognome() %>" name="nomeProf">
											</div>
											<div class="col-sm-3 col-lg-3">
												<input type="text" class="form-control" value="<%= docente.getIndirizzoPaginaWeb() %>" name="urlProf" style="display: inline">
											</div>
											<div class="col-sm-3 col-lg-3">
												<button type="button" name="button" onClick=add() class="btn btn-default">
													<span class="glyphicon glyphicon-plus"></span>
												</button>
											</div>
										</div>
										<% } %>
									</div>
									<div class="col-sm-3 col-lg-3">
										<h4>Descrizione:</h4>
									</div>
									<div class="col-sm-9 col-lg-9">
										<textarea name="descrizione" rows="5" cols="79"><%= esame.getDescrizione() %></textarea>
									</div>
									
									<div class="col-sm-4 col-lg-4" style="margin-top: 2%">
										<center>
											
												<div>
													<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="cancellaEsame">
														<span class="glyphicon glyphicon-trash"><br>Cancella esame </span>
													</button>												
												</div>
										</center>
									</div>
										<div class="col-sm-8 col-lg-8" style="margin-top: 2%">
												<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="updateEsame">
													Applica
												</button>
										</div>
								</div>
							</div>
						</div>
						</form>	
						<% } %>
						
						<center>
							<div>
								<form action = "GestioneGruppoEsamiObbligatori" method = "POST">
									<input type="hidden" name="codiceGruppo" value="<%=grob1.get(j).getCodiceGEOb() %>"></input>
									<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="deleteGruppo">
										<span class="glyphicon glyphicon-trash" ><br>Cancella gruppo </span>
									</button>
								</form>
								<form action = "AggiuntaNuovoEsame.jsp" method = "POST">
									<input type="hidden" name="codiceGruppo" value="<%=grob1.get(j).getCodiceGEOb() %>"></input>
									<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsame">Aggiungi un nuovo esame</button>
								</form>
								<form action = "AggiuntaEsameEsistente.jsp" method = "POST">
									<input type="hidden" name="codiceGruppo" value="<%=grob1.get(j).getCodiceGEOb() %>"></input>
									<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsameEsistente">Aggiungi esame esistente</button>
								</form>
							</div>
						</center>
					</fieldset>
					<% } 
	        	esami1.clear();
	    	for (int j = 0; j < grop1.size(); j++) { 
	    		esami1.addAll(grop1.get(j).getEsami());
	    		%>
					<fieldset class="reset-this redo-fieldset"
						style="margin-left: 10px; width: 97%">
						<legend class="reset-this redo-legend"><%=grop1.get(j).getTotCFU() %>a scelta tra:
						</legend>
						
						<!--  Esame -->
						<% for(int k=0; k<esami1.size(); k++) {  
							EsameBean esame = esami1.get(k);
							ArrayList<DocenteBean> docenti = esame.getDocenti(); %>
						<form action="GestioneEsamiServlet" method = "post">
						<fieldset class="reset-this redo-fieldset"
							style="margin-left: -11px; width: 100%">
							<input type="button" value="<%= esame.getNome() %>" data-toggle="collapse"
								data-target="#<%= esame.getCodiceEsame() %>" style="border: 0px; background: #ffffff;">
						</fieldset>
						<div class="contents">
							<div id="<%= esame.getCodiceEsame() %>" class="collapse">
								<div class="container">
									<center>
										<div class="row">
											<div class="col-sm-3 col-lg-3">
												CFU <input type="number" min="1" max="12"
													class="btn btn-default" name="insertCFU" value="<%= esame.getCFU() %>">
											</div>
											<div class="col-sm-3 col-lg-3">
												Ore <input type="number" min="1" max="96"
													class="btn btn-default" name="insertOre" value="<%= esame.getOreLezione() %>">
											</div>
											<div class="col-sm-6 col-lg-6">
												Anno 
												<select class="form-control selcls" name="Scelta anno" style="width: 40%; display: inline">
														<%for(int b = 0; b < grob1.size(); b++){
														%>
														<option value="<%=grob1.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob1.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0; b < grob2.size(); b++){
														%>
														<option value="<%=grob2.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob2.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0;b < grop1.size(); b++){
																if(b == j){%>
																	<option value="<%=grop1.get(b).getCodiceGEOp() %>" selected>Gruppo <%=grop1.get(b).getTotCFU() %> CFU a scelta </option>
																	<%}else {%>
																	<option value="<%=grop1.get(b).getCodiceGEOp() %>">Gruppo <%=grop1.get(b).getTotCFU() %> CFU a scelta </option>
																	<%}} 
															for(int b = 0; b < grop2.size(); b++){
															%>
														<option value="<%=grop2.get(b).getCodiceGEOp() %>">Gruppo <%=grop2.get(b).getTotCFU() %> CFU a scelta </option>
														<%}%>													
												</select>
											</div>
										</div>
									</center>
									<div id="prof1" class="row">
										<br> <br>
										<div class="col-sm-12 col-lg-12">
											<h4>Docenti:</h4>
										</div>
										
										<% for(int l=0; l<docenti.size(); l++) {  
											DocenteBean docente = docenti.get(l); %>
										<div class="col-sm-12 col-lg-12">
											<div class="col-sm-3 col-lg-3">
												<h4><%= docente.getInsegnamento() %>:</h4>
											</div>
											<div class="col-sm-3 col-lg-3">
												<input type="text" class="form-control" value="<%= docente.getNome() %> <%= docente.getCognome() %>" name="nomeProf">
											</div>
											<div class="col-sm-3 col-lg-3">
												<input type="text" class="form-control" value="<%= docente.getIndirizzoPaginaWeb() %>" name="urlProf" style="display: inline">
											</div>
											<div class="col-sm-3 col-lg-3">
												<button type="button" name="button" onClick=add() class="btn btn-default">
													<span class="glyphicon glyphicon-plus"></span>
												</button>
											</div>
										</div>
										<% } %>
									</div>
									<div class="col-sm-3 col-lg-3">
										<h4>Descrizione:</h4>
									</div>
									<div class="col-sm-9 col-lg-9">
										<textarea name="descrizione" rows="5" cols="79"><%= esame.getDescrizione() %></textarea>
									</div>
									
									<div class="col-sm-4 col-lg-4" style="margin-top: 2%">
										<center>
											
												<div>
													<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="cancellaEsame">
														<span class="glyphicon glyphicon-trash"><br>Cancella esame </span>
													</button>												
												</div>
										</center>
									</div>
									<div class="col-sm-8 col-lg-8" style="margin-top: 2%">
												<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="updateEsame">
													Applica
												</button>
										</div>
								</div>
							</div>
						</div>
						</form>	
						<% } %>
						
						<center>
							<div>
								<form action="GestioneGruppoEsamiOpzionali" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop1.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center"  type="submit" name="metodo" value="deleteGruppo">
											<span class="glyphicon glyphicon-trash"><br>Cancella gruppo </span>
										</button>			
								</form>
								<form action="AggiuntaNuovoEsame.jsp" method="POST">		
										<input type="hidden" name="codiceGruppo" value="<%=grop1.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsame">Aggiungi un nuovo esame</button>
								</form>
								<form action="AggiuntaEsameEsistente.jsp" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop1.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsameEsistente">Aggiungi esame esistente</button>
								</form>
								<form action="ModificaGruppoEsame.jsp" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop1.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center"type="submit" name="metodo" value="updateGruppo" >
											<span class="glyphicon glyphicon-pencil"><br>Modifica gruppo </span>
										</button>
								</form>
							</div>
						</center>
						
					</fieldset>
					<%} %>
					<center>
						<div>
						 <form action="AggiuntaGruppoEsami.jsp" method="POST"> 
						 <input type="hidden" name="offerta" value="<%=offerta %>"></input>
						 <input type="hidden" name="laurea" value="<%=laurea %>"></input>
						 <input type="hidden" name="idCurriculum" value="<%=id %>"></input>
						 <input type="hidden" name="anno" value="1"></input>
							<button class="btn btn-default btn-responsive center">Aggiungi nuovo gruppo d'esami</button>
							</form>
						</div>
					</center>
					<% }
					
			 else if(i == 2){ // Secondo anno
				 ArrayList<EsameBean> esami2 = new ArrayList<EsameBean>();
		        	for(int j = 0; j<grob2.size(); j++){ 	
		        		esami2.addAll(grob2.get(j).getEsami());
		        %>
						<fieldset class="reset-this redo-fieldset"
							style="margin-left: 10px; width: 97%">
							<legend class="reset-this redo-legend">Gruppo obbligatorio <%=grob2.get(j).getCodiceGEOb() %></legend>
							
							<!--  Esame -->
							<% for(int k=0; k<esami2.size(); k++) {  
								EsameBean esame = esami2.get(k);
								ArrayList<DocenteBean> docenti = esame.getDocenti(); %>
							<form action="GestioneEsamiServlet" method = "post">
							<fieldset class="reset-this redo-fieldset"
								style="margin-left: -11px; width: 100%">
								<input type="button" value="<%= esame.getNome() %>" data-toggle="collapse"
									data-target="#<%= esame.getCodiceEsame() %>" style="border: 0px; background: #ffffff;">
							</fieldset>
							<div class="contents">
								<div id="<%= esame.getCodiceEsame() %>" class="collapse">
									<div class="container">
										<center>
											<div class="row">
												<div class="col-sm-3 col-lg-3">
													CFU <input type="number" min="1" max="12"
														class="btn btn-default" name="insertCFU" value="<%= esame.getCFU() %>">
												</div>
												<div class="col-sm-3 col-lg-3">
													Ore <input type="number" min="1" max="96"
														class="btn btn-default" name="insertOre" value="<%= esame.getOreLezione() %>">
												</div>
												<div class="col-sm-6 col-lg-6">
													Anno 
													<select class="form-control selcls" name="Scelta anno" style="width: 40%; display: inline">
														<%for(int b = 0; b < grob1.size(); b++){
														%>
														<option value="<%=grob1.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob1.get(b).getCodiceGEOb()%></option>
														<%}
														for(int b = 0;b < grob2.size(); b++){
																if(b == j){%>
																	<option value="<%=grob2.get(b).getCodiceGEOb() %>" selected>Gruppo obbiligatorio <%=grob2.get(b).getCodiceGEOb()%></option>
																	<%}else {%>
																	<option value="<%=grob2.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob2.get(b).getCodiceGEOb()%> </option>
																	<%}} 
															for(int b = 0; b < grop1.size(); b++){
															%>
														<option value="<%=grop1.get(b).getCodiceGEOp() %>">Gruppo <%=grop1.get(b).getTotCFU() %> CFU a scelta </option>
														<%}
															for(int b = 0;b < grop2.size(); b++){
															%>
														<option value="<%=grop2.get(b).getCodiceGEOp() %>">Gruppo <%=grop2.get(b).getTotCFU() %> CFU a scelta </option>
														<%}%>													
													</select>
												</div>
											</div>
										</center>
										<div id="prof1" class="row">
											<br> <br>
											<div class="col-sm-12 col-lg-12">
												<h4>Docenti:</h4>
											</div>
											
											<% for(int l=0; l<docenti.size(); l++) {  
												DocenteBean docente = docenti.get(l); %>
											<div class="col-sm-12 col-lg-12">
												<div class="col-sm-3 col-lg-3">
													<h4><%= docente.getInsegnamento() %>:</h4>
												</div>
												<div class="col-sm-3 col-lg-3">
													<input type="text" class="form-control" value="<%= docente.getNome() %> <%= docente.getCognome() %>" name="nomeProf">
												</div>
												<div class="col-sm-3 col-lg-3">
													<input type="text" class="form-control" value="<%= docente.getIndirizzoPaginaWeb() %>" name="urlProf" style="display: inline">
												</div>
												<div class="col-sm-3 col-lg-3">
													<button type="button" name="button" onClick=add() class="btn btn-default">
														<span class="glyphicon glyphicon-plus"></span>
													</button>
												</div>
											</div>
											<% } %>
										</div>
										<div class="col-sm-3 col-lg-3">
											<h4>Descrizione:</h4>
										</div>
										<div class="col-sm-9 col-lg-9">
											<textarea name="descrizione" rows="5" cols="79"><%= esame.getDescrizione() %></textarea>
										</div>
										
										<div class="col-sm-4 col-lg-4" style="margin-top: 2%">
											<center>
												
													<div>
														<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="cancellaEsame">
															<span class="glyphicon glyphicon-trash" ><br>Cancella esame </span>
														</button>												
													</div>		
											</center>
										</div>
										
											  <div class="col-sm-8 col-lg-8" style="margin-top: 2%">
												<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="updateEsame">
													Applica
												</button>
										      </div>
								</div>
							</div>
						</div>
						</form>	
						<% } %>
							
							<center>
								<div>
									<form action = "GestioneGruppoEsamiObbligatori" method = "POST">
										<input type="hidden" name="codiceGruppo" value="<%=grob2.get(j).getCodiceGEOb() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="deleteGruppo">
											<span class="glyphicon glyphicon-trash" ><br>Cancella gruppo </span>
										</button>
									</form>
									<form action = "AggiuntaNuovoEsame.jsp" method = "POST">
										<input type="hidden" name="codiceGruppo" value="<%=grob2.get(j).getCodiceGEOb() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsame">Aggiungi un nuovo esame</button>
									</form>
									<form action = "AggiuntaEsameEsistente.jsp" method = "POST">
										<input type="hidden" name="codiceGruppo" value="<%=grob2.get(j).getCodiceGEOb() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsameEsistente">Aggiungi esame esistente</button>
									</form>
								</div>
							</center>
						</fieldset>
						<% } 
		        	esami2.clear();
		    	for (int j = 0; j < grop2.size(); j++) { 
		    		esami2.addAll(grop2.get(j).getEsami());
		    		%>
						<fieldset class="reset-this redo-fieldset"
							style="margin-left: 10px; width: 97%">
							<legend class="reset-this redo-legend"><%=grop2.get(j).getTotCFU() %> a scelta tra: </legend>
							
							<!--  Esame -->
							<% for(int k=0; k<esami2.size(); k++) {  
								EsameBean esame = esami2.get(k);
								ArrayList<DocenteBean> docenti = esame.getDocenti(); %>
							<form action="GestioneEsamiServlet" method = "post">
							<fieldset class="reset-this redo-fieldset" style="margin-left: -11px; width: 100%">
								<input type="button" value="<%= esame.getNome() %>" data-toggle="collapse"
									data-target="#<%= esame.getCodiceEsame() %>" style="border: 0px; background: #ffffff;">
							</fieldset>
							<div class="contents">
								<div id="<%= esame.getCodiceEsame() %>" class="collapse">
									<div class="container">
										<center>
											<div class="row">
												<div class="col-sm-3 col-lg-3">
													CFU <input type="number" min="1" max="12"
														class="btn btn-default" name="insertCFU" value="<%= esame.getCFU() %>">
												</div>
												<div class="col-sm-3 col-lg-3">
													Ore <input type="number" min="1" max="96"
														class="btn btn-default" name="insertOre" value="<%= esame.getOreLezione() %>">
												</div>
												<div class="col-sm-6 col-lg-6">
													Anno 
													<select class="form-control selcls" name="Scelta anno" style="width: 40%; display: inline">
														<%for(int b = 0; b < grob1.size(); b++){
														%>
														<option value="<%=grob1.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob1.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0; b < grob2.size(); b++){
														%>
														<option value="<%=grob2.get(b).getCodiceGEOb() %>">Gruppo obbiligatorio <%=grob2.get(b).getCodiceGEOb()%></option>
														<%}
															for(int b = 0;b < grop1.size(); b++){
															%>
														<option value="<%=grop1.get(b).getCodiceGEOp() %>">Gruppo <%=grop1.get(b).getTotCFU() %> CFU a scelta </option>
														<%}
															for(int b = 0;b < grop2.size(); b++){
																if(b == j){%>
																	<option value="<%=grop2.get(b).getCodiceGEOp() %>" selected>Gruppo <%=grop2.get(b).getTotCFU() %> CFU a scelta </option>
																	<%}else {%>
																	<option value="<%=grop2.get(b).getCodiceGEOp() %>">Gruppo <%=grop2.get(b).getTotCFU() %> CFU a scelta  </option>
															<%}}%>													
													</select>
												</div>
											</div>
										</center>
										<div id="prof1" class="row">
											<br> <br>
											<div class="col-sm-12 col-lg-12">
												<h4>Docenti:</h4>
											</div>
											
											<% for(int l=0; l<docenti.size(); l++) {  
												DocenteBean docente = docenti.get(l); %>
											<div class="col-sm-12 col-lg-12">
												<div class="col-sm-3 col-lg-3">
													<h4><%= docente.getInsegnamento() %>:</h4>
												</div>
												<div class="col-sm-3 col-lg-3">
													<input type="text" class="form-control" value="<%= docente.getNome() %> <%= docente.getCognome() %>" name="nomeProf">
												</div>
												<div class="col-sm-3 col-lg-3">
													<input type="text" class="form-control" value="<%= docente.getIndirizzoPaginaWeb() %>" name="urlProf" style="display: inline">
												</div>
												<div class="col-sm-3 col-lg-3">
													<button type="button" name="button" onClick=add() class="btn btn-default">
														<span class="glyphicon glyphicon-plus"></span>
													</button>
												</div>
											</div>
											<% } %>
										</div>
										<div class="col-sm-3 col-lg-3">
											<h4>Descrizione:</h4>
										</div>
										<div class="col-sm-9 col-lg-9">
											<textarea name="descrizione" rows="5" cols="79"><%= esame.getDescrizione() %></textarea>
										</div>
										
										<div class="col-sm-4 col-lg-4" style="margin-top: 2%">
											<center>
													<div>
														<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="cancellaEsame">
															<span class="glyphicon glyphicon-trash"><br>Cancella esame </span>
														</button>												
													</div>		
											</center>
										</div>
										
												 <div class="col-sm-8 col-lg-8" style="margin-top: 2%">
												 	<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="updateEsame">
													Applica
													</button>
										        </div>
								</div>
							</div>
						</div>
						</form>	
						<% } %>
							
							<center>
								<div>
									<form action="GestioneGruppoEsamiOpzionali" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop2.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="deleteGruppo">
											<span class="glyphicon glyphicon-trash"><br>Cancella gruppo </span>
										</button>
									</form>				
									<form action="AggiuntaNuovoEsame.jsp" method="POST">		
										<input type="hidden" name="codiceGruppo" value="<%=grop2.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsame">Aggiungi un nuovo esame</button>
									</form>
									<form action="AggiuntaEsameEsistente.jsp" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop2.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="aggiungiEsameEsistente">Aggiungi esame esistente</button>
									</form>
									<form action="ModificaGruppoEsame.jsp" method="POST">
										<input type="hidden" name="codiceGruppo" value="<%=grop2.get(j).getCodiceGEOp() %>"></input>
										<button class="btn btn-default btn-responsive center" type="submit" name="metodo" value="updateGruppo">
											<span class="glyphicon glyphicon-pencil"><br>Modifica gruppo </span>
										</button>
									</form>
								</div>
							</center>
						</fieldset>
						<%} %>
						<center>
						<div>
						 <form action="AggiuntaGruppoEsami.jsp" method="POST"> 
						 <input type="hidden" name="offerta" value="<%=offerta %>"></input>
						 <input type="hidden" name="laurea" value="<%=laurea %>"></input>
						 <input type="hidden" name="idCurriculum" value="<%=id %>"></input>
						 <input type="hidden" name="anno" value="2"></input>
							<button class="btn btn-default btn-responsive center">Aggiungi nuovo gruppo d'esami</button>
							</form>
						</div>
					</center>
						<% }%>
				</fieldset>
				<%}} %>
			</center>
		</div>
	</body>
</html>