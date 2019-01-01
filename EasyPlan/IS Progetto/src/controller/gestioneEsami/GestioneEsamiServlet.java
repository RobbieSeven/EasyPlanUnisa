package controller.gestioneEsami;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DocenteBean;
import model.DocenteBeanDAO;
import model.EsameBean;
import model.EsameBeanDAO;
import model.GruppoEsamiObbligatoriBeanDAO;
import model.GruppoEsamiOpzionaliBean;
import model.GruppoEsamiOpzionaliBeanDAO;

@WebServlet("/GestioneEsamiServlet")
public class GestioneEsamiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GestioneEsamiServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("metodo").equals("aggiuntaNuovoEsame")) {
			int idGruppo = Integer.parseInt(request.getParameter("codiceGruppo"));
			int cfu = Integer.parseInt(request.getParameter("cfu"));
			int ore = Integer.parseInt(request.getParameter("ore"));
			String nomeEsame = request.getParameter("nomeEsame");
			String descrizioneEsame =  request.getParameter("descrizione");
			String semestre =  request.getParameter("semestre");
			
			String classe = request.getParameter("classeDocente");
			String nomeDocente =  request.getParameter("nomeDocente");
			String cognomeDocente =  request.getParameter("cognomeDocente");
			String urlDocente =  request.getParameter("urlDocente");
			
			String tipoGruppo = request.getParameter("tipoGruppo");

			DocenteBeanDAO docenteDAO = new DocenteBeanDAO();
			int nuovoIdDocente = docenteDAO.doRetrieveLastID() + 1;
			EsameBeanDAO esameDAO = new EsameBeanDAO();
			int nuovoIdEsame = esameDAO.doRetrieveLastID() + 1;
			
			EsameBean nuovoEsame = new EsameBean(nuovoIdEsame, nomeEsame, cfu, descrizioneEsame, ore, semestre);
			esameDAO.doSave(nuovoEsame);

			DocenteBean nuovoDocente = new DocenteBean(nuovoIdDocente, nomeDocente, cognomeDocente, urlDocente, classe);			
			docenteDAO.doSave(nuovoDocente,nuovoIdEsame);
			
			if(tipoGruppo.equals("obbligatorio")) {
				GruppoEsamiObbligatoriBeanDAO dao = new GruppoEsamiObbligatoriBeanDAO();
				dao.insertEsameInGruppo(idGruppo, nuovoIdEsame);
			}
			else if(tipoGruppo.equals("opzionale")) {
				GruppoEsamiOpzionaliBeanDAO dao = new GruppoEsamiOpzionaliBeanDAO();
				dao.insertEsameInGruppo(idGruppo, nuovoIdEsame);
			}
		}else if(request.getParameter("metodo").equals("cancellaEsame")) {
			int idGruppo = Integer.parseInt(request.getParameter("codiceGruppo"));
			int idEsame = Integer.parseInt(request.getParameter("codiceEsame"));
			String tipoGruppo = request.getParameter("tipoGruppo");
			
			if(tipoGruppo.equals("obbligatorio")) {
				GruppoEsamiObbligatoriBeanDAO dao = new GruppoEsamiObbligatoriBeanDAO();
				dao.deleteEsameInGruppo(idGruppo, idEsame);
			}
			/*else if(tipoGruppo.equals("opzionale")) {
				GruppoEsamiOpzionaliBeanDAO dao = new GruppoEsamiOpzionaliBeanDAO();
				dao.insertEsameInGruppo(idGruppo, nuovoIdEsame);*/
			
		}
		
	    RequestDispatcher rd = request.getRequestDispatcher("GestioneEsami.jsp");
	    request.setAttribute("laurea", request.getParameter("laurea"));
	    request.setAttribute("offerta", request.getParameter("offerta"));
	    request.setAttribute("curriculum", request.getParameter("curriculum"));
	    request.setAttribute("idCurriculum", request.getParameter("idCurriculum"));
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
