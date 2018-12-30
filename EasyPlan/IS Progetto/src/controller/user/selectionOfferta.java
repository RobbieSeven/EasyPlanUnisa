package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EsameBean;
import model.EsameBeanDAO;
import model.GruppoEsamiObbligatoriBean;
import model.GruppoEsamiOpzionaliBean;
import model.OffertaFormativaBean;

/**
 * Servlet implementation class selectionOfferta
 */
@WebServlet("/selectionOfferta")
public class selectionOfferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectionOfferta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("metodo").equals("fine")) {
			HttpSession session = request.getSession(true);
			synchronized (session)
	        {
				OffertaFormativaBean of = (OffertaFormativaBean)session.getAttribute("offertaFormativa");
				
	        	ArrayList<GruppoEsamiObbligatoriBean> obb = (ArrayList<GruppoEsamiObbligatoriBean>) session.getAttribute("obbligatori");
	        	ArrayList<GruppoEsamiOpzionaliBean> opz = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali");
	        	
	        	for(int i = 0; i < opz.size(); i++) {
	        		int cfu = opz.get(i).getTotCFU();
	        		int comp_cfu=0;
	        			if(opz.get(i).getEsami() != null) {
	        				for(int j = 0; j< opz.get(i).getEsami().size(); j++) {
	        					comp_cfu += opz.get(i).getEsami().get(j).getCFU();
	        				}
	        			}
	        			if(cfu >= comp_cfu) {
	        				 RequestDispatcher rd = request.getRequestDispatcher("View/viewUtente/FormulazionePiano.jsp");
	        				 request.setAttribute("offertaFormativa", of);
	        			     request.setAttribute("opzion", opz);
	        				 rd.forward(request, response);
	        			}
	        			comp_cfu = 0;
	        		}
	        	
	        	 RequestDispatcher rd = request.getRequestDispatcher("View/viewUtente/PianoDiStudi.jsp");
				 request.setAttribute("esamiOb", obb);
			     request.setAttribute("esamiOpz", opz);
				 rd.forward(request, response);
	        	
	        	}
	        	
	        	

		}
		else {
			int gruppo = Integer.parseInt(request.getParameter("gruppoopz"));
			int esame = Integer.parseInt(request.getParameter("esame"));
			
			EsameBeanDAO esB = new EsameBeanDAO();
			EsameBean cercato = esB.doRetrieveByKey(esame);
			
			ArrayList<EsameBean> opz1 = new ArrayList<EsameBean>();
			ArrayList<EsameBean> opz2 = new ArrayList<EsameBean>();
			ArrayList<EsameBean> opz3 = new ArrayList<EsameBean>();
			
			HttpSession session = request.getSession(true);
			OffertaFormativaBean of = null;
			ArrayList<GruppoEsamiOpzionaliBean> opz = null;
	        synchronized (session)
	        {
	        	of = (OffertaFormativaBean)session.getAttribute("offertaFormativa");
	        	ArrayList<GruppoEsamiObbligatoriBean> obb = (ArrayList<GruppoEsamiObbligatoriBean>) session.getAttribute("obbligatori");
	        	opz = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali");
	        	
	        	if(opz.get(0).getEsami() != null)
        			opz1 = opz.get(0).getEsami();
	        	
	        	if(opz.get(1).getEsami() != null)
        			opz2 = opz.get(1).getEsami();
	        	
	        	if(gruppo == 2 && opz.get(0).getEsami() != null)
        			opz3 = opz.get(0).getEsami();
	        	
	        	if(gruppo == 0 && !opz1.contains(cercato)) {
	        		opz1.add(cercato);
	        		opz.get(0).setEsami(opz1);
	        		
	        	}
	        	else if(gruppo == 1 && !opz1.contains(cercato)) {
	        		opz2.add(cercato);
	        		opz.get(1).setEsami(opz2);
	        	}
	        	else if(gruppo == 2 && !opz1.contains(cercato)) {
	        		opz3.add(cercato);
	        		opz.get(0).setEsami(opz3);
	        	}
	        	// rimuovono gli esami 
	        	else if(gruppo == 0 && opz1.contains(cercato)) {
	        		opz1.remove(cercato);
	        		opz.get(0).setEsami(opz1);
	        	}
	        	else if(gruppo == 1 && opz1.contains(cercato)) {
	        		opz2.remove(cercato);
	        		opz.get(1).setEsami(opz2);
	        	}
	        	else if(gruppo == 2 && opz1.contains(cercato)) {
	        		opz3.remove(cercato);
	        		opz.get(0).setEsami(opz3);
	        	}
	        	session.removeAttribute("obbligatori");
	        	session.setAttribute("obbligatori", obb);
	        	
	        	session.removeAttribute("opzionali");
	        	session.setAttribute("opzionali", opz);
	        	
	        }
	        
	        RequestDispatcher rd = request.getRequestDispatcher("FormulazionePiano.jsp");
	        request.setAttribute("offertaFormativa", of);
	        request.setAttribute("opzion", opz);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
