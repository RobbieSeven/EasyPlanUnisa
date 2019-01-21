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

import model.corso.di.laurea.CorsoDiLaureaBean;
import model.corso.di.laurea.CorsoDiLaureaBeanDao;
import model.curriculum.CurriculumBean;
import model.curriculum.CurriculumBeanDao;
import model.offerta.formativa.OffertaFormativaBean;

/**
 * Servlet implementation class getCurriculaFromLaureaOff.
 */
@WebServlet("/getCurriculaFromLaureaOff")
public class GetCurriculaFromLaureaOffServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Metodo costruttore.
   * @see HttpServlet#HttpServlet()
   */
  public GetCurriculaFromLaureaOffServlet() {
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
    String laurea = request.getParameter("laurea");

    CorsoDiLaureaBeanDao cdLd = new CorsoDiLaureaBeanDao();
    ArrayList<CorsoDiLaureaBean> cdL = new ArrayList<CorsoDiLaureaBean>();
    cdL.add(cdLd.doRetrieveByKey(Integer.parseInt(laurea)));

    CurriculumBeanDao crmD = new CurriculumBeanDao();
    ArrayList<CurriculumBean> crm = null;
    try {
      crm = crmD.doRetriveByCorsoDiLaureaOffertaFormativa(Integer.parseInt(laurea), nomeOfferta);
    } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    cdL.get(0).setCurricula(crm);
    OffertaFormativaBean ofb = new OffertaFormativaBean(nomeOfferta, cdL, true);

    RequestDispatcher rd = request.getRequestDispatcher("SelezionaCurricula.jsp");
    request.setAttribute("offertaFormativa", ofb);
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
