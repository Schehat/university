package de.hsh.steam.resources;

import java.util.ArrayList;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import de.hsh.steam.services.SteamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import de.hsh.steam.entities.Series;
import de.hsh.steam.entities.Rating;

@Path("/")
public class RatingResource {

    @Inject
    SteamService steamService;
    @Inject
    SerializedSeriesRepository serializedSeriesRepository;

    @GET
    public Response getAllSeriesOfUser(@PathParam("user") String username) {
        ArrayList<Series> allSeriesOfUser = steamService.getAllSeriesOfUser(username);
        ArrayList<Rating> allRatingsOfUser = new ArrayList<>();
        for(Series serie : allSeriesOfUser){
            allRatingsOfUser.add(this.steamService.getRating(serie.getTitle(), username));
        }

        if (allSeriesOfUser == null) {
            return Response.status(404).build();
        } else {
            return Response.ok().entity(allRatingsOfUser).build();
        }
    }
    
    @GET
    @Path("/{seriesname}")
    public Response getUser(@PathParam("name")String username, @PathParam("seriesname") String seriesname){
        Rating rating = this.steamService.getRating(seriesname, username);
        if (rating == null){
            return Response.status(404).build();
        } else {
            return Response.ok().entity(rating).build();
        }
    }
    
}
