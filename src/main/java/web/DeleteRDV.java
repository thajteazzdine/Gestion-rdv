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


@WebServlet("/Delete")
public class DeleteRDV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static HibernatUtils hib ; 
    public DeleteRDV() {
        super();
       
    }
    
    @Override
    public void init() throws ServletException {
    	
    	hib= new HibernatUtils();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("action"));
		hib.SupRDV(Integer.parseInt(request.getParameter("action")));
		List<Rendezvous> lists = hib.ListAllRdv();
		request.setAttribute("lists", lists);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/admin.jsp");
	    dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
