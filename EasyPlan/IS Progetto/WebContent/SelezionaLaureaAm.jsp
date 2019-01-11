<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CorsoDiLaureaBean"%>
<%@page import="model.CorsoDiLaureaBeanDao"%>
<%@page import="model.OffertaFormativaBeanDao"%>
<%@page import="model.OffertaFormativaBean"%>
<!DOCTYPE html>
<html>
<%
  synchronized (session)
	{
		if(session.getAttribute("amministratore") == null && session.getAttribute("password") == null )
		{
			RequestDispatcher view = request.getRequestDispatcher("Login.html");
			view.forward(request, response);
	
		}
	}
	String offerta = request.getParameter("offerta");
	ArrayList<CorsoDiLaureaBean> lauree = new ArrayList<>();
	CorsoDiLaureaBeanDao ldao = new CorsoDiLaureaBeanDao();
	lauree.addAll(ldao.doRetriveCorsoDiLaureaInOfferta(offerta));
%>
  <head>
    <meta charset="UTF-8">
    <title>EasyPlan Admin | Scelta laurea </title>
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
    .navbar-inverse .navbar-nav>li>a {
    color: #000000;
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
<!-- "Login amministratore" --><li><a href="Logout">Log out <span class="glyphicon glyphicon-log-out"></span></a></li>
          </ul>
        </div>
      </div>
    </nav>
    <form action="GestioneOfferteFormative.jsp" method = "post">
    	<button name="button" id="laureaScelta" class="btn btn-default btn-responsive left-block">Indietro</button>
    </form>
    <div class="col-md-12">
   
      <br>
      
       <form action="SelezionaCurriculaAm.jsp" method = "post">
	       <input type="hidden" name="laurea" value="triennale">
	       <input type="hidden" name="offerta" value="<%=request.getParameter("offerta")%>">
	       <input type="hidden" name="idCorsoDiLaureaTriennale" value="<%=lauree.get(0).getIdCorsoDiLaurea()%>">
         	<button name="button" id="laureaScelta" class="btn btn-default btn-responsive center-block dimButton centerButton">Laurea triennale</button>
        </form>
         <br>
         <form action="SelezionaCurriculaAm.jsp" method = "post">
	         <input type="hidden" name="laurea" value="magistrale">
	          <input type="hidden" name="offerta" value="<%=request.getParameter("offerta")%>">
	          <input type="hidden" name="idCorsoDiLaureaMagistrale" value="<%=lauree.get(1).getIdCorsoDiLaurea()%>">
	         <button name="button" id="laureaScelta" class="btn btn-default btn-responsive center-block dimButton">Laurea magistrale</button>
   		</form>
       </div>
  </body>
</html>