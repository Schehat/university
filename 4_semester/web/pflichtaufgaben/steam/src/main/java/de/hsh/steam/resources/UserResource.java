import java.util.List;

import de.hsh.steam.entities.User;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import de.hsh.steam.services.SteamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

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
            return Response.status(200).entity(users).build();
        }
    }
}