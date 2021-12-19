package ru.ashcheulov.resource;

import ru.ashcheulov.pojo.Teacher;
import ru.ashcheulov.qualifiers.QTeacher;
import ru.ashcheulov.service.CRUDService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/teacher")
public class TeacherResource {

    @Inject
    @QTeacher
    CRUDService<Teacher> teacherCRUDService;

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createTeacher(Teacher teacher) {
        return Response.ok(teacherCRUDService.create(teacher)).build();
    }

    @GET
    @Path("/read/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response readTeacher(@PathParam("id") Long id) {
        return Response.ok(teacherCRUDService.read(id)).build();
    }

    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateTeacher(Teacher teacher) {
        return Response.ok(teacherCRUDService.update(teacher)).build();
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response removeTeacher(Teacher teacher) {
        return Response.ok(teacherCRUDService.delete(teacher)).build();
    }
}
