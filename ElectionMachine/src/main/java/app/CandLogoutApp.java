package app;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CandLogoutApp", urlPatterns = { "/candlogout" })
public class CandLogoutApp extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	response.setContentType("text/html");
    	Cookie cookie = null;
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie1 : cookies){
    		if(cookie1.getName().equals("Welcome")){
    			cookie = cookie1;
    			break;
    		}
    	}
    	}
    	if(cookie != null){
    		cookie.setMaxAge(0);
        	response.addCookie(cookie);
    	}
    	response.sendRedirect("/CandLogIn.html");
    }


}
