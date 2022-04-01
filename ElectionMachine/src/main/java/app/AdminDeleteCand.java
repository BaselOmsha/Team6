package app;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.Dao;
import app.Candidate;

@WebServlet(
		name = "DeleteCand",
		urlPatterns = {"/deleteCand"}
		)
public class AdminDeleteCand extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		String idValue = request.getParameter("candidate_id");
		
		if ( idValue != null ) {
			try {
				int id = Integer.parseInt(idValue);
				
				Dao dao = new Dao();
				Candidate cand = dao.showCandInfo(id);
				
				session.setAttribute("Candidate", cand);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/Remove.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("/showAll");
			
		}
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
	
		
		// Create connection
		Dao dao=new Dao();
		Candidate cand = readCand(request);
		
		dao.adminDeleteCand(cand);
		
		dao.close();
		
		// Back to list after actions
		//RequestDispatcher rd = request.getRequestDispatcher("/showdata");
		//rd.forward(request, response);
		response.sendRedirect("/showAll");
	}
	
	private Candidate readCand(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Candidate cand=new Candidate();
		cand.setCandidate_id(Integer.parseInt(request.getParameter("candidate_id")));
        cand.setFname(request.getParameter("fname"));
        cand.setLname(request.getParameter("lname"));
        cand.setSsn(request.getParameter("ssn"));
        cand.setParty(request.getParameter("party"));
        cand.setEmail(request.getParameter("email"));
        cand.setUname(request.getParameter("uname"));
        cand.setAge(Integer.parseInt(request.getParameter("age")));
        cand.setWhy_running(request.getParameter("Why_running"));
        cand.setWhat_things_Do_you_wnat_to_represent(request.getParameter("What_things_Do_you_wnat_to_represent"));
        cand.setProfession(request.getParameter("profession"));
        return cand;
	}
}

	

