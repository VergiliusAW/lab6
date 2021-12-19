package ru.ashcheulov.resource;

import ru.ashcheulov.pojo.Book;
import ru.ashcheulov.qualifiers.QBook;
import ru.ashcheulov.service.CRUDService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/book")
public class BookResource {

    @Inject
    @QBook
    CRUDService<Book> bookCRUDService;

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createTeacher(Book book) {
        return Response.ok(bookCRUDService.create(book)).build();
    }

    @GET
    @Path("/read/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response readBook(@PathParam("id") Long id) {
        return Response.ok(bookCRUDService.read(id)).build();
    }

    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateBook(Book book) {
        return Response.ok(bookCRUDService.update(book)).build();
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response removeBook(Book book) {
        return Response.ok(bookCRUDService.delete(book)).build();
    }
}
