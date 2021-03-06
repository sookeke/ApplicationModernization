package org.pwte.example.resources;

import java.util.List;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.pwte.example.domain.Category;
import org.pwte.example.exception.CategoryDoesNotExist;
import org.pwte.example.service.ProductSearchService;
import org.pwte.example.service.ProductSearchServiceImpl;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Path("/jaxrs/Category")
public class CategoryResource {

	@Inject
	ProductSearchServiceImpl productSearch;
	
	public CategoryResource() throws NamingException {
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Category loadCategory(@PathParam(value="id") int categoryId) {
		System.out.println("/Category/id - Container: " + System.getenv("CONTAINER") + " - Open Liberty - org.pwte.example.resources.CategoryResource");
		try {
			return productSearch.loadCategory(categoryId);
		} catch (CategoryDoesNotExist e) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> loadTopLevelCategories() {
		System.out.println("/Category - Container: " + System.getenv("CONTAINER") + " - Open Liberty - org.pwte.example.resources.CategoryResource");
		
		List<Category> output = null;
		try {
			output = productSearch.getTopLevelCategories();
		}
		catch (Exception exception) {
			System.out.println("/Category - Exception " + exception + "Container: " + System.getenv("CONTAINER") + " - Open Liberty - org.pwte.example.resources.CategoryResource");
		}
		return output;
	}
}