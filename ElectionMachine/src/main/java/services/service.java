package services;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * URI to this service's Root Resource class is /laptopservice
 * The whole URL is http://some.server.someplace/rest/laptopservice
 * where some.server.someplace is the address to the server's web server (e.g. localhost:8080)
 * rest comes from the project web.xml file (element url-pattern)
 * laptopservice is the value of @Path below
 */
@Path("/service")
public class service {
	
	/*
	 * This method can be reached with a GET (annotation @GET) type request to the URL
	 * http://some.server.someplace/rest/laptopservice/servicename
	 * ...just adding value of the @Path to the previously mentioned address
	 * Method can return plain text (@Produces...) 
	 */
	@GET
	@Path("/servicename")
	@Produces(MediaType.TEXT_PLAIN)
	public String serviceName() {
		return "This is a Laptop service";
	}
	
	/*
	 * This method can be reached with a GET (annotation @GET) type request to the URL
	 * http://some.server.someplace/rest/laptopservice/getonelaptop/someid
	 * where someid must be an integer.
	 * The method receives the path parameter by {laptopid} and is cast
	 * to int in method's actual parameter list @PathParam("laptopid") int id.
	 * 
	 * The implementation of this method is just to get one string from the method getLaptop,
	 * which cannot be reached directly by http URL.
	 */
	@GET
	@Path("/getonelaptop/{laptopid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getOneLaptop(@PathParam("laptopid") int id) {
		String s=getLaptop(id);
		return s;
	}
	
	/*
	 * Just a method for testing purposes
	 */
	public String getLaptop(int id) {
		ArrayList list=new ArrayList<>();
		list.add("Honeywell");
		list.add("Acer Trix");
		list.add("IBM some model");
		list.add("Asus Barracuda");
		list.add("Commodore 64");
		
		return (String) list.get(id);
	}
}
