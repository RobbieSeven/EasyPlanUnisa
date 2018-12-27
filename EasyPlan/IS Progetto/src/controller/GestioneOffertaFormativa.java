package controller;

import java.io.IOException;

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
			OffertaFormativaBeanDAO ofbd = new OffertaFormativaBeanDAO();
			OffertaFormativaBean ofb = new OffertaFormativaBean(nomeOfferta, null, false);
			ofbd.doSave(ofb);
		} else if(request.getParameter("metodo").equals("eliminaOfferta")) {
			String nomeOfferta = request.getParameter("nomeOfferta");
			OffertaFormativaBeanDAO ofbd = new OffertaFormativaBeanDAO();
			ofbd.doDelete(nomeOfferta);
		} else if(request.getParameter("metodo").equals("visibilita")) {
			String nomeOfferta = request.getParameter("nomeOfferta");
			String visibilita = request.getParameter("visibile");
			boolean visibile = false;
			if(visibilita.equals("si"))
				visibile = false;
			else
				visibile = true;
			OffertaFormativaBeanDAO ofbd = new OffertaFormativaBeanDAO();
			System.out.println("Visibile:" + visibile);
			OffertaFormativaBean ofb = new OffertaFormativaBean(nomeOfferta, null, visibile);
			System.out.println( ofbd.doSaveOrUpdate(ofb) );
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("GestioneOfferteFormative.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
