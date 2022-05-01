package services;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.Cookie;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import app.model.*;

@Path("/service")
public class Service {
	// comment
	@GET
	@Path("/readAllQuestions")
	public void readAllQuestions(@Context HttpServletRequest request, @Context HttpServletResponse response) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("electionMachine");
		EntityManager em = emf.createEntityManager();

		// When using default (RESOURCE-LOCAL) transaction type
		// Every transaction must begin and end.
		em.getTransaction().begin();
		List<Kysymykset> list = em.createQuery("select k from Kysymykset k").getResultList();
		em.getTransaction().commit();

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candQues.jsp");
		request.setAttribute("Kysymyslista", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.close();
	}

//	@GET
//	@Path("/addAnswer")
//	@Produces(MediaType.TEXT_HTML)
//	@Consumes(MediaType.TEXT_HTML)
//	public void addAnswer(@Context HttpServletRequest request, @Context HttpServletResponse response)
//			throws IOException, ServletException {
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		printForm(out);
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("electionMachine");
//		EntityManager em = emf.createEntityManager();
////		int candidate_id= Integer.parseInt(request.getParameter("candidate_id"));
////		int kysymys_id = Integer.parseInt(request.getParameter("kysymys_id"));
//		int vastaus=Integer.parseInt(request.getParameter("vastaus"));
//		String kommentti=request.getParameter("kommentti");
//		Vastaukset vastaukset = new Vastaukset(vastaus, kommentti);
//		int candidate= Integer.parseInt(request.getParameter("candidate_id"));
//		int kysymykset = Integer.parseInt(request.getParameter("kysymykset_id"));
////		String kid = request.getParameter("kid");
////		String lure = request.getParameter("lure");
//		Candidate ca = new Candidate();
//		ca.setCandidate_id(candidate);
//		vastaukset.setCandidate(ca);
//		Kysymykset ky = new Kysymykset();
//		ky.setKysymys_id(kysymykset);
//		vastaukset.setKysymykset(ky);
//		if (vastaukset.isOk()) {
//			em.getTransaction().begin();
//			em.persist(vastaukset);
//			em.getTransaction().commit();
//		}
//		em.close();
//		em = emf.createEntityManager();
//		List<Candidate> list = em.createQuery("select c from Candidate c").getResultList();
//		if (list != null) {
//			out.println("<h2>Kids</h2>");
//			for (Candidate x : list) {
//				out.println(x.getUname() + "<br>");
//			}
//		} else {
//			out.println("<h3>Candidates' list is empty</h3>");
//		}
//		List<Kysymykset> KysList = em.createQuery("select k from Kysymykset k").getResultList();
//		if (KysList != null) {
//			out.println("<h2>Lures</h2>");
//			for (Kysymykset x : KysList) {
//				out.println(x.getKysymys() + "<br>");
//			}
//		} else {
//			out.println("<h3>Questions' list is empty</h3>");
//		}
//		em.getTransaction().begin();
//		List<Vastaukset> VasList = em.createQuery("select v from Vastaukset v").getResultList();
//		em.getTransaction().commit();
//		if (VasList != null) {
//			out.println("<h2>Fish</h2>");
//			for (Vastaukset x : VasList) {
//				out.println(x.getVastaus() + " / " + x.getKommentti() + " / " + x.getCandidate().getCandidate_id() + " / "
//						+ x.getKysymykset().getKysymys_id() + "<br>");
//			}
//		} else {
//			out.println("<h3>Answers' list is empty</h3>");
//		}
//	}
//
//	private void printForm(PrintWriter out) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("electionMachine");
//		EntityManager em = emf.createEntityManager();
//		List<Candidate> canlist = em.createQuery("select c from Candidate c").getResultList();
//		List<Kysymykset> kyslist = em.createQuery("select k from Kysymykset k").getResultList();
//
//		out.println("<form action='addAnswer' mathod='post'</form>");
//		out.println("Answers: <input type='text' name='vastaus' value=''><br>");
//		out.println("Comments: <input type='text' name='kommentti' value=''><br>");
//		out.println("Kid: <select name='kid'>");
//		for (Candidate cand : canlist) {
//			out.println("<option value='" + cand.getCandidate_id() + "'>" + cand.getUname());
//		}
//		out.println("</select><br>");
//		out.println("Lure: <select name='lure'>");
//		for (Kysymykset kys : kyslist) {
//			out.println("<option value='" + kys.getKysymys_id() + "'>" + kys.getKysymys());
//		}
//		out.println("</select><br>");
//		out.println("<input type='submit' name='ok' value='OK'><br>");
//		out.println("</form>");
//
//	}

	@POST
	@Path("/addAnswer")
//	@Produces(MediaType.TEXT_HTML)
//	@Consumes(MediaType.TEXT_HTML)
	public void addAnswer(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("electionMachine");
		EntityManager em = emf.createEntityManager();

		try {
//			int candidate_id = Integer.parseInt(request.getParameter("candidate_id"));
//
//			int kysymys_id = Integer.parseInt(request.getParameter("kysymys_id"));

			int vastaus = Integer.parseInt(request.getParameter("vastaus"));
			
			String kommentti = request.getParameter("kommentti");

			Vastaukset v = new Vastaukset(vastaus, kommentti);

			em.getTransaction().begin();
			em.persist(v);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Kysymykset> list1 = em.createQuery("select k from Kysymykset k").getResultList();
		em.getTransaction().commit();

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candQuesAn.jsp");
		request.setAttribute("Kysymyslista", list1);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		em.close();

	}

//	@POST
//	@Path("/addAnswer")
//	public void addAnswers(@Context HttpServletRequest request, @Context HttpServletResponse response)
//			throws IOException {
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("electionMachine");
//		EntityManager em = emf.createEntityManager();
//		HttpSession session = request.getSession();
//		// String value = request.getParameter("candidate_id");
//		Candidate cand = (Candidate) session.getAttribute("LoggedUser");
////		List<Kysymykset> list = em.createQuery("select k from Kysymykset k").getResultList();
////		Kysymykset kys = (Kysymykset) request.getAttribute("Kysymyslista", list);
//
//		Kysymykset kys = (Kysymykset) request.getAttribute("Kysymyslista");
//		int candidate_id = cand.getCandidate_id();
//		int kysymys_id = kys.getKysymys_id();
//		try {
//			candidate_id = Integer.parseInt(request.getParameter("candidate_id"));
//		
//		Candidate c = new Candidate(candidate_id);
//	
//			kysymys_id = Integer.parseInt(request.getParameter("kysymys_id"));
//	
//		Kysymykset k = new Kysymykset(kysymys_id);
//
//		int vastaus =Integer.parseInt(request.getParameter("vastaus"));
//		String kommentti = request.getParameter("kommentti");
//		Vastaukset v = new Vastaukset(c, k, vastaus, kommentti);
//
//		em.getTransaction().begin();
//		em.persist(v);
//		em.getTransaction().commit();
//		em.close();
//		em = emf.createEntityManager();
//		em.getTransaction().begin();
//		List<Kysymykset> list1 = em.createQuery("select k from Kysymykset k").getResultList();
//		em.getTransaction().commit();
//
//		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candQuesAn.jsp");
//		request.setAttribute("Kysymyslista", list1);
//		try {
//			rd.forward(request, response);
//		} catch (ServletException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		em.close();
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//	}
//	private List<Vastaukset> readAllAnswers() {
//		// TODO Auto-generated method stub
//		return null;
//	}	

//	@GET
//	@Path("/testi")
//	public void Test(PrintWriter out, int vastaus) {
//		out.println("<h3> Vastaus "+vastaus+"</h3>");
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("electionMachine");
//		EntityManager em = emf.createEntityManager();
//
//		// When using default (RESOURCE-LOCAL) transaction type
//		// Every transaction must begin and end.
//		em.getTransaction().begin();
//		List<Kysymykset> list = em.createQuery("select k from Kysymykset k").setParameter(1, vastaus).getResultList();
//		em.getTransaction().commit();
//		em.close();
//		printKysymykset(out, list);
//
//	}
//
//	private void printKysymykset(PrintWriter out, List<Kysymykset> list) {
//		out.println("Vastaus");
//		
//	}
}