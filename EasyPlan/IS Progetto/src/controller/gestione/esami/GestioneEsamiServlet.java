package controller.gestione.esami;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.docente.DocenteBean;
import model.docente.DocenteBeanDao;
import model.esame.EsameBean;
import model.esame.EsameBeanDao;
import model.gruppo.esami.GruppoEsamiObbligatoriBeanDao;
import model.gruppo.esami.GruppoEsamiOpzionaliBeanDao;

@WebServlet("/GestioneEsamiServlet")
public class GestioneEsamiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public GestioneEsamiServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    HttpSession session = request.getSession(true);
    synchronized (session) {
      if (session.getAttribute("amministratore") == null 
          && session.getAttribute("password") == null) {
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

      DocenteBeanDao docenteDao = new DocenteBeanDao();
      int nuovoIdDocente = docenteDao.doRetrieveLastId() + 1;
      EsameBeanDao esameDao = new EsameBeanDao();
      int nuovoIdEsame = esameDao.doRetrieveLastId() + 1;

      EsameBean nuovoEsame = 
          new EsameBean(nuovoIdEsame, nomeEsame, cfu, descrizioneEsame, ore, semestre);
      esameDao.doSave(nuovoEsame);

      DocenteBean nuovoDocente = 
          new DocenteBean(nuovoIdDocente, nomeDocente, cognomeDocente, urlDocente, classe);
      docenteDao.doSave(nuovoDocente, nuovoIdEsame);

      if (tipoGruppo.equals("obbligatorio")) {
        GruppoEsamiObbligatoriBeanDao dao = new GruppoEsamiObbligatoriBeanDao();
        dao.insertEsameInGruppo(idGruppo, nuovoIdEsame);
      } else if (tipoGruppo.equals("opzionale")) {
        GruppoEsamiOpzionaliBeanDao dao = new GruppoEsamiOpzionaliBeanDao();
        dao.insertEsameInGruppo(idGruppo, nuovoIdEsame);
      }
    } else if (request.getParameter("metodo").equals("cancellaEsame")) {
      int idGruppo = Integer.parseInt(request.getParameter("codiceGruppo"));
      int idEsame = Integer.parseInt(request.getParameter("codiceEsame"));
      String tipoGruppo = request.getParameter("tipoGruppo");

      if (tipoGruppo.equals("obbligatorio")) {
        GruppoEsamiObbligatoriBeanDao dao = new GruppoEsamiObbligatoriBeanDao();
        dao.deleteEsameInGruppo(idGruppo, idEsame);
      } else if (tipoGruppo.equals("opzionale")) {
        GruppoEsamiOpzionaliBeanDao dao = new GruppoEsamiOpzionaliBeanDao();
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
          GruppoEsamiOpzionaliBeanDao dao = new GruppoEsamiOpzionaliBeanDao();
          dao.deleteEsame(Integer.parseInt(gruppoIniziale), codice);
        } else {
          GruppoEsamiObbligatoriBeanDao dao = new GruppoEsamiObbligatoriBeanDao();
          dao.deleteEsame(Integer.parseInt(gruppoIniziale), codice);
        }

        // Aggiunta
        if (tipoScelto.equals("opzionale")) {
          GruppoEsamiOpzionaliBeanDao dao = new GruppoEsamiOpzionaliBeanDao();
          dao.insertEsameInGruppo(Integer.parseInt(gruppoScelto), codice);
        } else {
          GruppoEsamiObbligatoriBeanDao dao = new GruppoEsamiObbligatoriBeanDao();
          dao.insertEsameInGruppo(Integer.parseInt(gruppoScelto), codice);
        }
      }

      DocenteBeanDao dao = new DocenteBeanDao();

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

      EsameBeanDao esameDao = new EsameBeanDao();
      EsameBean esame = new EsameBean(codice, nomeEsame, cfu, descrizioneEsame, ore, semestre);
      esameDao.doSaveOrUpdate(esame);
    } else if (request.getParameter("metodo").equals("aggiuntaEsameEsistente")) {
      EsameBeanDao dao = new EsameBeanDao();
      EsameBean esame = dao.doRetrieveByKey(Integer.parseInt(request.getParameter("codiceEsame")));
      String tipoGruppo = request.getParameter("tipoGruppo");
      if (tipoGruppo.equals("obbligatorio")) {
        GruppoEsamiObbligatoriBeanDao gruppoObDao = new GruppoEsamiObbligatoriBeanDao();
        gruppoObDao.insertEsameInGruppo(
            Integer.parseInt(request.getParameter("codiceGruppo")), esame.getCodiceEsame());
      } else {
        GruppoEsamiOpzionaliBeanDao gruppoObDao = new GruppoEsamiOpzionaliBeanDao();
        gruppoObDao.insertEsameInGruppo(
            Integer.parseInt(request.getParameter("codiceGruppo")), esame.getCodiceEsame());
      }

    }

    request.setAttribute("laurea", request.getParameter("laurea"));
    request.setAttribute("offerta", request.getParameter("offerta")); 
    request.setAttribute("curriculum", request.getParameter("curriculum"));
    request.setAttribute("idCurriculum", request.getParameter("idCurriculum"));
    RequestDispatcher rd = request.getRequestDispatcher("GestioneEsami.jsp");
    rd.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

}
