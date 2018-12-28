package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OffertaFormativaBean;
import model.OffertaFormativaBeanDAO;

@WebServlet("/GestioneOffertaFormativa")
public class GestioneOffertaFormativa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GestioneOffertaFormativa() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Aggiunta Offerta
		if(request.getParameter("metodo").equals("aggiungiOfferta")) {
			String nomeOfferta = request.getParameter("nomeOfferta");
			addOfferta(nomeOfferta);
		} else if(request.getParameter("metodo").equals("eliminaOfferta")) {
			String nomeOfferta = request.getParameter("nomeOfferta");
			removeOfferta(nomeOfferta);
		} else if(request.getParameter("metodo").equals("visibilita")) {
			String nomeOfferta = request.getParameter("nomeOfferta");
			String visibilita = request.getParameter("visibile");
			setVisibility(nomeOfferta, visibilita);
		} 
		
		RequestDispatcher rd = request.getRequestDispatcher("GestioneOfferteFormative.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//Controlla se la stringa passata come parametro è nulla oppure vuota
    private boolean MissingData(String x)
    {
    	if (x == null || x.equals("")) 
    		return false;
    	else
    		return true;
    }
    //controlla se un campo rispetta un certo pattern
    private boolean validateField(String x, String pattern)
    {
    	//se la stringa x rispetta il pattern e non è nulla ritorna true
    	if (Pattern.matches(pattern, x) && MissingData(x))
    	    return true;
    	  else
    	    return false;
    }
	
	/**
	 * 
	 * Il metodo aggiunge un'offerta formativa nel sistema.
	 * @param off nome dell'offerta formativa
	 * @throws IOException
	 */
	public void addOfferta(String nomeOff) throws IOException {
		if(MissingData(nomeOff)) {
				if(validateField(nomeOff, "[1-9]{1}[0-9]{3}/[0-9]{2}")) {
					OffertaFormativaBeanDAO ofbd = new OffertaFormativaBeanDAO();
					OffertaFormativaBean ofb = new OffertaFormativaBean(nomeOff, null, false);
					ofbd.doSave(ofb);
				}//GESTIRE ERRORI
		}//GESTIRE ERRORI
	}
	
	/**
	 * Il metodo elimina un'offerta formativa dal sistema.
	 * @param nomeOff
	 * @throws IOException
	 */
	public void removeOfferta(String nomeOff)throws IOException {
		OffertaFormativaBeanDAO ofbd = new OffertaFormativaBeanDAO();
		ofbd.doDelete(nomeOff);
	}
	
	/**
	 * Il metodo cambia la visibilità utente dell'offerta formativa
	 * @param nomeOff
	 * @param vis
	 */
	public void setVisibility(String nomeOff, String vis) {
		boolean visibile = false;
		if(vis.equals("si"))
			visibile = false;
		else
			visibile = true;
		OffertaFormativaBeanDAO ofbd = new OffertaFormativaBeanDAO();
		OffertaFormativaBean ofb = new OffertaFormativaBean(nomeOff, null, visibile);
	}
}
