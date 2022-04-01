package app;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.Dao;
import app.security.SecurityUtils;

@WebServlet(name = "LoginApp", urlPatterns = { "/login" })
public class LoginApp extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        response.sendRedirect("index.html");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Dao dao = new Dao();

        String uname = request.getParameter("uname");
        String password = request.getParameter("paswd");

        //Read reference values from DB
        String salt = dao.getUserSalt(uname);
        String hashpw = dao.getUserpasswordHash(uname);

        dao.close();
        if (SecurityUtils.isPasswordOk(hashpw, password, salt)) {
//        	response.sendRedirect("adminShowAllCand.jsp");
        	RequestDispatcher rd=request.getRequestDispatcher("./jsp/adminShowAllCand.jsp");
	        rd.include(request,  response);
        } else {
        	response.sendRedirect("AdminLogIn.html");
        }
    }

}
