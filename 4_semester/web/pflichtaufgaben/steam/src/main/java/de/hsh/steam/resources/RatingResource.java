/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package de.hsh.steam.resources;

import de.hsh.steam.entities.Rating;
import de.hsh.steam.entities.Series;
import de.hsh.steam.services.SteamService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author lushaj
 */
@Path("users/{name}/ratings")
@XmlRootElement
public class RatingResource {

    SteamService steamService = SteamService.getInstance();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllRatings(@PathParam("name") String username) {
        ArrayList<Series> allSeriesOfUser = steamService.getAllSeriesOfUser(username);
        ArrayList<Rating> allRatingsOfUser = new ArrayList<>();
        for (Series serie : allSeriesOfUser) {
            allRatingsOfUser.add(this.steamService.getRating(serie.getTitle(), username));
        }

        if (allSeriesOfUser == null) {
            return Response.status(404).build();
        } else {
            return Response.ok().entity(allRatingsOfUser).build();
        }
    }

    @GET
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchSeries(@PathParam("name") String username, @QueryParam("genre") String genre,
            @QueryParam("streamingprovider") String streamingprovider, @QueryParam("score") String score) {
        List<Series> searchSeries = steamService.search(username, Utils.stringToGenre(genre),
                Utils.stringToProvider(streamingprovider), Utils.stringToScore(score));
        ArrayList<Rating> allRatingsOfUser = new ArrayList<>();
        for (Series serie : searchSeries) {
            if (score == null) {
                allRatingsOfUser.add(this.steamService.getRating(serie.getTitle(), username));
            } else {
                Rating tempRating = this.steamService.getRating(serie.getTitle(), username);
                if (tempRating.getScore() == Utils.stringToScore(score)) {
                    allRatingsOfUser.add(tempRating);
                }
            }
        }
        return Response.ok().entity(allRatingsOfUser).build();
    }
}
