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

import app.dao.Dao;
import app.model.Candidate;
import app.security.SecurityUtils;

@WebServlet(name = "LoginApp", urlPatterns = { "/login" })
public class LoginApp extends HttpServlet {

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
        //return values as string.
        String uname = request.getParameter("uname");
        String password = request.getParameter("paswd");

        //Read reference values from DB
        String salt = dao.getUserSalt(uname);
        String hashpw = dao.getUserpasswordHash(uname);

        
        if (SecurityUtils.isPasswordOk(hashpw, password, salt)) {
//         HttpSession session=request.getSession();
//         Candidate cand=dao.readCandidatesInfo(uname);
//         dao.close();
//       	 session.setAttribute("LoggedUser", cand);
//       	 System.out.println("Session: "+ request.getSession(false));
////       	 session  expires in 30 mins
//       	 session.setMaxInactiveInterval(30*60);
//       	 Cookie cookie = new Cookie("uname", uname);
//       	 response.addCookie(cookie);
//       	 String encodedURL = response.encodeRedirectURL("/showInfo?uname="+ uname);
//			 response.sendRedirect(encodedURL);
////          System.out.println("ok");
          String data = uname;
          HttpSession session = request.getSession();
          Candidate cand=dao.readCandidatesInfo(data);
          dao.close();
          session.setAttribute("LoggedUser", cand);
          System.out.println("Session: "+ request.getSession(false));
          session.setMaxInactiveInterval(30*60);
          Cookie cookie = new Cookie("LoggedUser", data);
          cookie.setMaxAge(30*60);
          response.addCookie(cookie);
          String encodedURL = response.encodeRedirectURL("/showInfo?uname="+ data);
			response.sendRedirect(encodedURL);
//          response.sendRedirect("/showInfo?uname"+data);

//            RequestDispatcher rd=request.getRequestDispatcher("./jsp/adminShowAllCand.jsp");
//          rd.include(request,  response);
      } else {
    	  dao.close();
          RequestDispatcher rd = getServletContext().getRequestDispatcher("/LogInWUP.html");
          PrintWriter out= response.getWriter();
//          out.println("<font color=red>Either user name or password is wrong.</font>");
          rd.include(request, response);

      }
  }
}

