package REST.status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import DAO.DataBaseObject;
import adapters.ToJson;

@Path("/v1/status")
public class V1_status {
	int api_version = 1;
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Java Web Servise</p>";
	}
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		return "<p>Version:</p>" + Integer.toString(api_version);
	}
	@Path("/users")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnUsers() throws Exception{

		DataBaseObject database = new DataBaseObject();
		Response rb = Response.ok(database.users()).build();
		return rb;
	}
}
