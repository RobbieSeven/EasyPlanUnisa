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
     	 ArrayList<CurriculumBean> lista = new ArrayList<CurriculumBean>();
     	CurriculumBeanDao cd = new CurriculumBeanDao();
     	String laurea=request.getParameter("laurea");
     	
     	String id = "";
     	int tipo;
     	
     	if(laurea.equals("triennale")){
	     	tipo=1;	
	     	id = request.getParameter("idCorsoDiLaureaTriennale");
     	}else {
     		tipo=2;
     		id = request.getParameter("idCorsoDiLaureaMagistrale");
     	}
     	
     	String offerta= request.getParameter("offerta");
     	lista = cd.doRetriveByCorsoDiLaureaOffertaFormativa(tipo,offerta);
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
    <link rel="stylesheet" href="AdminStyle.css">
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
<!-- "Login amministratore" --><li><a href="Logout" style="color:#000000">Log out <span class="glyphicon glyphicon-log-out"></span></a></li>          </ul>
        </div>
      </div>
    </nav>
    <form action="SelezionaLaureaAm.jsp" method = "post">
       	<input type="hidden" name="offerta" value="<%=request.getParameter("offerta")%>">
    	<button name="button" id="laureaScelta" class="btn btn-default btn-responsive left-block">Indietro</button>
    </form>
    <div align=center class="col-md-12">
      <h2 align=center>Seleziona curricula da modificare</h2>
      <%for(int i=0; i<lista.size(); i++){ %>
          <div align=center style="display: -webkit-inline-box">
            <form action="GestioneEsami.jsp" method="POST">
             <input type="hidden" name="laurea" value="<%=request.getParameter("laurea")%>">
             <input type="hidden" name="offerta" value="<%=request.getParameter("offerta")%>">
             <input type="hidden" name="curriculum" value="<%= lista.get(i).getNomeCurriculum()%>">            
             <button class="btn btn-default btn-responsive center dimBigButton" class="btn btn-default btn-responsive center dimBigButton"><%=lista.get(i).getNomeCurriculum()%></button>
             <input type="hidden" name="idCurriculum" value="<%=lista.get(i).getIdCurriculum()%>">
             <input type="hidden" name="idCorsoDiLaurea" value="<%=id %>"></input>
            </form>
            
            <form action="GestioneCurricula" method="POST">
            	<input type="hidden" name="metodo" value="eliminaCurricula">
				<input type="hidden" name="laurea" value="<%=laurea%>">
				<input type="hidden" name="offerta" value="<%=request.getParameter("offerta")%>">
				<input type="hidden" name="idCurriculum" value="<%=lista.get(i).getIdCurriculum()%>">
				<input type="hidden" name="idCorsoDiLaurea" value="<%=id %>">
            	<button class="btn btn-default btn-responsive center" style="margin-left: -250px">		
            		<span class="glyphicon glyphicon-trash"></span>
            	</button>
            </form>
          </div>
          <br>
          <% } %>

          <br>
          <div align=center>
	          <form action="AggiungiCurricula.jsp" method="POST">
		          <input type="hidden" name="metodo" value="aggiuntaCurricula">
		          <input type="hidden" name="laurea" value="<%=request.getParameter("laurea")%>">
		          <input type="hidden" name="offerta" value="<%=request.getParameter("offerta")%>">
		          <input type="hidden" name="idCorsoDiLaurea" value="<%=id %>"></input>
	          	  <button class="btn btn-default btn-responsive center dimButton"><span class="glyphicon glyphicon-plus"><br>Aggiungi</span></button>
	          </form>
          </div>
		  
   
    </div>
  </body>
</html>