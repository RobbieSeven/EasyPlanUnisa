<%@page import="model.gruppo.esami.obbligatori.GruppoEsamiObbligatoriBeanDao"%>
<%@page import="model.gruppo.esami.obbligatori.GruppoEsamiObbligatoriBean"%>
<%@page import="model.gruppo.esami.opzionali.GruppoEsamiOpzionaliBeanDao"%>
<%@page import="model.gruppo.esami.opzionali.GruppoEsamiOpzionaliBean"%>
<%@page import="model.esame.EsameBeanDao"%>
<%@page import="model.esame.EsameBean"%>
<%@page import="model.docente.DocenteBeanDao"%>
<%@page import="model.docente.DocenteBean"%>
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

		String laurea=request.getParameter("laurea");
		String offerta= request.getParameter("offerta");
		String curriculum = request.getParameter("curriculum");
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
            <li><a href="Logout" style="color:#000000">Log out <span class="glyphicon glyphicon-log-out"></span></a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div align=center>
      <fieldset class="reset-this redo-fieldset" style="margin-left: 10px;">
        <div class="col-md-12">
          <div class="container">
           
              <h2 align=center>Aggiunta nuovo gruppo di esami</h2>
            
            <form class="form-horizontal" action="GestioneGruppoEsami" method="POST">
            	
				<input type="hidden" name="laurea" value="<%=laurea%>"></input>
				<input type="hidden" name="offerta" value="<%=offerta%>"></input>
				<input type="hidden" name="curriculum" value="<%=curriculum%>"></input>
				<input type="hidden" name="idCurriculum" value="<%=id%>"></input>
				<input type="hidden" name="anno" value="<%=anno%>"></input>
				<input type="hidden" name="metodo" value="aggiungiGruppo"></input>
              <div class="form-group">
                <label class="control-label col-sm-6" for="numerocfu">Numero CFU:</label>
                <div class="col-sm-1">
                  <input type="number" name="quantity" min="1" step="1" value="1">
                </div>
              </div>
              <div class="col-sm-offset-5 col-sm-10">
            	<br>
             	 <input type="radio" name="esame" value="obbligatorio" > Obbligatorio<br>
             	 <input type="radio" name="esame" value="opzionale" checked > Opzionale
         	 </div>
         	 <div class="col-sm-offset-5 col-sm-10">
          		<input type="submit" name="" value="Aggiungi nuovo gruppo" class="btn btn-default" style="margin-top:2%">
          	</div>
          	</form>
          </div>
        </div>
      </fieldset>
    </div>
  </div>
</body>

</html>