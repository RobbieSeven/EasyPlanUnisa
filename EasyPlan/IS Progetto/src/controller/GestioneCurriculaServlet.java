package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CurriculumBean;
import model.CurriculumBeanDao;

/**
 * Servlet implementation class GestioneCurricula.
 */
@WebServlet("/GestioneCurricula")
public class GestioneCurriculaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Costruttore vuoto.
   * @see HttpServlet#HttpServlet()
   */
  public GestioneCurriculaServlet() {}

  /**
   * metodo doGet.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    // TODO Auto-generated method stub

    HttpSession session = request.getSession(true);
    synchronized (session) {
      if (session.getAttribute("amministratore") 
          ==  null && session.getAttribute("password") == null) {
        RequestDispatcher view = request.getRequestDispatcher("Login.html");
        view.forward(request, response);

      }
    }
    if (request.getParameter("metodo").equals("eliminaCurricula")) {
      int id = Integer.parseInt(request.getParameter("idCurriculum"));
      System.out.println(id);
      removeCurriculum(id);
    }
    if (request.getParameter("metodo").equals("aggiuntaCurricula")) {
      int idCorsoDiLaurea = Integer.parseInt(request.getParameter("idCorsoDiLaurea"));
      String nome = request.getParameter("nomeCurricula");
      addCurriculum(nome, idCorsoDiLaurea);
    }

    RequestDispatcher rd = request.getRequestDispatcher("SelezionaCurriculaAm.jsp");
    String laurea = request.getParameter("laurea");
    request.setAttribute("laurea", laurea);
    rd.forward(request, response);
  }

  /**
   * metodo doPost.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

  public void removeCurriculum(int id) throws IOException {
    CurriculumBeanDao cbd = new CurriculumBeanDao();
    cbd.doDelete(id);
  }

  /**
   * Questo metodo aggiunge un curricula.
   * @param nome nome del curricula
   * @param idCorsoDiLaurea id del corso di laurea
   * @throws IOException viene lanciata l'eccezione IOException
   */
  public void addCurriculum(String nome, int idCorsoDiLaurea)
      throws IOException {
    CurriculumBeanDao cbd = new CurriculumBeanDao();
    int id = cbd.doRetrieveByIdMaggiore();
    CurriculumBean cb = new CurriculumBean(nome, id, idCorsoDiLaurea, null, null);
    cbd.doSave(cb);
  }

}
