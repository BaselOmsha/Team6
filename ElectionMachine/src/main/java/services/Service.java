package services;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import app.model.*;


@Path("/service")
public class Service {
	//comment
	@GET
	@Path("/readAllQuestions")
	public void readAllQuestions(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws IOException {

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
	}
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAllAnswers(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("electionMachine");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Fish f=em.find(Fish.class, fish.getId());
		if (f!=null) {
			em.merge(fish);//The actual update line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		//List<Fish> list=readFish();		
		//return list;
	}	
}












