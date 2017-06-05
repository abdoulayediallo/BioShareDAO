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

import com.bioshare.model.Eshop;
import com.bioshare.model.ProductCategory;

import com.bioshare.modeldao.AbstractDAOFactory;
import com.bioshare.modeldao.MySqlDAOFactory;

public class GetInsertForm extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //private static String SUCCESS = "/ok.jsp";
    //private static String FAILURE = "/failure.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
    	}
    
    
    public GetInsertForm() {
        super();
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