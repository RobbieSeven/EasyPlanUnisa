<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList"
    pageEncoding="UTF-8"%>
    
    
     <%
     	// Simulazione dati presi dal database successivamente la pagina sarà riempita con le hashtable
     	ArrayList<String> esami = new ArrayList<String>();
     esami.add("Sicurezza"); esami.add("SITS"); esami.add("Cloud computing");
     
     ArrayList<String> esamiOpz = new ArrayList<String>();
     esamiOpz.add("mobile computing"); esamiOpz.add("IUM"); esamiOpz.add("Calcolo scientifico");
     %>
     
     
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>EasyPlan | Piano di studio</title>
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
    .table-wrapper-scroll-y {
display: block;
max-height: 200px;
overflow-y: auto;
-ms-overflow-style: -ms-autohiding-scrollbar;
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
    <div class="col-md-12">
    <form action="DioBrando" method = "post">
    	<%="1° anno obbligatorio" %>
    	<div class="table-wrapper-scroll-y">
	   		<table class="table table-bordered table-striped">
				<thead>
      				<tr>
				        <th scope="col">Nome esame</th>
				        <th scope="col">CFU</th>
				        <th scope="col">Selezionato</th>
      				</tr>
    			</thead>
    				<tbody>
	   				<% for(int i = 0; i < esami.size(); i++){ %>
	   					
    					  <tr>
        					<th scope="row"><a  data-toggle="collapse" href="#collapseExample<%=i %>" role="button" aria-expanded="false" aria-controls="collapseExample"><%=esami.get(i)%></a>
        						<div class="collapse" id="collapseExample<%=i%>">
 			 						<div class="card card-body">
   									  Descrizione <%="infoesame" %><br>
   									 <a href=" <%="link professore" %>">linkProfessore</a><br>
   									 conoscenze di base <%="conoscenze di base" %><br>
   									 ore di lezione <%="orelezione" %><br>
  									</div>
								</div>
       						</th>
        					<td>9</td>
        					<td>
       							<input type="checkbox" class="form-check-input filled-in" id="orangeExample" disabled checked>
        					</td>
      					</tr>
	     			<%} %>
	     		</tbody>
	     	</table>
	     </div>
	     
	     <%="3° anno scelta" %>
    	<div class="table-wrapper-scroll-y">
	   		<table class="table table-bordered table-striped">
				<thead>
      				<tr>
				        <th scope="col">Nome esame</th>
				        <th scope="col">CFU</th>
				        <th scope="col">Selezionato</th>
      				</tr>
    			</thead>
    				<tbody>
	   				<% for(int i = 0; i < esamiOpz.size(); i++){ %>
    					  <tr>
        					<th scope="row"><a  data-toggle="collapse" href="#collapseExample<%=i+4 %>" role="button" aria-expanded="false" aria-controls="collapseExample"><%=esamiOpz.get(i)%></a>
        						<div class="collapse" id="collapseExample<%=i+4%>">
 			 						<div class="card card-body">
   									 Descrizione <%="infoesame" %><br>
   									 <a href=" <%="link professore" %>">linkProfessore</a><br>
   									 conoscenze di base <%="conoscenze di base" %><br>
   									 ore di lezione <%="orelezione" %><br>
  									</div>
								</div>
       						</th>
        					<td>9</td>
        					<td>
       							<input type="checkbox" class="form-check-input filled-in" id="orangeExample">
        					</td>
      					</tr>
	     			<%} %>
	     		</tbody>
	     	</table>
	     </div>
	  </form>
    </div>
    
    <br>
	<form action="" method="Post">
   		<button name="button" id="laureaScelta" class="btn btn-default btn-responsive center-block">Fine</button>
  	</form>
  </body>
</html>