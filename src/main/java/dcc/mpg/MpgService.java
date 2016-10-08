package dcc.mpg;

import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Set of services used for our app engine backend.
 */
@Path("/mpg")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MpgService {
    private static final String USER_KIND = "user";

    private Gson gson = new GsonBuilder().setPrettyPrinting()
            .create();

    private DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    @GET
    @Path("/users")
    public Response getUsers() {
        Query query = new Query(USER_KIND);
        List<Entity> results = datastoreService.prepare(query)
                .asList(FetchOptions.Builder.withDefaults());
        return ok().entity(gson.toJson(results))
                .build();
    }

    @POST
    @Path("/users/put/{userName}")
    public Response makeUser(@PathParam("userName") String userName) {
        if (userName != null && !userName.isEmpty()) {
            Key userKey = KeyFactory.createKey(USER_KIND, userName);
            try {
                datastoreService.get(userKey);
            } catch (EntityNotFoundException e) {
                Entity user = new Entity(userKey);
                datastoreService.put(user);
                return ok("User successfully added").build();
            }
            return status(Response.Status.BAD_REQUEST).entity("User already exists").build();
        }
        return status(Response.Status.BAD_REQUEST).entity("Invalid user name").build();
    }
}
