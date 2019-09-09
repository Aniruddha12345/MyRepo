package controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.LibraryModel;
import service.BookService;

@Path("/books")
public class BookController {

	@Inject
	BookService bookService;

	@Inject
	LibraryModel result;

	// get web service to show all the books
	@GET
	@Path("/getAllBooks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response books() {
		List<LibraryModel> getAllBooks = new ArrayList();
		getAllBooks = bookService.findAll();
		return Response.ok(getAllBooks).status(200).build();
	}

	// post web service to add book
	@POST
	@Path("/addBooks")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveBooks(LibraryModel model) {
		result = bookService.save(model);
		return Response.ok(result).status(200).build();
	}

	// get web service to get book details by name
	@GET
	@Path("/getBookDetailsByName/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookDetailsByName(@PathParam("name") String name) {
		List<LibraryModel> getAllBooks = new ArrayList();
		getAllBooks = bookService.findByName(name);
		return Response.ok(getAllBooks).status(200).build();
	}

	// put web service to set issue_flag to 1
	@PUT
	@Path("/updateIssueFlag")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateIssueFlag(LibraryModel model) {
		model.setBk_issueflag(1);
		result = bookService.update(model);
		return Response.ok(result).status(200).build();
	}

	// delete web service to delete the book
	@DELETE
	@Path("/deleteBookById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteBook(@PathParam("id") Integer id) {
		bookService.delete(id);
		return Response.ok(result).status(200).build();
	}
}