package Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserResource {

	@GET
	public Response changeEmail() {
		return Response.ok().build();
		
	}
	
	
	
}
