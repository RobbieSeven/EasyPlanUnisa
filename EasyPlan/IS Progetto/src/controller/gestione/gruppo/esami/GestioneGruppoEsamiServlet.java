package controller.gestione.gruppo.esami;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.gruppo.esami.obbligatori.GruppoEsamiObbligatoriBean;
import model.gruppo.esami.obbligatori.GruppoEsamiObbligatoriBeanDao;
import model.gruppo.esami.opzionali.GruppoEsamiOpzionaliBean;
import model.gruppo.esami.opzionali.GruppoEsamiOpzionaliBeanDao;

/**
 * Servlet implementation class GestioneGruppoEsamiOpzionali.
 */
@WebServlet("/GestioneGruppoEsami")
public class GestioneGruppoEsamiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Metodo Costruttore.
   * @see HttpServlet#HttpServlet()
   */
  public GestioneGruppoEsamiServlet() {
    super();
  }

  /**
   * Metodo doGet.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    HttpSession session = request.getSession(true);
    synchronized (session) {
      if (session.getAttribute("amministratore") == null 
          && session.getAttribute("password") == null) {
        RequestDispatcher view = request.getRequestDispatcher("Login.html");
        view.forward(request, response);
      }
    }
    if (request.getParameter("metodo").equals("aggiungiGruppo")) {
      String tipoGruppoScelto = request.getParameter("esame");
      int anno = Integer.parseInt(request.getParameter("anno"));
      int idCurriculum = Integer.parseInt(request.getParameter("idCurriculum"));
      
      if (tipoGruppoScelto.equals("obbligatorio")) {
        GruppoEsamiObbligatoriBeanDao dao = new GruppoEsamiObbligatoriBeanDao();
        GruppoEsamiObbligatoriBean nuovoGruppo = 
            new GruppoEsamiObbligatoriBean((dao.doRetrieveLastId() + 1), anno,idCurriculum, null);
        dao.doSave(nuovoGruppo);
      } else {
        int totCfu = Integer.parseInt(request.getParameter("quantity"));
        GruppoEsamiOpzionaliBeanDao dao = new GruppoEsamiOpzionaliBeanDao();
        GruppoEsamiOpzionaliBean nuovoGruppo = 
            new GruppoEsamiOpzionaliBean((dao.doRetrieveLastId() + 1), anno, 
                totCfu,idCurriculum, null);
        dao.doSave(nuovoGruppo);
      }

    } else if (request.getParameter("metodo").equals("deleteGruppo")) {
      int codiceGruppo = Integer.parseInt(request.getParameter("codiceGruppo"));
      String tipoGruppo = request.getParameter("tipoGruppo");
      if (tipoGruppo.equals("obbligatorio")) {
        GruppoEsamiObbligatoriBeanDao dao = new GruppoEsamiObbligatoriBeanDao();
        dao.doDelete(codiceGruppo);
      } else if (tipoGruppo.equals("opzionale")) {
        GruppoEsamiOpzionaliBeanDao dao = new GruppoEsamiOpzionaliBeanDao();
        dao.doDelete(codiceGruppo);
      }
    } else if (request.getParameter("metodo").equals("modificaGruppo")) {
      int codiceGruppo = Integer.parseInt(request.getParameter("codiceGruppo"));
      int numeroCfu = Integer.parseInt(request.getParameter("quantity"));
      GruppoEsamiOpzionaliBeanDao dao = new GruppoEsamiOpzionaliBeanDao();
      dao.updateTotCfu(codiceGruppo, numeroCfu);
    }
    request.setAttribute("laurea", request.getParameter("laurea"));
    request.setAttribute("offerta", request.getParameter("offerta"));
    request.setAttribute("curriculum", request.getParameter("curriculum"));
    request.setAttribute("idCurriculum", request.getParameter("idCurriculum"));
    RequestDispatcher rd = request.getRequestDispatcher("GestioneEsami.jsp");
    rd.forward(request, response);
  }

  /**
   * Metodo doPost.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
