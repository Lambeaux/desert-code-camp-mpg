package dcc.mpg;

import static javax.ws.rs.core.Response.ok;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Set of services used for our app engine backend.
 */
@Path("/mpg")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MpgService {
    @GET
    @Path("/users")
    public Response getUsers() {
        return ok().entity("I am a jersey REST service").build();
    }
}
