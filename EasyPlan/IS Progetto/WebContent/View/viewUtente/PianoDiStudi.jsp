<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList"
    import="java.util.HashMap" pageEncoding="UTF-8"%>
    
    
    <%// Simulazione dati presi dal database
    
   		 HashMap<String,ArrayList<String>> ct = new HashMap<>();
     	 
     	ArrayList<String> esami = new ArrayList<String>();
     esami.add("Sicurezza"); esami.add("SITS"); esami.add("Cloud computing");
     
     ArrayList<String> esamiOpz = new ArrayList<String>();
     esamiOpz.add("mobile computing"); esamiOpz.add("IUM"); esamiOpz.add("Calcolo scientifico");
     
     ArrayList<String> nome = new ArrayList<String>();
     nome.add("1°anno obbligatorio"); nome.add("3°anno opzionale");
     ct.put("1°anno obbligatorio", esami);
     ct.put("3°anno opzionale", esamiOpz);
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
    
    <script src="jquery-2.1.3.js"></script>
  <script src="jspdf.js"></script>
  <script src="pdfFromHTML.js"></script>
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
      <div id="HTMLtoPDF">
      
      <%for(int z = 0; z < ct.size(); z++){ %>
    	
    	<div class="table-wrapper-scroll-y">
	   		<table class="table table-bordered table-striped">
				<thead>
				<tr><td><%=nome.get(z) %></td></tr>
      				<tr>
				        <th scope="col">Nome esame</th>
				        <th scope="col">CFU</th>
      				</tr>
    			</thead>
    				<tbody>
	   				<% for(int i = 0; i < ct.get(nome.get(z)).size(); i++){ %>
	   					
    					  <tr>
        					<th scope="row"><%=ct.get(nome.get(z)).get(i) %></th>
        					<td>9</td>
      					</tr>
	     			<%}
	   				} %>
	     		</tbody>
	     	</table>
	     </div>
	     </div>
	  </form>
	  </div>





 

    <br>


  
   <center><button name="button" class="btn btn-default btn-responsive center" onclick="HTMLtoPDF()">Scarica piano</button>
   <a href="https://esse3web.unisa.it/Home.do" name="button" class="btn btn-default btn-responsive center">Vai ad Esse3</a></center>

  </body>
  
</html>