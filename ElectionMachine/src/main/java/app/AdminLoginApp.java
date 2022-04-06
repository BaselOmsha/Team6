package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Candidate;
import app.dao.Dao;
import app.security.SecurityUtils;

@WebServlet(name = "AdminLoginApp", urlPatterns = { "/adminlogin" })

public class AdminLoginApp extends HttpServlet {

	 public void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws IOException, ServletException {
	        response.sendRedirect("index.html");

	    }

	    @Override
	    public void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws IOException, ServletException {
	        response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");

	        Dao dao = new Dao();

	        String uname = request.getParameter("uname");
	        String password = request.getParameter("paswd");

	        //Read reference values from DB
	        String salt = dao.getUserSalt1(uname);
	        String hashpw = dao.getUserpasswordHash1(uname);

	        
	        if (SecurityUtils.isPasswordOk(hashpw, password, salt)) {
//	        	System.out.println("ok");
	        	String data = uname;
	        	dao.close();
	    		Cookie cookie = new Cookie("Welcome", data);
	    		//setting cookie to expiry in 30 mins
				cookie.setMaxAge(30*60);
				response.addCookie(cookie);
	        	response.sendRedirect("/showAll");
	//        	RequestDispatcher rd=request.getRequestDispatcher("./jsp/adminShowAllCand.jsp");
//		        rd.include(request,  response);
	        } else {
	        	dao.close();
	        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminLogInWUP.html");
				PrintWriter out= response.getWriter();
//				out.println("<font color=red>Either user name or password is wrong.</font>");
				rd.include(request, response);
	        	
	        }
	    }

	}


