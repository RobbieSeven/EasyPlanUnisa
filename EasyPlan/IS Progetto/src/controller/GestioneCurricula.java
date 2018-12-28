package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CurriculumBeanDAO;
import model.OffertaFormativaBeanDAO;

/**
 * Servlet implementation class GestioneCurricula
 */
@WebServlet("/GestioneCurricula")
public class GestioneCurricula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneCurricula() {
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("metodo").equals("eliminaCurricula")) {
			int id =Integer.parseInt(request.getParameter("idCurriculum"));
			removeCurriculum(id);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void removeCurriculum(int id)throws IOException {
		CurriculumBeanDAO cbd = new CurriculumBeanDAO();
		cbd.doDelete(id);
	}

}
