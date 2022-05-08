package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.HibernatUtils;
import metier.Login;
import metier.Rendezvous;



@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static HibernatUtils hib ; 
	@Override
    public void init() throws ServletException {
    	
    	hib= new HibernatUtils();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login u1 = new Login();
		String user  = request.getParameter("user");
		String pass = request.getParameter("pass");
		u1.setNomUtilisateur(user);
		u1.setMdp(pass);
		List<Rendezvous> list = hib.getbyNameRDV(user);
		List<Rendezvous> lists = hib.ListAllRdv(); 
		
		if(hib.check(user, pass)){
			
		    HttpSession session = request.getSession();
			session.setAttribute("username", user);
			
			if (user.equals("admin")) {
				
				request.setAttribute("lists", lists);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/admin.jsp");
			    dispatcher.forward(request, response);
				
				
			}else {
				
				request.setAttribute("listrdv", list);
				request.setAttribute("model", u1);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/doctor.jsp");
			    dispatcher.forward(request, response);
		        hib.AfficherTous(list);
				
	
			}
			
		}else {
			   request.setAttribute("state", "Mot de passe ou nom d'utilisateur incorrect!");
			   RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
		       dispatcher.forward(request, response);
			   
		}
		
       
	    
	}	
	
}
