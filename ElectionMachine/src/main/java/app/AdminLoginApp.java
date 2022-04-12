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
import javax.servlet.http.HttpSession;

import app.model.Candidate;
import app.dao.Dao;
import app.security.SecurityUtils;

/**
 * This Controller handles the admin login
 * 
 * @author team6 (Nori, Jesse, Basil) 
 * version 0.3
 *
 */
@WebServlet(name = "AdminLoginApp", urlPatterns = { "/adminlogin" })

public class AdminLoginApp extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.sendRedirect("index.html");

	}

	/**
	 * Uses the dao function to check for the user hashed password and salt based on
	 * their username. Then it creates a session and adds a cookie.
	 * If the user name and password are correct it directs the user to the admin page controller.
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		Dao dao = new Dao();

		String uname = request.getParameter("uname");
		String password = request.getParameter("paswd");

		// Read reference values from DB
		String salt = dao.getUserSalt1(uname);
		String hashpw = dao.getUserpasswordHash1(uname);

		if (SecurityUtils.isPasswordOk(hashpw, password, salt)) {
			HttpSession session = request.getSession();

			session.setAttribute("uname", "Admin");
			System.out.println("Session: " + request.getSession(false));
//	        	 session  expires in 30 mins
			session.setMaxInactiveInterval(30 * 60);
			Cookie cookie = new Cookie("uname", uname);
			response.addCookie(cookie);
			String encodedURL = response.encodeRedirectURL("/showAll?uname=" + uname);
			response.sendRedirect(encodedURL);

		} else {
			dao.close();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminLogInWUP.html");
			PrintWriter out = response.getWriter();
//				out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);

		}
	}

}
