<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList"
    import="java.util.HashMap" pageEncoding="UTF-8" import="model.OffertaFormativaBean" import="model.CorsoDiLaureaBean"
    import="model.CurriculumBean" import="model.EsameBean" import="model.DocenteBean"
    import="model.GruppoEsamiObbligatoriBean" import="model.GruppoEsamiOpzionaliBean" %>
    
    
    <%// Simulazione dati presi dal database
    
    ArrayList<GruppoEsamiObbligatoriBean> obb = (ArrayList<GruppoEsamiObbligatoriBean>) request.getAttribute("esamiOb");
	ArrayList<GruppoEsamiOpzionaliBean> opz = (ArrayList<GruppoEsamiOpzionaliBean>) request.getAttribute("esamiOpz");
	
	int anni = 0;
	
	if(obb.size()==2)
		anni = 2;
	if(obb.size()==3)
		anni = 3;
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
<!-- "Login amministratore" --><li><a href="Login.html" style="color:#000000">Admin</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div id="HTMLtoPDF">
    	<center><h3>Il tuo Piano di studi</h3></center><br>
    		<div class="col-md-12">
		      <%for(int i = 0; i < anni; i++) { %>
		    	<div class="table-wrapper-scroll-y">
			   		<table class="table table-bordered table-striped">
						<thead>
						<tr><td ><b><%=(i+1) %> anno obbligatorio</b></td><td><%=" " %></td></tr>
		      				<tr>
						        <th scope="col">Nome esame</th>
						        <th scope="col">CFU</th>
		      				</tr>
		    			</thead>
		    				<tbody>
			   				<% for(int j = 0; j< obb.get(i).getEsami().size(); j++){ %>
		    					  <tr>
		        					<td scope="row"><%=obb.get(i).getEsami().get(j).getNome() %></td>
		        					<td><%=obb.get(i).getEsami().get(j).getCFU() %></td>
		      					</tr>
			     			<%}%>
			   				</tbody>
			     	</table>
			     </div>
				 <%if(anni == 2){ %>	
				  <div class="table-wrapper-scroll-y">
				   	<table class="table table-bordered table-striped">
						<thead>
							<tr><td><b><%=(i+1) %> anno opzionale</b></td><td><%=" " %></td></tr>
			      				<tr>
							        <th scope="col">Nome esame</th>
							        <th scope="col">CFU</th>
			      				</tr>
			    		</thead>
			    		<tbody>
				   			<% for(int j = 0; j< opz.get(i).getEsami().size(); j++){ %>
			    				<tr>
			        				<td scope="row"><%=opz.get(i).getEsami().get(j).getNome() %></td>
			        				<td><%=opz.get(i).getEsami().get(j).getCFU() %></td>
			      				</tr>
				     		<%}%>
				   		</tbody>
				     </table>
				    </div>
				    <%} %>
				     <%if(anni == 3 && i == 2){ %>
				     	<div class="table-wrapper-scroll-y">
				   			<table class="table table-bordered table-striped">
								<thead>
									<tr><td><b><%=(i+1) %> anno opzionale</b></td><td><%=" " %></td></tr>
				      					<tr>
								     	   <th scope="col">Nome esame</th>
								        	<th scope="col">CFU</th>
				      					</tr>
				    			</thead>
				    			<tbody>
					   				<% for(int j = 0; j< opz.get(0).getEsami().size(); j++){ %>  
					   					<tr>
				        					<td scope="row"><%=opz.get(0).getEsami().get(j).getNome() %></td>
				        					<td><%=opz.get(0).getEsami().get(j).getCFU() %></td>
				      					</tr>
					     			<%}%>
					   			</tbody>
				     	</table>
				     </div>
				    <%} %>
			   	<% } %>
	   		</div>
		</div>
	 <br>
  	 <center><button name="button" class="btn btn-default btn-responsive center" onclick="HTMLtoPDF()">Scarica piano</button>
  	 <a href="https://esse3web.unisa.it/Home.do" name="button" class="btn btn-default btn-responsive center">Vai ad Esse3</a></center>
  </body>
</html>