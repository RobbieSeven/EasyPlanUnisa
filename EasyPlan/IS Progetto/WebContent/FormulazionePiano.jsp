<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList"
    pageEncoding="UTF-8" import="model.OffertaFormativaBean" import="model.CorsoDiLaureaBean"
    import="model.CurriculumBean" import="model.EsameBean" import="model.DocenteBean"
    import="model.GruppoEsamiObbligatoriBean" import="model.GruppoEsamiOpzionaliBean" %>
      
     <%
     	// Simulazione dati presi dal database
     	OffertaFormativaBean of = (OffertaFormativaBean) request.getAttribute("offertaFormativa"); 
    	ArrayList<CorsoDiLaureaBean> cd = of.getLauree();
    	ArrayList<CurriculumBean> cm = cd.get(0).getCurricula();
    	ArrayList<GruppoEsamiObbligatoriBean> gob = cm.get(0).getGruppi_obbligatori();
    	ArrayList<GruppoEsamiOpzionaliBean> gop = cm.get(0).getGruppi_opzionali();
    	int tri = 0;
    	if(cd.get(0).isTipo()==1)
    		tri = 3;
    	
    	session = request.getSession(true);
    	ArrayList<GruppoEsamiOpzionaliBean> opz = new ArrayList<GruppoEsamiOpzionaliBean>();
    	GruppoEsamiOpzionaliBean op = new GruppoEsamiOpzionaliBean();
    	GruppoEsamiOpzionaliBean op2 = new GruppoEsamiOpzionaliBean();
    	
    	ArrayList<GruppoEsamiObbligatoriBean> ob = new ArrayList<GruppoEsamiObbligatoriBean>();
    	synchronized(session){
    		session.setAttribute("offertaFormativa",of);

        	if(ob.isEmpty()){
        		ob = gob;
        		session.removeAttribute("obbligatori");
        		session.setAttribute("obbligatori", ob);
        	}
        	if(session.getAttribute("opzionali") == null){
	        	if(opz.isEmpty()){
	        		opz.add(op);
	        		opz.add(op2);
	        		session.setAttribute("opzionali", opz);
	        	}
        	}
        	else
        	{
        		opz = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali");
        		session.removeAttribute("opzionali");
        		session.setAttribute("opzionali", opz);
        	}
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
<!-- "Login amministratore" --><li><a href="Login.html" style="color:#000000">Admin</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="col-md-12">
    <%for(int anno = 1; anno <= 3; anno++){ %>
    	<%for(int i = 0; i < gob.size(); i++){ %>
    		<%if(gob.get(i).getAnno()== anno){ %>
    			<%=anno+"° anno obbligatorio" %>
    			
    			<div class="table-wrapper-scroll-y">
	   				<table class="table table-bordered table-striped">
						<thead>
      						<tr>
				        		<th scope="col">Nome esame</th><th scope="col">CFU</th><th scope="col">Selezionato</th>
      						</tr>
    					</thead>
    				<tbody>
	   					<% for(int j = 0; j < gob.get(i).getEsami().size(); j++){ %>
    					  <tr>
    					  <form action="selectionOfferta" method = "post">
        					<th scope="row"><a  data-toggle="collapse" href="#collapseExample<%=gob.get(i).getEsami().get(j).getCodiceEsame() %>" role="button" aria-expanded="false" aria-controls="collapseExample"><%=gob.get(i).getEsami().get(j).getNome()%></a>
        						<div class="collapse" id="collapseExample<%=gob.get(i).getEsami().get(j).getCodiceEsame()%>">
 			 						<div class="card card-body">
   									  Descrizione <%=gob.get(i).getEsami().get(j).getDescrizione()%><br>
   									  <%for(int z = 0; z < gob.get(i).getEsami().get(j).getDocenti().size(); z++){ %>
   									 	<a href=" <%=gob.get(i).getEsami().get(j).getDocenti().get(z).getIndirizzoPaginaWeb() %>">link docente <%=(z + 1) %></a><br>
   									  <%} %>
   									 ore di lezione <%=gob.get(i).getEsami().get(j).getOreLezione() %><br>
  									</div>
								</div>
       						</th>
        					<td><%=gob.get(i).getEsami().get(j).getCFU()%></td>
        					<td>
        						<input type="checkbox" class="form-check-input filled-in" id="" disabled checked>
        					</td>
      					</tr>
      					</form>
	     			<%} %>
	     		</tbody>
	     	</table>
	     </div>
	     
    		<%} %>
    		<%if(tri == 0){if(gop.get(i).getAnno()== anno){ %>
    			<%=anno+"° anno opzionale CFU massimi selezionabili: "+ gop.get(i).getTotCFU() %>
    			
    			<div class="table-wrapper-scroll-y">
	   				<table class="table table-bordered table-striped">
						<thead>
      						<tr>
				        		<th scope="col">Nome esame</th><th scope="col">CFU</th><th scope="col">Selezionato</th>
      						</tr>
    					</thead>
    				<tbody>
	   					<% for(int j = 0; j < gop.get(i).getEsami().size(); j++){ %>
    					  <tr>
    					  <form action="selectionOfferta" method = "post">
    					  <input type="hidden" name="gruppoopz" value="<%=i%>">
    					  <input type="hidden" name="esame" value="<%=gop.get(i).getEsami().get(j).getCodiceEsame()%>">
        					<th scope="row"><a  data-toggle="collapse" href="#collapseExample<%=gop.get(i).getEsami().get(j).getCodiceEsame() %>" role="button" aria-expanded="false" aria-controls="collapseExample"><%=gop.get(i).getEsami().get(j).getNome()%></a>
        						<div class="collapse" id="collapseExample<%=gop.get(i).getEsami().get(j).getCodiceEsame()%>">
 			 						<div class="card card-body">
   									  Descrizione <%=gop.get(i).getEsami().get(j).getDescrizione()%><br>
   									  <%for(int z = 0; z < gop.get(i).getEsami().get(j).getDocenti().size(); z++){ %>
   									 	<a href=" <%=gop.get(i).getEsami().get(j).getDocenti().get(z).getIndirizzoPaginaWeb() %>">link docente <%=(z + 1) %></a><br>
   									  <%} %>
   									 ore di lezione <%=gop.get(i).getEsami().get(j).getOreLezione() %><br>
  									</div>
								</div>
       						</th>
        					<td><%=gop.get(i).getEsami().get(j).getCFU()%></td>
        					<td>
        					<input type="hidden" name="metodo" value="<%=gop.get(i).getEsami().get(j).getCodiceEsame()%>">
        						<input type="checkbox" class="form-check-input filled-in" name="check<%=gop.get(i).getEsami().get(j).getCodiceEsame()%>" onChange="this.form.submit()">		
        					</td>
      					</tr>
      					</form>
	     			<%} %>
	     		</tbody>
	     	</table>
	     </div>
	     
    		<%}} %>
    	<%} %>
    <%} %>    
    <%if(gop.get(0).getAnno()== 3 && tri == 3){ %>
    			<%="3° anno opzionale CFU massimi selezionabili: "+ gop.get(0).getTotCFU() %>
    			<div class="table-wrapper-scroll-y">
	   				<table class="table table-bordered table-striped">
						<thead>
      						<tr>
				        		<th scope="col">Nome esame</th><th scope="col">CFU</th><th scope="col">Selezionato</th>
      						</tr>
    					</thead>
    				<tbody>
	   					<% for(int j = 0; j < gop.get(0).getEsami().size(); j++){ %>
    					  <tr>
    					  <form action="selectionOfferta" method = "post">
    					  <input type="hidden" name="gruppoopz" value="<%=2%>">
    					  <input type="hidden" name="esame" value="<%=gop.get(0).getEsami().get(j).getCodiceEsame()%>">
        					<th scope="row"><a  data-toggle="collapse" href="#collapseExample<%=gop.get(0).getEsami().get(j).getCodiceEsame() %>" role="button" aria-expanded="false" aria-controls="collapseExample"><%=gop.get(0).getEsami().get(j).getNome()%></a>
        						<div class="collapse" id="collapseExample<%=gop.get(0).getEsami().get(j).getCodiceEsame()%>">
 			 						<div class="card card-body">
   									  Descrizione <%=gop.get(0).getEsami().get(j).getDescrizione()%><br>
   									  <%for(int z = 0; z < gop.get(0).getEsami().get(j).getDocenti().size(); z++){ %>
   									 	<a href=" <%=gop.get(0).getEsami().get(j).getDocenti().get(z).getIndirizzoPaginaWeb() %>">link docente <%=(z + 1) %></a><br>
   									  <%} %>
   									 ore di lezione <%=gop.get(0).getEsami().get(j).getOreLezione() %><br>
  									</div>
								</div>
       						</th>
        					<td><%=gop.get(0).getEsami().get(j).getCFU()%></td>
        					<td>
        						<input type="hidden" name="metodo" value="<%=gop.get(0).getEsami().get(j).getCodiceEsame()%>">
       							<input type="checkbox" class="form-check-input filled-in" name="check<%=gop.get(0).getEsami().get(j).getCodiceEsame()%>" onChange="this.form.submit()">
        					</td>
      					</tr>
      					</form>
	     			<%} %>
	     			</tbody>
	     			</table>
	     			</div>
	     			
	     		<%} %>
    </div>
    <%} 
    %>
    <br>
	<form action="selectionOfferta" method="Post">
		<input type="hidden" name="metodo" value="fine">
   		<button name="fine" id="laureaScelta" class="btn btn-default btn-responsive center-block">Fine</button>
  	</form>
  </body>
</html>