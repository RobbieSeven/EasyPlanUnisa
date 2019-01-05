package controller.gestioneEsami;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DocenteBean;
import model.DocenteBeanDAO;
import model.EsameBean;
import model.EsameBeanDAO;
import model.GruppoEsamiObbligatoriBeanDAO;
import model.GruppoEsamiOpzionaliBeanDAO;

@WebServlet("/GestioneEsamiServlet")
public class GestioneEsamiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestioneEsamiServlet() { 
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		synchronized (session)
		{
			if(session.getAttribute("amministratore") == null && session.getAttribute("password") == null )
			{
				RequestDispatcher view = request.getRequestDispatcher("Login.html");
				view.forward(request, response);
		
			}
		}
		
		if (request.getParameter("metodo").equals("aggiuntaNuovoEsame")) {
			int idGruppo = Integer.parseInt(request.getParameter("codiceGruppo"));
			int cfu = Integer.parseInt(request.getParameter("cfu"));
			int ore = Integer.parseInt(request.getParameter("ore"));
			String nomeEsame = request.getParameter("nomeEsame");
			String descrizioneEsame = request.getParameter("descrizione");
			String semestre = request.getParameter("semestre");

			String classe = request.getParameter("classeDocente");
			String nomeDocente = request.getParameter("nomeDocente");
			String cognomeDocente = request.getParameter("cognomeDocente");
			String urlDocente = request.getParameter("urlDocente");

			String tipoGruppo = request.getParameter("tipoGruppo");

			DocenteBeanDAO docenteDAO = new DocenteBeanDAO();
			int nuovoIdDocente = docenteDAO.doRetrieveLastID() + 1;
			EsameBeanDAO esameDAO = new EsameBeanDAO();
			int nuovoIdEsame = esameDAO.doRetrieveLastID() + 1;

			EsameBean nuovoEsame = new EsameBean(nuovoIdEsame, nomeEsame, cfu, descrizioneEsame, ore, semestre);
			esameDAO.doSave(nuovoEsame);

			DocenteBean nuovoDocente = new DocenteBean(nuovoIdDocente, nomeDocente, cognomeDocente, urlDocente, classe);
			docenteDAO.doSave(nuovoDocente, nuovoIdEsame);

			if (tipoGruppo.equals("obbligatorio")) {
				GruppoEsamiObbligatoriBeanDAO dao = new GruppoEsamiObbligatoriBeanDAO();
				dao.insertEsameInGruppo(idGruppo, nuovoIdEsame);
			} else if (tipoGruppo.equals("opzionale")) {
				GruppoEsamiOpzionaliBeanDAO dao = new GruppoEsamiOpzionaliBeanDAO();
				dao.insertEsameInGruppo(idGruppo, nuovoIdEsame);
			}
		} else if (request.getParameter("metodo").equals("cancellaEsame")) {
			int idGruppo = Integer.parseInt(request.getParameter("codiceGruppo"));
			int idEsame = Integer.parseInt(request.getParameter("codiceEsame"));
			String tipoGruppo = request.getParameter("tipoGruppo");

			if (tipoGruppo.equals("obbligatorio")) {
				GruppoEsamiObbligatoriBeanDAO dao = new GruppoEsamiObbligatoriBeanDAO();
				dao.deleteEsameInGruppo(idGruppo, idEsame);
			} else if (tipoGruppo.equals("opzionale")) {
				GruppoEsamiOpzionaliBeanDAO dao = new GruppoEsamiOpzionaliBeanDAO();
				dao.deleteEsameInGruppo(idGruppo, idEsame);
			}
		} else if (request.getParameter("metodo").equals("updateEsame")) {
			String nomeEsame = request.getParameter("nomeEsame");
			int cfu = Integer.parseInt(request.getParameter("insertCFU"));
			int ore = Integer.parseInt(request.getParameter("insertOre"));
			String descrizioneEsame = request.getParameter("descrizione");
			int codice = Integer.parseInt(request.getParameter("codiceEsame"));
			String semestre = request.getParameter("semestre");
			
			String gruppoIniziale = request.getParameter("gruppoIniziale");
			String tipoGruppo = request.getParameter("tipoGruppo");

			String sceltaAnno = request.getParameter("sceltaAnno");
			String[] parts = sceltaAnno.split(",");
			String gruppoScelto = parts[0];
			String tipoScelto = parts[1];

			// Cambiamento di gruppo
			if (!gruppoIniziale.equals(gruppoScelto) || !tipoScelto.equals(tipoGruppo)) {
				// Rimozione
				if (tipoGruppo.equals("opzionale")) {
					GruppoEsamiOpzionaliBeanDAO dao = new GruppoEsamiOpzionaliBeanDAO();
					dao.deleteEsame(Integer.parseInt(gruppoIniziale), codice);
				} else {
					GruppoEsamiObbligatoriBeanDAO dao = new GruppoEsamiObbligatoriBeanDAO();
					dao.deleteEsame(Integer.parseInt(gruppoIniziale), codice);
				}

				// Aggiunta
				if (tipoScelto.equals("opzionale")) {
					GruppoEsamiOpzionaliBeanDAO dao = new GruppoEsamiOpzionaliBeanDAO();
					dao.insertEsameInGruppo(Integer.parseInt(gruppoScelto), codice);
				} else {
					GruppoEsamiObbligatoriBeanDAO dao = new GruppoEsamiObbligatoriBeanDAO();
					dao.insertEsameInGruppo(Integer.parseInt(gruppoScelto), codice);
				}
			}

			DocenteBeanDAO dao = new DocenteBeanDAO();

			int size = Integer.parseInt(request.getParameter("sizeArray"));
			for (int i = 1; i <= size; i++) {
				DocenteBean db = new DocenteBean();
				db.setCodiceDocente(Integer.parseInt(request.getParameter("codiceDocente" + i)));
				db.setNome(request.getParameter("nomeProf" + i));
				db.setCognome(request.getParameter("cognomeDocente" + i));
				db.setIndirizzoPaginaWeb(request.getParameter("urlProf" + i));
				db.setInsegnamento(request.getParameter("classe" + i));
				dao.doSaveOrUpdate(db, codice);
			}

			
			EsameBeanDAO esameDAO = new EsameBeanDAO(); 
			EsameBean esame = new EsameBean(codice, nomeEsame, cfu, descrizioneEsame, ore, semestre);
			esameDAO.doSaveOrUpdate(esame);
		}
		else if (request.getParameter("metodo").equals("aggiuntaEsameEsistente")) {
			EsameBeanDAO dao = new EsameBeanDAO();
			EsameBean esame = dao.doRetrieveByKey(Integer.parseInt(request.getParameter("codiceEsame")));
			String tipoGruppo = request.getParameter("tipoGruppo");
			if(tipoGruppo.equals("obbligatorio")) {
				GruppoEsamiObbligatoriBeanDAO gruppoObDao = new GruppoEsamiObbligatoriBeanDAO();
				gruppoObDao.insertEsameInGruppo(Integer.parseInt(request.getParameter("codiceGruppo")), esame.getCodiceEsame());
			}
			else {
				GruppoEsamiOpzionaliBeanDAO gruppoObDao = new GruppoEsamiOpzionaliBeanDAO();
				gruppoObDao.insertEsameInGruppo(Integer.parseInt(request.getParameter("codiceGruppo")), esame.getCodiceEsame());
			}
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("GestioneEsami.jsp");
		request.setAttribute("laurea", request.getParameter("laurea"));
		request.setAttribute("offerta", request.getParameter("offerta"));
		request.setAttribute("curriculum", request.getParameter("curriculum"));
		request.setAttribute("idCurriculum", request.getParameter("idCurriculum"));
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
