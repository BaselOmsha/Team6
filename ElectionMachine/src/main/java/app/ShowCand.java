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
        name = "ShowInfo",
        urlPatterns = {"/showInfo"}
        )

public class ShowCand extends HttpServlet {
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
		
			
		
        // if sessions does not exist, create new one
        HttpSession session = request.getSession();
       // String value = request.getParameter("candidate_id");
        Candidate cand = (Candidate) session.getAttribute("LoggedUser");
       // value = (String) session.getAttribute("LoggedUser");
        if ( cand != null ) {
        try {
    
        int candidate_id = cand.getCandidate_id();
     //   Dao dao = new Dao();
       //Candidate cand = dao.readCandidatesInfo(candidate_id);

        session.setAttribute("readCandidatesInfo", cand);

        RequestDispatcher rd = request.getRequestDispatcher("jsp/showCand.jsp");
        rd.forward(request, response);
        
		} catch (Exception e) {
			e.printStackTrace();
		}
        }else {
			// Back to list
			response.sendRedirect("/CandLogIn.html");
			
		}

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        doGet(request, response);
    }

}
