package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.Dao;
import app.security.SecurityUtils;

@WebServlet(
		name = "RegisterCandidate",
		urlPatterns = {"/candidate"}
		)
public class RegisterCandidateApp extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		response.sendRedirect("AdminLogIn.html");
		
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		PrintWriter out=response.getWriter();
		try {
		Dao dao = new Dao();

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String ssn = request.getParameter("ssn");
		String party= request.getParameter("party");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String paswd = request.getParameter("paswd");

	
		if (
				fname == null || fname.isEmpty() ||
				lname == null || lname.isEmpty() ||
				ssn == null || ssn.isEmpty() ||
				party == null || party.isEmpty() ||
				uname == null || uname.isEmpty() ||
				request.getParameter("age") == null || request.getParameter("age").isEmpty() ||
				paswd == null || paswd.isEmpty() 
				) {
				
			RequestDispatcher rd=request.getRequestDispatcher("./jsp/candFillUp.jsp");
	        rd.include(request,  response);
	       
		 } else if (dao.checkCandUname(uname)){  //if user name is in use reload the form
			 RequestDispatcher rd=request.getRequestDispatcher("./jsp/unameTakenCan.jsp");
		        rd.include(request,  response); 
	    } else{
	    int age = Integer.parseInt(request.getParameter("age"));
		// Create salt and hashed pw
		String salt = SecurityUtils.getSalt();
		String hashpw = SecurityUtils.getPasswordHashed(paswd, salt);
		
		dao.addCandidate(fname, lname, ssn, party, email, uname, age, hashpw, salt);
		
		dao.close();
		RequestDispatcher rd=request.getRequestDispatcher("./jsp/candFilled.jsp");
        rd.include(request,  response);		
	}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
