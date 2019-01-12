
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList"
    import="java.util.HashMap" pageEncoding="UTF-8" import="model.OffertaFormativaBean" import="model.CorsoDiLaureaBean"
    import="model.CurriculumBean" import="model.EsameBean" import="model.DocenteBean"
    import="model.gruppo.esami.obbligatori.GruppoEsamiObbligatoriBean" import="model.gruppo.esami.opzionali.GruppoEsamiOpzionaliBean" %>
    
    <%! @SuppressWarnings("unchecked") %>
    <%// Simulazione dati presi dal database
    
    ArrayList<GruppoEsamiObbligatoriBean> ob1 = (ArrayList<GruppoEsamiObbligatoriBean>) session.getAttribute("obbligatori1");
	ArrayList<GruppoEsamiObbligatoriBean> ob2 = (ArrayList<GruppoEsamiObbligatoriBean>) session.getAttribute("obbligatori2");
	ArrayList<GruppoEsamiObbligatoriBean> ob3 = (ArrayList<GruppoEsamiObbligatoriBean>) session.getAttribute("obbligatori3");
	
	ArrayList<GruppoEsamiOpzionaliBean> op1 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o1");
	ArrayList<GruppoEsamiOpzionaliBean> op2 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o2");
	ArrayList<GruppoEsamiOpzionaliBean> op3 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o3");
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
    	<h3 align=center>Il tuo Piano di studi</h3><br>
    		<div class="col-md-12">
		      <!-- esami obbligatori anno 1 -->
   				<%for(int i = 0; i < ob1.size(); i++){ %>
		    	<div class="table-wrapper-scroll-y">
			   		<table class="table table-bordered table-striped">
						<thead>
						<tr><td ><b><%=ob1.get(i).getAnno() %> anno obbligatorio</b></td><td><%=" " %></td></tr>
		      				<tr>
						         <th scope="col" style="width:80%">Nome esame</th>
						         <th scope="col" style="width:20%">CFU</th>
		      				</tr>
		    			</thead>
		    				<tbody>
			   				<% for(int j = 0; j< ob1.get(i).getEsami().size(); j++){ %>
		    					  <tr>
		        					<td scope="row"><%=ob1.get(i).getEsami().get(j).getNome() %></td>
		        					<td><%=ob1.get(i).getEsami().get(j).getCfu() %></td>
		      					</tr>
			     			<%}%>
			   				</tbody>
			     	</table>
			     </div>
			     <%} %>
			     <br>
			     <br>
				 <!-- esami opzionali anno 1 -->
    			 <%for(int i = 0; i < op1.size(); i++){ %>	
				  <div class="table-wrapper-scroll-y">
				   	<table class="table table-bordered table-striped">
						<thead>
							<tr><td><b>1 anno opzionale <%=op1.get(i).getTotCfu() %> CFU</b></td><td><%=" " %></td></tr>
			      				<tr>
							         <th scope="col" style="width:80%">Nome esame</th>
						        	 <th scope="col" style="width:20%">CFU</th>
			      				</tr>
			    		</thead>
			    		<tbody>
				   			<% for(int j = 0; j< op1.get(i).getEsami().size(); j++){ %>
				    				<tr>
				        				<td scope="row"><%=op1.get(i).getEsami().get(j).getNome() %></td>
				        				<td><%=op1.get(i).getEsami().get(j).getCfu() %></td>
				      				</tr>
					     		<%}%>
				   		</tbody>
				     </table>
				    </div>
				    <%} %>
				    
				 <!-- esami obbligatori anno 2 -->
   				<%for(int i = 0; i < ob2.size(); i++){ %>
		    	<div class="table-wrapper-scroll-y">
			   		<table class="table table-bordered table-striped">
						<thead>
						<tr><td ><b><%=ob2.get(i).getAnno() %> anno obbligatorio</b></td><td><%=" " %></td></tr>
		      				<tr>
						         <th scope="col" style="width:80%">Nome esame</th>
						         <th scope="col" style="width:20%">CFU</th>
		      				</tr>
		    			</thead>
		    				<tbody>
			   				<% for(int j = 0; j< ob2.get(i).getEsami().size(); j++){ %>
		    					  <tr>
		        					<td scope="row"><%=ob2.get(i).getEsami().get(j).getNome() %></td>
		        					<td><%=ob2.get(i).getEsami().get(j).getCfu() %></td>
		      					</tr>
			     			<%}%>
			   				</tbody>
			     	</table>
			     </div>
			     <%} %>
			     <br>
			     <br>
				 <!-- esami opzionali anno 2 -->
    			 <%for(int i = 0; i < op2.size(); i++){ %>	
				  <div class="table-wrapper-scroll-y">
				   	<table class="table table-bordered table-striped">
						<thead>
							<tr><td><b>2 anno opzionale <%=op2.get(i).getTotCfu() %> CFU</b></td><td><%=" " %></td></tr>
			      				<tr>
							         <th scope="col" style="width:80%">Nome esame</th>
						        	 <th scope="col" style="width:20%">CFU</th>
			      				</tr>
			    		</thead>
			    		<tbody>
				   			<% for(int j = 0; j< op2.get(i).getEsami().size(); j++){ %>
				    				<tr>
				        				<td scope="row"><%=op2.get(i).getEsami().get(j).getNome() %></td>
				        				<td><%=op2.get(i).getEsami().get(j).getCfu() %></td>
				      				</tr>
					     		<%}%>
				   		</tbody>
				     </table>
				    </div>
				    <%} %>
			   	
			   	<!-- esami obbligatori anno 3 -->
   				<%for(int i = 0; i < ob3.size(); i++){ %>
		    	<div class="table-wrapper-scroll-y">
			   		<table class="table table-bordered table-striped">
						<thead>
						<tr><td ><b><%=ob3.get(i).getAnno() %> anno obbligatorio</b></td><td><%=" " %></td></tr>
		      				<tr>
						         <th scope="col" style="width:80%">Nome esame</th>
						         <th scope="col" style="width:20%">CFU</th>
		      				</tr>
		    			</thead>
		    				<tbody>
			   				<% for(int j = 0; j< ob3.get(i).getEsami().size(); j++){ %>
		    					  <tr>
		        					<td scope="row"><%=ob3.get(i).getEsami().get(j).getNome() %></td>
		        					<td><%=ob3.get(i).getEsami().get(j).getCfu() %></td>
		      					</tr>
			     			<%}%>
			   				</tbody>
			     	</table>
			     </div>
			     <%} %>
			     <br>
			     <br>
				 <!-- esami opzionali anno 3 -->
    			 <%for(int i = 0; i < op3.size(); i++){ %>	
				  <div class="table-wrapper-scroll-y">
				   	<table class="table table-bordered table-striped">
						<thead>
							<tr><td><b>3 anno opzionale <%=op3.get(i).getTotCfu() %> CFU</b></td><td><%=" " %></td></tr>
			      				<tr>
							         <th scope="col" style="width:80%">Nome esame</th>
						        	 <th scope="col" style="width:20%">CFU</th>
			      				</tr>
			    		</thead>
			    		<tbody>
				   			<% for(int j = 0; j< op3.get(i).getEsami().size(); j++){ %>
				    				<tr>
				        				<td scope="row"><%=op3.get(i).getEsami().get(j).getNome() %></td>
				        				<td><%=op3.get(i).getEsami().get(j).getCfu() %></td>
				      				</tr>
					     		<%}%>
				   		</tbody>
				     </table>
				    </div>
				    <%} %>
			   	
	   		</div>
	   		
	   		
	   		
		</div>
	 <br>
	 	<div align=center>
	  	 <button name="button" class="btn btn-default btn-responsive center" onclick="HTMLtoPDF()">Scarica piano</button>
	  	 <a href="https://esse3web.unisa.it/Home.do"  class="btn btn-default btn-responsive center">Vai ad Esse3</a>
  		</div>
  	 <br>
  </body>
</html>