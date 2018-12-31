package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CurriculumBean;
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
			System.out.println(id);
			removeCurriculum(id);
		}
		if(request.getParameter("metodo").equals("aggiuntaCurricula")) {
			String laurea=request.getParameter("laurea");
			int tipo;
			if(laurea.equals("triennale")){
		     	tipo=1;	
		     	}else {tipo=2;}
			String nome= request.getParameter("nomeCurricula");
			addCurriculum(nome,tipo);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("SelezionaCurriculaAm.jsp");
		String laurea=request.getParameter("laurea");
		request.setAttribute("laurea", laurea);
		rd.forward(request, response);
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
	
	public void addCurriculum(String nome,int IDCorsoDiLAurea)throws IOException {
		CurriculumBeanDAO cbd = new CurriculumBeanDAO();
		int id=cbd.doRetrieveByIDMaggiore();
		CurriculumBean cb= new CurriculumBean(nome,id,IDCorsoDiLAurea,null,null);
		cbd.doSave(cb);
	}

}
