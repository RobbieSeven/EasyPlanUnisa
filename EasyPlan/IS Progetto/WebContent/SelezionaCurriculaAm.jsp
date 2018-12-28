<%@page import="model.CurriculumBeanDAO"%>
<%@page import="model.CurriculumBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.ArrayList" pageEncoding="UTF-8"%>

<%
     	// Simulazione dati presi dal database
     	 ArrayList<CurriculumBean> lista = new ArrayList<CurriculumBean>();
     	CurriculumBeanDAO cd = new CurriculumBeanDAO();
     	lista = cd.doRetriveByCorsoDiLaureaOffertaFormativa(2,"2018/19");
     %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>EasyPlan | Offerta formativa</title>
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
<!-- "Login amministratore" --><li><a href="Login amministratore" style="color:#000000">Log out <span class="glyphicon glyphicon-log-out"></span></a></li>          </ul>
        </div>
      </div>
    </nav>
    <div class="col-md-12">
      <center><h2>Seleziona curricula da modificare</h2></center>
      <%for(int i=0; i<lista.size(); i++){ %>
          <center><div>
            <input type="button" name="curriculum" value="<%=lista.get(i).getNomeCurriculum()%>" class="btn btn-default btn-responsive center">
            <button class="btn btn-default btn-responsive center">
            <form action="GestioneCurricula" method="POST">
						<input type="hidden" name="metodo" value="eliminaCurricula">
						<input type="hidden" name="idCurriculum" value="<%=lista.get(i). getIdCurriculum()%>">
            <span class="glyphicon glyphicon-trash"></span></button>
            </form>
          </div></center>
          <br>
          <% } %>

          <br>
          <center><div>
          <form action="AggiungiCurricula.jsp" method="POST">
          <input type="hidden" name="metodo" value="aggiuntaCurricula">
          <button class="btn btn-default btn-responsive center"><span class="glyphicon glyphicon-plus"><br>Aggiungi</button></span></div></center>
		  </form>
   
    </div>
  </body>
</html>