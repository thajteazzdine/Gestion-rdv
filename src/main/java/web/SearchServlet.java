package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.HibernatUtils;
import metier.Rendezvous;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HibernatUtils hib ; 
    
    public SearchServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	
    	hib= new HibernatUtils();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("idOrName");
		List<Rendezvous> lists = null;
		if (notString(nom)) {
			
			lists = hib.getbyidRDV(Integer.parseInt(nom));
			request.setAttribute("lists", lists);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/admin.jsp");
		    dispatcher.forward(request, response);
			
		}else if (nom.equals("")){
	
			lists = hib.ListAllRdv();
			request.setAttribute("lists", lists);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/admin.jsp");
		    dispatcher.forward(request, response);
			
		}else {
			lists = hib.getbyNameRDV(nom);
			hib.AfficherTous(lists);
			request.setAttribute("lists", lists);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/admin.jsp");
		    dispatcher.forward(request, response);
		}
		
		
		
	}
	
	public static boolean notString(String s) {
	
		try {
			Long.parseLong(s);
			return true;
			
		}catch(NumberFormatException e) {
			return false;
		}
		
	}

}
