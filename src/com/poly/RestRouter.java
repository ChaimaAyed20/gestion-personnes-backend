package com.poly;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;

@Path("/personnes")
public class RestRouter {
    private final PersonService service = new PersonServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        return service.getAllPersons();
    }

    @PUT
    @Path("/add/{nom}/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, String> addPerson(@PathParam("nom") String nom, @PathParam("age") int age) {
        Person p = new Person(nom, age);
        HashMap<String, String> response = new HashMap<>();
        response.put("state", service.addPerson(p) ? "ok" : "error");
        return response;
    }

    @DELETE
    @Path("/remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, String> deletePerson(@PathParam("id") long id) {
        HashMap<String, String> response = new HashMap<>();
        response.put("state", service.deletePerson(id) ? "ok" : "id doesnt exist");
        return response;
    }

    @GET
    @Path("/getid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("id") long id) {
        return service.getPerson(id);
    }

    @PUT
    @Path("/update/{id}/{nom}/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, String> updatePerson(@PathParam("id") long id,
                                               @PathParam("nom") String nom,
                                               @PathParam("age") int age) {
        Person p = new Person(nom, age);
        p.setId(id);
        HashMap<String, String> response = new HashMap<>();
        response.put("state", service.updatePerson(p) ? "ok" : "error");
        return response;
    }

    @GET
    @Path("/getnom/{nom}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByNom(@PathParam("nom") String nom) {
        return service.getPersonByName(nom);
    }
}