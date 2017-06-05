package com.bioshare.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bioshare.model.Product;
import com.bioshare.model.ProductCategory;
import com.bioshare.model.Eshop;
import com.bioshare.modeldao.AbstractDAOFactory;
import com.bioshare.modeldao.MySqlDAOFactory;

public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
    	}
    
    
    public ProductController() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        	Product product = new Product();
            product.setTitle(request.getParameter("announce_label"));
            product.setDescription(request.getParameter("announce_text"));
            product.setType(Integer.parseInt(request.getParameter("products")));
            product.setPrice(Integer.parseInt(request.getParameter("announce_price")));
            product.setQuantity(Integer.parseInt(request.getParameter("announce_quantity")));
            product.setDateFrom(request.getParameter("announce_date_from"));
            product.setDateTo(request.getParameter("announce_date_to"));
            
        	Eshop eshop = new Eshop();
        	String result = null;
			try {
				result = eshop.insertNewProduct(product);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		request.setAttribute("message", result);
        RequestDispatcher view = request.getRequestDispatcher("Home.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Eshop eshop = new Eshop();
    	ArrayList <ProductCategory> categories = null;
			try {
				categories = eshop.getProductCategoriesList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		request.setAttribute("categories", categories);
        RequestDispatcher view = request.getRequestDispatcher("InsertForm.jsp");
        view.forward(request, response);
    }


}