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

@WebServlet("/AjouteRDV")
public class AjoutRDVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static HibernatUtils hib ;
	Rendezvous rdv = new Rendezvous();
    public AjoutRDVServlet () {
        super();
        
    }
	   @Override
	public void init() throws ServletException {
		super.init();
		hib = new HibernatUtils();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		String doctor = request.getParameter("nomD");
		String patient = request.getParameter("nomP");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String email = request.getParameter("email");
		String description = request.getParameter("desc");
		
		rdv.setNomD(doctor);
		rdv.setNomP(patient);
		rdv.setDate(date);
		rdv.setTime(time);
		rdv.setEmail(email);
		rdv.setDescription(description);
		
		hib.AjouterRDV(rdv);
		
		List<Rendezvous> lists = hib.ListAllRdv();
		request.setAttribute("lists", lists);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/admin.jsp");
		dispatcher.forward(request, response);
		
	}

}
