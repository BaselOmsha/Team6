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

	        Dao dao = new Dao();
	        ArrayList<Candidate> cand = dao.readAllCandidates();

	        session.setAttribute("ReadAllCandidates", cand);

	        RequestDispatcher rd = request.getRequestDispatcher("jsp/adminShowAllcand.jsp");
	        rd.forward(request, response);

	    }

	    @Override
	    public void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws IOException, ServletException {
	        doGet(request, response);
	    }

	}


