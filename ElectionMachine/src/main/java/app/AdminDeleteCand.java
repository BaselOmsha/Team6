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

import app.model.Candidate;
import app.dao.Dao;

/**
 * This is a controller layer that handles the removing of candidates processes
 * received by the view layer (jsp), then calls function from dao then sends it
 * to the model layer for data processing , then sends it back to the controller and
 * finally to the view layer.
 * 
 * @author team6 (Nori, Jesse, Basil) version 0.3
 */
@WebServlet(name = "DeleteCand", urlPatterns = { "/deleteCand" })
public class AdminDeleteCand extends HttpServlet {
	/**
	 * This class gets the candidate info and show it to the user
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
//		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//		response.setHeader("Expires", "0"); // Proxies
		// returns the value of request parameter as a sString
		String idValue = request.getParameter("candidate_id");

		if (idValue != null) {
			try {
				int candidate_id = Integer.parseInt(idValue);

				Dao dao = new Dao();
				Candidate cand = dao.showCandInfo(candidate_id);
//				 if (session != null) {
//				session.setAttribute("candidate", cand);
//				session.setMaxInactiveInterval(30*60);
//				System.out.println("Session: "+ request.getSession());
				RequestDispatcher rd = request.getRequestDispatcher("jsp/adminDeleteForm.jsp");
				rd.forward(request, response);
//				 } if (session == null) {
//					 response.sendRedirect("/AdminLogIn.html"); 
//				 }
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("/showAll");

		}

	}

	/**
	 * Data is processed with the model layer (Candidate) the a function is called
	 * and used to delete a candidate then the user is taken back to the main admin page with an updated view
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// Create connection
		Dao dao = new Dao();
		Candidate cand = readCand(request);

		dao.adminDeleteCand(cand);

		dao.close();

		// Back to list after actions
		// RequestDispatcher rd = request.getRequestDispatcher("/showdata");
		// rd.forward(request, response);
		response.sendRedirect("/showAll");
	}

	/**
	 * @param request 
	 * @return returns the candidate info requested and processed by the model layer
	 */
	private Candidate readCand(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Candidate cand = new Candidate();
		cand.setCandidate_id(Integer.parseInt(request.getParameter("candidate_id")));
		cand.setFname(request.getParameter("fname"));
		cand.setLname(request.getParameter("lname"));
		cand.setSsn(request.getParameter("ssn"));
		cand.setParty(request.getParameter("party"));
		cand.setEmail(request.getParameter("email"));
		cand.setUname(request.getParameter("uname"));
		cand.setAge(Integer.parseInt(request.getParameter("age")));
		cand.setWhy_running(request.getParameter("question1"));
		cand.setWhat_things_do_you_want_to_represent(request.getParameter("question2"));
		cand.setProfession(request.getParameter("profession"));
		cand.setPaswd(request.getParameter("paswd"));
		return cand;
	}
}
