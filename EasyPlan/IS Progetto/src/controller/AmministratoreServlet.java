package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AmministratoreBean;
import model.AmministratoreBeanDAO;

/**
 * Servlet implementation class AmministratoreServlet
 */
@WebServlet("/AmministratoreServlet")
public class AmministratoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmministratoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  //Controlla se la stringa passata come parametro � nulla oppure vuota
    private boolean MissingData(String x)
    {
    	if (x == null || x.equals("")) 
    		return false;
    	else
    		return true;
    }
    //controlla se un campo rispetta un certo pattern
    private boolean validateField(String x, String pattern)
    {
    	//se la stringa x rispetta il pattern e non � nulla ritorna true
    	if (Pattern.matches(pattern, x) && MissingData(x))
    	    return true;
    	  else
    	    return false;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String password = request.getParameter("pwd");
		
		HttpSession session = request.getSession(true);
		synchronized (session)
        {
			if(MissingData(user) && validateField(user, "[0-9a-zA-Z\\S]+"))
			{
				if(MissingData(password) && validateField(password, "([A-Za-z0-9]){3,16}")) {
					AmministratoreBeanDAO amDAO= new AmministratoreBeanDAO(); 
					AmministratoreBean am= amDAO.doRetrieveByKey(user);
					
					if(am != null ) {	
						session.setAttribute("amministratore",user );
						session.setAttribute("password",password );
						
						RequestDispatcher view = request.getRequestDispatcher("GestioneOfferteFormative.jsp");
						view.forward(request, response);
						
					}
				}else {
					RequestDispatcher view = request.getRequestDispatcher("Login.html");
					view.forward(request, response);
				}
			}else {
				RequestDispatcher view = request.getRequestDispatcher("Login.html");
				view.forward(request, response);
			}
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
