package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestioneGruppoEsamiObbligatori
 */
@WebServlet("/GestioneGruppoEsamiObbligatori")
public class GestioneGruppoEsamiObbligatori extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneGruppoEsamiObbligatori() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("metodo").equals("deleteGruppo")) {
			// pulsante aggiungi un nuovo esame
		}else if(request.getParameter("metodo").equals("aggiungiEsame")) {
			
			
			
			
		}else if(request.getParameter("metodo").equals("aggiungiEsameEsistente")) {
			// pulsante modifica gruppo
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
