package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AdminLogoutApp", urlPatterns = { "/adminlogout" })
public class AdminLogoutApp extends HttpServlet {
	
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
//    	System.out.println("Session before incalidate: "+ request.getSession(false));
//    	
//    	 HttpSession session=request.getSession(false);  
//    	 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//    	 response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//    	 response.setHeader("Expires", "0"); // Proxies
//    	 String uname = request.getParameter("uname");
//    	 if(session != null){
//    		 session.getMaxInactiveInterval();
//    		 session.removeAttribute("uname");
//    		 request.getSession(false).invalidate();  
//             response.sendRedirect("/AdminLogIn.html");
//             System.out.println("Session after invalidate: "+ request.getSession(false));
//    	 } 
//    	 
//    	 if(uname != null){
//    		 session.getMaxInactiveInterval();
//    		 session.removeAttribute("uname");
//    		 request.getSession(false).invalidate();    
//             response.sendRedirect("/AdminLogIn.html");
//             System.out.println("Session after invalidate: "+ request.getSession(false));
//    	 } 
//         response.sendRedirect("/AdminLogIn.html");
    }


}
