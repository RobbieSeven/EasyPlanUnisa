package controller.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CorsoDiLaureaBean;
import model.CorsoDiLaureaBeanDao;
import model.CurriculumBean;
import model.CurriculumBeanDao;
import model.DocenteBeanDao;
import model.EsameBeanDao;
import model.GruppoEsamiObbligatoriBean;
import model.GruppoEsamiObbligatoriBeanDao;
import model.GruppoEsamiOpzionaliBean;
import model.GruppoEsamiOpzionaliBeanDao;
import model.OffertaFormativaBean;

/**
 * Servlet implementation class getEsamiOffertaFormativa.
 */
@WebServlet("/getEsamiOffertaFormativa")
public class GetEsamiOffertaFormativaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Metodo costruttore.
   * @see HttpServlet#HttpServlet()
   */
  public GetEsamiOffertaFormativaServlet() {
    super();
  }

  /**
   * Metodo doGet.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String nomeOfferta = request.getParameter("nomeOfferta");
    int laurea = Integer.parseInt(request.getParameter("laurea"));
    int curricula = Integer.parseInt(request.getParameter("curricula"));

    /* variabili d'istanza */
    OffertaFormativaBean of = new OffertaFormativaBean();
    ArrayList<CorsoDiLaureaBean> lau = new ArrayList<CorsoDiLaureaBean>();
    ArrayList<CurriculumBean> cur = new ArrayList<CurriculumBean>();
    ArrayList<GruppoEsamiObbligatoriBean> grob = new ArrayList<GruppoEsamiObbligatoriBean>();
    ArrayList<GruppoEsamiOpzionaliBean> grop = new ArrayList<GruppoEsamiOpzionaliBean>();

    /*
     * dao per precaricarci la nostra bellissima e stupefacentissima offerta
     * formativa
     */
    CorsoDiLaureaBeanDao lauB = new CorsoDiLaureaBeanDao();
    CurriculumBeanDao curB = new CurriculumBeanDao();
    GruppoEsamiObbligatoriBeanDao grobB = new GruppoEsamiObbligatoriBeanDao();
    GruppoEsamiOpzionaliBeanDao gropB = new GruppoEsamiOpzionaliBeanDao();
    EsameBeanDao esameB = new EsameBeanDao();
    DocenteBeanDao docentiB = new DocenteBeanDao();

    /* this is a comment */
    of = new OffertaFormativaBean(nomeOfferta, null, true);
    // carico la laurea che ho selezionato precedentemente
    lau.add(lauB.doRetrieveByKey(laurea));
    of.setLauree(lau);

    try {
      // inserisco i curricula dell'offerta formativa nel corso di laurea
      cur.add(curB.doRetrieveByKey(curricula));
      lau.get(0).setCurricula(cur);

      System.out.println(cur.get(0).getNomeCurriculum());
      // inserisco i gruppi di esami nei curricula dell' offerta formativa
      grob = grobB.doRetriveGruppoEsamiObbByOfferta(
          nomeOfferta, laurea, cur.get(0).getNomeCurriculum());
      grop = gropB.doRetriveGruppoEsamiOpzByOfferta(
          nomeOfferta, laurea, cur.get(0).getNomeCurriculum());

      cur.get(0).setGruppi_obbligatori(grob);
      cur.get(0).setGruppi_opzionali(grop);

      // inserisco nei gruppi di esami gli esami dell'offerta formativa
      for (int i = 0; i < grob.size(); i++) {
        grob.get(i).setEsami(esameB.doRetriveEsamiOffertaFormativaObb(nomeOfferta, laurea,
            cur.get(0).getNomeCurriculum(), grob.get(i).getCodiceGeOb()));
      }

      for (int y = 0; y < grop.size(); y++) {
        grop.get(y).setEsami(esameB.doRetriveEsamiOffertaFormativaOpz(nomeOfferta, laurea,
            cur.get(0).getNomeCurriculum(), grop.get(y).getCodiceGeOp()));
      }

      // carico per gli esami i corrispettivi docenti prima gli obligatori e poi gli
      // opzionali
      for (int j = 0; j < grob.size(); j++) {
        for (int d = 0; d < grob.get(j).getEsami().size(); d++) {
          grob.get(j).getEsami().get(d).setDocenti(docentiB.doRetrieveDocEsameObb(
              nomeOfferta, laurea,cur.get(0).getNomeCurriculum(), 
              grob.get(j).getCodiceGeOb(), grob.get(j).getEsami().get(d).getNome()));
        }
      }

      for (int z = 0; z < grop.size(); z++) {
        for (int d1 = 0; d1 < grop.get(z).getEsami().size(); d1++) {
          grop.get(z).getEsami().get(d1).setDocenti(docentiB.doRetrieveDocEsameOpz(
              nomeOfferta, laurea,cur.get(0).getNomeCurriculum(),
              grop.get(z).getCodiceGeOp(), grop.get(z).getEsami().get(d1).getNome()));
        }
      }

    } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    RequestDispatcher rd = request.getRequestDispatcher("FormulazionePiano.jsp");
    request.setAttribute("offertaFormativa", of);
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
