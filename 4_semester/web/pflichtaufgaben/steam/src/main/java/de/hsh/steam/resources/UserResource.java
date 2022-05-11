package de.hsh.steam.resources;

import java.util.List;
import de.hsh.steam.entities.User;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import de.hsh.steam.services.SteamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("users")
public class UserResource {

    @Inject
    SteamService steamService;
    @Inject
    SerializedSeriesRepository serializedSeriesRepository;

    @GET
    public Response listAllUsers() {
        List<User> users = serializedSeriesRepository.getAllUsers();
        if (users == null) {
            return Response.status(404).build();
        } else {
            return Response.ok().entity(users).build();
        }
    }

    @GET
    @Path("/{name}")
    public Response getUser(@PathParam("name")String name){
        User user = this.serializedSeriesRepository.getUserObject(name);
        if (user == null){
            return Response.status(404).build();
        } else {
            return Response.ok().entity(user).build();
        }
    }


    @POST
    public Response createUser(User user, @Context UriInfo uriInfo){        
        if( steamService.newUser(user.getUsername(), user.getPassword())){
            return Response.status(409).build();
        } else {
            this.serializedSeriesRepository.registerUser(user);
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(user.getUsername());
            user = this.serializedSeriesRepository.getUserObject(user.getUsername());
            return Response.created(uriBuilder.build()).entity(user).build();
        }        
    }

    @Path("/{name}/ratings")
    public RatingResource getRating(){
        return new RatingResource();
    }

}