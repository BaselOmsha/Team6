package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
  * This Controller handles the admin logout
 * 
 * @author team6 (Nori, Jesse, Basil) 
 * version 0.3
 */
@WebServlet(name = "AdminLogoutApp", urlPatterns = { "/adminlogout" })
public class AdminLogoutApp extends HttpServlet {
	
	/**
	 *Requests cookies and sets the max age to 0 then invalidates sessions
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	response.setContentType("text/html");
    	
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("JSESSIONID")){
    			System.out.println("JSESSIONID="+cookie.getValue());
    		}
    		cookie.setMaxAge(0);
    		response.addCookie(cookie);
    	}
    	}
    	//invalidate the session if exists
    	HttpSession session = request.getSession(false);
    	System.out.println("User="+session.getAttribute("uname"));
    	if(session != null){
    		session.invalidate();
    	}
    	//no encoding because we have invalidated the session
    	response.sendRedirect("/AdminLogIn.html");

    }


}
