package services;

import java.io.*;

import java.util.*;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.Cookie;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import model.*;

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
	
	@GET
	@Path("/readAllAnswers")
	public void readAllAnswers(@Context HttpServletRequest request, @Context HttpServletResponse response) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("electionMachine");
		EntityManager em = emf.createEntityManager();

		// When using default (RESOURCE-LOCAL) transaction type
		// Every transaction must begin and end.
		em.getTransaction().begin();
		List<Vastaukset> list = em.createQuery("select v from Vastaukset v").getResultList();
		em.getTransaction().commit();

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candEditQues.jsp");
		request.setAttribute("Vastauslista", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.close();
	}



	@POST
	@Path("/addAnswer")
//	@Produces(MediaType.TEXT_HTML)
	@Consumes("application/x-www-form-urlencoded")
	public void addAnswer(MultivaluedMap<String, String> fp, @Context HttpServletRequest request,
			@Context HttpServletResponse response) throws IOException, ServletException {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("electionMachine");
		EntityManager em = emf.createEntityManager();


		try {
			
			for(int i=1; i < fp.keySet().size(); i++) {
				
				
				int vastaus = Integer.parseInt(fp.getFirst("vastaus"+i));
				String kommentti = fp.getFirst("kommentti"+i);
				
				int candidate_id = Integer.parseInt(fp.getFirst("candidate_id"));
				int kysymys_ID = Integer.parseInt(fp.getFirst("kysymys_ID"+i));
	//			 int kysymykset = Integer.parseInt(request.getParameter("kysymykset_id"));
	
				System.out.println("     " + kommentti + "    " + vastaus + "   " + candidate_id + "    " + kysymys_ID);
				
				Vastaukset vas = new Vastaukset(kommentti, vastaus, candidate_id, kysymys_ID);
	
				Candidate ca = new Candidate();
				ca.setCandidate_id(candidate_id);
				vas.setCandidate(ca);
	
				Kysymykset k = new Kysymykset();
				k.setKysymys_ID(kysymys_ID);
				vas.setKysymykset(k);
				
				ca=em.find(Candidate.class, candidate_id);
				k=em.find(Kysymykset.class, kysymys_ID);
				
				System.out.println("check 1");
				if (vas.isOk()) {
					em.getTransaction().begin();
					em.persist(vas);
					System.out.println("check 2");
					em.getTransaction().commit();
					System.out.println("check final");
				}
				
			}
			em.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	
	
	@PUT
	@Path("/editAnswer")
//	@Produces(MediaType.TEXT_HTML)
	@Consumes("application/x-www-form-urlencoded")
	public void editAnswer(MultivaluedMap<String, String> fp, @Context HttpServletRequest request,
			@Context HttpServletResponse response) throws IOException, ServletException {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("electionMachine");
		EntityManager em = emf.createEntityManager();


		try {
			
			for(int i=1; i < fp.keySet().size(); i++) {
				
				
				int vastaus = Integer.parseInt(fp.getFirst("vastaus"+i));
				String kommentti = fp.getFirst("kommentti"+i);
				
				int candidate_id = Integer.parseInt(fp.getFirst("candidate_id"));
				int kysymys_ID = Integer.parseInt(fp.getFirst("kysymys_ID"+i));

	
				System.out.println("     " + kommentti + "    " + vastaus + "   " + candidate_id + "    " + kysymys_ID);
				
				Vastaukset vas = new Vastaukset(kommentti, vastaus, candidate_id, kysymys_ID);
	
				Candidate ca = new Candidate();
				ca.setCandidate_id(candidate_id);
				vas.setCandidate(ca);
	
				Kysymykset k = new Kysymykset();
				k.setKysymys_ID(kysymys_ID);
				vas.setKysymykset(k);
				
				em.getTransaction().begin();
				ca=em.find(Candidate.class, candidate_id);
				k=em.find(Kysymykset.class, kysymys_ID);
				
				System.out.println("check 1");
				if (vas != null) {
					
					em.merge(vas);
					System.out.println("check 2");
					em.getTransaction().commit();
					System.out.println("check final");
				}
				
			}
			em.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	


}
	
	
	
