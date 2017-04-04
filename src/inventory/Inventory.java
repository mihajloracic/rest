package inventory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import DAO.DataBaseObject;
import adapters.ToJson;
@Path("/v1/inventory")
public class Inventory {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String returnAllUsers() throws Exception {
		
		String returnString = null;
		Response rb = null;	
		
		try {
			
			DataBaseObject dao = new DataBaseObject();
			
			ToJson converter = new ToJson();
			JSONArray json = new JSONArray();
			
			//json = converter.toJSONArray(dao.users());
			
			returnString = json.toString();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnString;
	}
}
