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

<% String laurea=request.getParameter("laurea");
		int tipo;
		if(laurea.equals("triennale")){
			tipo=1;	
		}else {tipo=2;}
		String offerta= request.getParameter("offerta");
		int id= Integer.parseInt(request.getParameter("idCurriculum"));
		int anno = Integer.parseInt(request.getParameter("anno"));
		%>


<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>EasyPlan | Aggiunta gruppo esame</title>
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
  </style>
</head>

<body>
  <div class="panel panel-default">
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
            <li><a href="Login amministratore" style="color:#000000">Log out <span class="glyphicon glyphicon-log-out"></span></a></li>
          </ul>
        </div>
      </div>
    </nav>

    <center>
      <fieldset class="reset-this redo-fieldset" style="margin-left: 10px;">
        <div class="col-md-12">
          <div class="container">
            <center>
              <h2>Aggiunta nuovo gruppo di esami</h2>
            </center>
            <form class="form-horizontal">
              <div class="form-group">
                <label class="control-label col-sm-6" for="numerocfu">Numero CFU:</label>
                <div class="col-sm-1">
                  <input type="number" name="quantity" min="0" max="18" step="1" value="30">
                </div>
              </div>
          </div>
          <div class="col-sm-offset-5 col-sm-10">
            <br>
            <form action="">
              <input type="radio" name="esame" value="obbligatorio"> Obbligatorio<br>
              <input type="radio" name="esame" value="opzionale"> Opzionale
            </form>
          </div>
          <center><input type="submit" name="" value="Aggiungi nuovo curricula" class="btn btn-default" style="margin-top:2%"></center>
        </div>
      </fieldset>
    </center>
  </div>
</body>

</html>