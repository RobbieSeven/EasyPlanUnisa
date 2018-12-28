<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList"
    pageEncoding="UTF-8"%>
    
    
     <%
     	// Simulazione dati presi dal database
     	ArrayList<String> curricula = new ArrayList<String>();
     curricula.add("Sicurezza"); curricula.add("SITS"); curricula.add("Cloud computing");
     %>
     
     
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>EasyPlan | Scelta curricula</title>
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
<!-- "Login amministratore" --><li><a href="Login amministratore" style="color:#000000">Admin</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <img alt="logo" src="../../immagini/logo.png" class="img-responsive center-block">
    <div class="col-md-12">
	    <form action="DioBrando" method = "post">
	    
	    <%for(int i = 0; i < curricula.size(); i++){ %>
	         <button name="button" id="curricula##" class="btn btn-default btn-responsive center-block"><%=curricula.get(i) %></button>
	         <br>
	     <%}%>
	     
	   </form>
    </div>
  </body>
</html>