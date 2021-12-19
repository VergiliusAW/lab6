package ru.ashcheulov.resource;

import ru.ashcheulov.pojo.Student;
import ru.ashcheulov.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/student-resource")
public class StudentResource {

    @Inject
    StudentService studentService;

    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent() {
        return Response.ok(studentService.initStudent()).build();
    }


    @Path("/post")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertStudent(Student student) {
        return Response.ok(studentService.insertStudent(student)).build();
    }

    @Path("/update")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(Student student) {
        return Response.ok(studentService.updateStudent(student)).build();
    }

    @Path("/delete")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteStudent(Student student) {
        return Response.ok(studentService.deleteStudent(student)).build();
    }

    @Path("/get-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents() {
        return Response.ok(studentService.getStudents()).build();
    }
}
