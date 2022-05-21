/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package de.hsh.steam.resources;

import de.hsh.steam.entities.User;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import de.hsh.steam.services.SteamService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 * REST Web Service
 *
 * @author SAbde
 */
@Path("users")
@XmlRootElement
public class UserResource {

    SteamService steamService = SteamService.getInstance();
    SerializedSeriesRepository serializedSeriesRepository = SerializedSeriesRepository.getInstance();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response gettAllUsers() {
        List<User> users = serializedSeriesRepository.getAllUsers();
        if (users == null) {
            return Response.status(404).build();
        } else {
            return Response.ok().entity(users).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{name}")
    public Response getUser(@PathParam("name") String name) {
        User user = this.serializedSeriesRepository.getUserObject(name);
        if (user == null) {
            return Response.status(404).build();
        } else {
            return Response.ok().entity(user).build();
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createUser(User user, @Context UriInfo uriInfo) {

        boolean usernametaken = steamService.newUser(user.getUsername(), user.getPassword());

        if (usernametaken == false) {
            return Response.status(409).build();
        } else {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(user.getUsername());
            user = this.serializedSeriesRepository.getUserObject(user.getUsername());
            return Response.created(uriBuilder.build()).entity(user).build();
        }
    }
    
    @DELETE
    public Response deleteUser() {
        steamService.clear();
        return Response.status(200).entity(serializedSeriesRepository.getAllUsers()).build();
    }
}
