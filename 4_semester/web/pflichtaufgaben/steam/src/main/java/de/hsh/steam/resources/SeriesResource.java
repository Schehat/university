package de.hsh.steam.resources;

import java.util.List;
import de.hsh.steam.entities.Series;
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

@Path("/series")
public class SeriesResource {

    @Inject
    SteamService steamService;
    @Inject
    SerializedSeriesRepository serializedSeriesRepository;

    @GET
    public Response listAllSerie() {
        List<Series> series = serializedSeriesRepository.getAllSeries();
        if (series == null) {
            return Response.status(404).build();
        } else {
            return Response.ok().entity(series).build();
        }
    }

    @GET
    @Path("/{substring}")
    public Response get(@PathParam("substring")String substring){
        List<Series> subseries = serializedSeriesRepository.getAllSerieWithTitle(substring);
        if (subseries == null){
            return Response.status(404).build();
        } else {
            return Response.ok().entity(subseries).build();
        }
    }

    @POST
    public Response createormodify(Series series, @Context UriInfo uriInfo){        
         Series newseries = serializedSeriesRepository.addOrModifySeries(series);
         UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
         uriBuilder.path(series.getTitle());
         return Response.created(uriBuilder.build()).entity(newseries).build();
     }



}