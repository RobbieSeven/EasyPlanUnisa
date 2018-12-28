package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CorsoDiLaureaBean;
import model.CorsoDiLaureaBeanDAO;
import model.OffertaFormativaBean;

/**
 * Servlet implementation class getCorsiDiLaureaServlet
 */
@WebServlet("/getCorsiDiLaureaServlet")
public class getCorsiDiLaureaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getCorsiDiLaureaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeOfferta = request.getParameter("nomeOfferta");
		CorsoDiLaureaBeanDAO cdLD = new CorsoDiLaureaBeanDAO();
		ArrayList<CorsoDiLaureaBean> cdL = cdLD.getCorsiLaureaOfferta(nomeOfferta);
		OffertaFormativaBean ofb = new OffertaFormativaBean(nomeOfferta, cdL, true);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/viewUtente/SelezionaLaurea.jsp");
		request.setAttribute("offertaFormativa", ofb);
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
