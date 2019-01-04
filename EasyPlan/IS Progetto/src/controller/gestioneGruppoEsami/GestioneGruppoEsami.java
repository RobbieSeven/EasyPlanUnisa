package controller.gestioneGruppoEsami;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GruppoEsamiObbligatoriBean;
import model.GruppoEsamiObbligatoriBeanDAO;
import model.GruppoEsamiOpzionaliBean;
import model.GruppoEsamiOpzionaliBeanDAO;

/**
 * Servlet implementation class GestioneGruppoEsamiOpzionali
 */
@WebServlet("/GestioneGruppoEsami")
public class GestioneGruppoEsami extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneGruppoEsami() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if(request.getParameter("metodo").equals("aggiungiGruppo")) {
			String tipoGruppoScelto = request.getParameter("esame");
			int anno = Integer.parseInt(request.getParameter("anno"));
			int idCurriculum = Integer.parseInt(request.getParameter("idCurriculum"));
			if(tipoGruppoScelto.equals("obbligatorio")) {
				GruppoEsamiObbligatoriBeanDAO dao = new GruppoEsamiObbligatoriBeanDAO();
				GruppoEsamiObbligatoriBean nuovoGruppo = new GruppoEsamiObbligatoriBean((dao.doRetrieveLastID() + 1),anno, idCurriculum, null);
				dao.doSave(nuovoGruppo);
			}else {
				int totCFU = Integer.parseInt(request.getParameter("quantity"));
				GruppoEsamiOpzionaliBeanDAO dao = new GruppoEsamiOpzionaliBeanDAO();
				GruppoEsamiOpzionaliBean nuovoGruppo = new GruppoEsamiOpzionaliBean((dao.doRetrieveLastID() + 1), anno, totCFU, idCurriculum, null);
				dao.doSave(nuovoGruppo);
			}
		
		}else if(request.getParameter("metodo").equals("deleteGruppo")) { 
			int codiceGruppo = Integer.parseInt(request.getParameter("codiceGruppo"));
			String tipoGruppo = request.getParameter("tipoGruppo");
			if(tipoGruppo.equals("obbligatorio")) {
				GruppoEsamiObbligatoriBeanDAO dao = new GruppoEsamiObbligatoriBeanDAO();
				dao.doDelete(codiceGruppo);
			}
			else if(tipoGruppo.equals("opzionale")) {
				GruppoEsamiOpzionaliBeanDAO dao = new GruppoEsamiOpzionaliBeanDAO();
				dao.doDelete(codiceGruppo);
			}
		}else if(request.getParameter("metodo").equals("modificaGruppo")) { 
			int codiceGruppo = Integer.parseInt(request.getParameter("codiceGruppo"));
			int numeroCFU = Integer.parseInt(request.getParameter("quantity"));
			GruppoEsamiOpzionaliBeanDAO dao = new GruppoEsamiOpzionaliBeanDAO();
			dao.updateTotCFU(codiceGruppo, numeroCFU);
		}
		RequestDispatcher rd = request.getRequestDispatcher("GestioneEsami.jsp");
		request.setAttribute("laurea", request.getParameter("laurea"));
		request.setAttribute("offerta", request.getParameter("offerta"));
		request.setAttribute("curriculum", request.getParameter("curriculum"));
		request.setAttribute("idCurriculum", request.getParameter("idCurriculum"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
