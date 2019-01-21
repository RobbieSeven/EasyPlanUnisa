package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.corso.di.laurea.CorsoDiLaureaBean;
import model.corso.di.laurea.CorsoDiLaureaBeanDao;
import model.offerta.formativa.OffertaFormativaBean;

/**
 * Servlet implementation class getCorsiDiLaureaServlet.
 */
@WebServlet("/getCorsiDiLaureaServlet")
public class GetCorsiDiLaureaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Metodo costruttore.
   * @see HttpServlet#HttpServlet()
   */
  public GetCorsiDiLaureaServlet() {
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
    CorsoDiLaureaBeanDao cdLd = new CorsoDiLaureaBeanDao();
    ArrayList<CorsoDiLaureaBean> cdL = cdLd.getCorsiLaureaOfferta(nomeOfferta);
    OffertaFormativaBean ofb = new OffertaFormativaBean(nomeOfferta, cdL, true);

    RequestDispatcher rd = request.getRequestDispatcher("SelezionaLaurea.jsp");
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
