package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CorsoDiLaureaBean;
import model.CurriculumBean;
import model.OffertaFormativaBean;

/**
 * Servlet implementation class getEsamiOffertaFormativa
 */
@WebServlet("/getEsamiOffertaFormativa")
public class getEsamiOffertaFormativa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getEsamiOffertaFormativa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeOfferta = request.getParameter("nomeOfferta");
		int laurea = Integer.parseInt(request.getParameter("laurea"));
		String curricula = request.getParameter("curricula");
		
		OffertaFormativaBean of = new OffertaFormativaBean();
		ArrayList<CorsoDiLaureaBean> lau = new ArrayList<CorsoDiLaureaBean>();
		ArrayList<CurriculumBean> cur = new ArrayList<CurriculumBean>();
		ArrayList<CorsoDiLaureaBean> grob = new ArrayList<CorsoDiLaureaBean>();
		ArrayList<CorsoDiLaureaBean> grop = new ArrayList<CorsoDiLaureaBean>();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
