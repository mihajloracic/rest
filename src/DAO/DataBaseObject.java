package DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import adapters.ToJson;

public class DataBaseObject {
	static final String DB_URL = "jdbc:mysql://localhost/testbaza";
    static final String USER = "root";
    static final String PASS = "admin";
    public JSONArray users() throws Exception{
    	try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        System.out.println("Creating statement...");
	        java.sql.Statement stmt = conn.createStatement();
	        String sql;
	        sql = "select username, email from user";
	        ResultSet rs = stmt.executeQuery(sql);
	        
			ToJson converter = new ToJson();
			JSONArray json = new JSONArray();
			
			json = converter.toJSONArray(rs);
			rs.close();
	        stmt.close();
	        conn.close();
	        return json;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		    System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		}
    	return null;
    }
}
