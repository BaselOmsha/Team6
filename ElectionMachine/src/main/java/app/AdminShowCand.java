package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import app.model.Candidate;
import app.dao.Dao;

@WebServlet(
        name = "ShowAll",
        urlPatterns = {"/showAll"}
        )

public class AdminShowCand extends HttpServlet {
	
	@Override
	    public void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws IOException, ServletException {

	        // if sessions does not exist, create new one
	        HttpSession session = request.getSession();
//	        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//	        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//	        response.setHeader("Expires", "0"); // Proxies
//	        String uname = request.getParameter("uname");
//	        try {
	        Dao dao = new Dao();
	        ArrayList<Candidate> cand = dao.readAllCandidates();
	        
//		        if(session == null || uname == null ){
//		        	 response.sendRedirect("/AdminLogIn.html");
//		        } else  if (session != null) { 
		        	session.setAttribute("ReadAllCandidates", cand);
		        
		        RequestDispatcher rd = request.getRequestDispatcher("jsp/adminShowAllCand.jsp");
		        rd.forward(request, response);
//		        }
//	        }catch (Exception e) {
//				e.printStackTrace();
//				 
//	        }

	    }

	    @Override
	    public void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws IOException, ServletException {
	        doGet(request, response);
	    }

	}


