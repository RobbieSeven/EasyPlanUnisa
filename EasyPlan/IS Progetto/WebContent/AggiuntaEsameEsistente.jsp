<%@page import="model.OffertaFormativaBean"%>
<%@page import="model.OffertaFormativaBeanDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList"
    pageEncoding="UTF-8"%>
    
    <%
     	/* Simulazione dati presi dal database
     	ArrayList<OffertaFormativaBean> offerte = new ArrayList<>();
    	OffertaFormativaBeanDAO dao = new OffertaFormativaBeanDAO();
    	offerte.addAll(dao.doRetriveByAll());*/
    	synchronized (session)
		{
			if(session.getAttribute("amministratore") == null && session.getAttribute("password") == null )
			{
				RequestDispatcher view = request.getRequestDispatcher("Login.html");
				view.forward(request, response);
		
			}
		}
    	
    	int codiceGruppo = Integer.parseInt(request.getParameter("codiceGruppo"));
    	String tipoGruppo = request.getParameter("tipoGruppo");
    	String laurea=request.getParameter("laurea");
    	String offerta= request.getParameter("offerta");
    	String curriculum= request.getParameter("curriculum");
    	int id= Integer.parseInt(request.getParameter("idCurriculum"));
    	
    	
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
			<!-- "Login amministratore" --><li><a href="Logout" style="color:#000000">Log out <span class="glyphicon glyphicon-log-out"></span></a></li>
          </ul>
        </div>
      </div>
    </nav>
    
    <div class="col-md-5 col-centered"></div>
     <div class="col-md-2 col-centered">
	    <form action="GestioneEsamiServlet" method = "post">
	    <input type="hidden" name="codiceGruppo" value="<%=codiceGruppo%>"></input>
		<input type="hidden" name="metodo" value="aggiuntaEsameEsistente" /> 
		<input type="hidden" name="tipoGruppo" value="<%=tipoGruppo%>" />
		<input type="hidden" name="laurea" value="<%=laurea%>"></input>
		<input type="hidden" name="offerta" value="<%=offerta%>"></input>
		<input type="hidden" name="curriculum" value="<%=curriculum%>"></input>
		<input type="hidden" name="idCurriculum" value="<%=id%>"></input>
		   <!--  Seleziona Offerta Formativa<select nome="codiceOfferta" onChang>
		   							<option selected></option>
		   							<for(int i = 0; i < offerte.size(); i++){	
		   							%>
		    						<option value="<=offerte.get(i).getAnnoOffertaFormativa()%>">Offerta formativa <=offerte.get(i).getAnnoOffertaFormativa()%></option>
		    						<} %>
		    				   </select>
		   Seleziona Curriculum<select>
		    						<option></option>
		    				   </select>
		 	</br>Seleziona Gruppo esame<   Selselect>
		    						<option></option>
		    				   </select>
		 	</br>
		   Seleziona Esame<select>
		    					<option></option>
		    			  </select>
		 	</br> </br>-->
		 	<input type="text" name="codiceEsame" placeholder="Inserire codice esame"></input>
		 	</select>
		     <button class="btn btn-default btn-responsive center" style="margin-top:15px; margin-left: 30px;">Aggiungi esame</button>
	   </form>
    </div>
     <div class="col-md-5 col-centered"></div>
  </body>
  <!--  <script>
  function loadCurricula(){
  	var xhttp = new XMLHttpRequest();
  	xhttp.onreadystatechange = function(){
  		if(xhttp.readyState == 4 && xhttp.status == 200){
  			
  		}}
  	}
  }
  </script>-->
</html>