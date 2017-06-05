package com.bioshare.webservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bioshare.model.Product;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bioshare.modeldao.*;
import com.bioshare.model.Eshop;

@Path("/WebService") 

public class WebService{
	   Eshop dao = new Eshop();  
	   @GET 
	   @Path("/users") 
	   @Produces("application/json")
	   public Response Role(@QueryParam("login") String login, @QueryParam("pass") String pass) throws JSONException{
		    AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
		    String result = dao.getRole(login, pass);
		    JSONObject json = new JSONObject();
			json.put("role", result);
			return Response.status(200).entity(json.toString()).build();
	   } 
	   //Ok
	   @GET 
	   @Path("/produit") 
	   @Produces("application/json")
	   public Response ListProduit() throws SQLException{
		   AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
		   dao = new Eshop();
		   ArrayList<Product> p = dao.getProduct();
		   JSONObject jObject = new JSONObject();
		   try
		   {
		       JSONArray jArray = new JSONArray();
		       for (Product temp : p)
		       {

				   JSONObject json = new JSONObject();
		    	   json.put("idProduct", temp.getIdProduct());
		            json.put("Category", temp.getCategory());
		            json.put("Label", temp.getLabel());
		            jArray.put(json);
		       }
		       jObject.put("ProductList", jArray);
		   } catch (JSONException jse) {
			    jse.printStackTrace();;
			}
		   return Response.status(200).entity(jObject.toString()).build();
	   }
}
