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
import model.CorsoDiLaureaBeanDAO;
import model.CurriculumBean;
import model.CurriculumBeanDAO;
import model.OffertaFormativaBean;

/**
 * Servlet implementation class getCurriculaFromLaureaOff
 */
@WebServlet("/getCurriculaFromLaureaOff")
public class GetCurriculaFromLaureaOffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCurriculaFromLaureaOffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeOfferta = request.getParameter("nomeOfferta");
		String laurea = request.getParameter("laurea");
		
		CorsoDiLaureaBeanDAO cdLD = new CorsoDiLaureaBeanDAO();
		ArrayList<CorsoDiLaureaBean> cdL = new ArrayList<CorsoDiLaureaBean>();
		cdL.add(cdLD.doRetrieveByKey(Integer.parseInt(laurea)));
		
		CurriculumBeanDAO crmD = new CurriculumBeanDAO();
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
