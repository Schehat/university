package de.hsh.steam.resources;

import java.util.ArrayList;

import de.hsh.steam.entities.Rating;
import de.hsh.steam.entities.Series;
import de.hsh.steam.entities.User;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import de.hsh.steam.services.SteamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/")
public class RatingResource {

    @Inject
    SteamService steamService;
    @Inject
    SerializedSeriesRepository serializedSeriesRepository;

    @GET
    public Response get(@PathParam("name") String username) {
        User user = this.serializedSeriesRepository.getUserObject(username);
        ArrayList<Rating> ratings = new ArrayList<>();
        for (Series s : serializedSeriesRepository.getAllSeries()) {
            Rating it = user.ratingOf(s);
            if (it != null) {
                ratings.add(it);
            }
        }
        return Response.ok().entity(ratings).build();
    }

    // @GET
    // @Path("/{ratingid}")
    // public Response get(@PathParam("username")String username,
    // @PathParam("ratingid")String rating ) {
    // User user = this.serializedSeriesRepository.getUserObject(username);
    // ArrayList<Rating> ratings = new ArrayList<>();
    // for (Series s : serializedSeriesRepository.getAllSeries()) {
    // Rating it = user.ratingOf(s);
    // if( it != null) {
    // ratings.add(it);
    // }
    // }
    // return Response.ok().entity(ratings).build();
    // }
}