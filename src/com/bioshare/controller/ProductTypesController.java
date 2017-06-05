package com.bioshare.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bioshare.model.Eshop;
import com.bioshare.model.ProductType;
import com.bioshare.modeldao.AbstractDAOFactory;
import com.bioshare.modeldao.MySqlDAOFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ProductTypesController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
    	}
    
    
    public ProductTypesController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int category = Integer.parseInt(request.getParameter("category"));
    	Eshop eshop = new Eshop();
    	ArrayList <ProductType> types = new ArrayList<>();
		
    	types = eshop.getProductTypesList(category);

    	JSONArray arr = new JSONArray();
			
    	for(ProductType type:types) {
    		
    		JSONObject obj = new JSONObject();
    		obj.put("product_id", type.getTypeId());
    		obj.put("product_label", type.getTypeLabel());
    		arr.add(obj);
    	}
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getOutputStream().print(arr.toJSONString());
			
    }


}