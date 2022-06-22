package de.hsh.loginservice;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author dunkel
 */
@Path("login")
public class LoginResource {

    @GET
    public Response login(@QueryParam("user") String user, 
                          @HeaderParam("pwd") String pwd) {

        System.out.println("user " + user + " tries to login with pwd " + pwd);
        
        // nur user root mit pwd 123 akzeptieren ;-)
        boolean valid = "root".equals(user) && "123".equals(pwd);

        if (valid) {
            System.out.println("! logged in successfully: " + user);
            return Response.status(Response.Status.OK)
                    .entity("user " + user + " logged in successfully ")
                    .build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("user unauthorized: " + user)
                    .build();
        }
    }
}


