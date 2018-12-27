<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList"
    pageEncoding="UTF-8"%>
    
    <%
     	// Simulazione dati presi dal database
     	ArrayList<String> off = new ArrayList<String>();
     	off.add("2018/19"); off.add("2017/18"); off.add("2016/17");
     %>
    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>EasyPlan | Offerta formativa</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    
    <style>
    .navbar-inverse {
   	 background-color: #ada2b2;
   	 border-color: #ada2b2;
   	 
   	 
 
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
			<!-- "Login amministratore" --><li><a href="Login amministratore" style="color:#000000">Log out <span class="glyphicon glyphicon-log-out"></span></a></li>
          </ul>
        </div>
      </div>
    </nav>
    
    <div class="col-md-5 col-centered"></div>
     <div class="col-md-2 col-centered">
	    <form action="DioBrando" method = "post">
	    Seleziona curricula<select>
	    						<option></option>
	    				   </select>
	 	</br>
	   Seleziona Gruppo esame<select>
	    						<option></option>
	    				   </select>
	 	</br>
	   Seleziona Esame<select>
	    					<option></option>
	    			  </select>
	 	</br> </br>
	     <button>Aggiungi esame</button>
	   </form>
    </div>
     <div class="col-md-5 col-centered"></div>
  </body>
</html>