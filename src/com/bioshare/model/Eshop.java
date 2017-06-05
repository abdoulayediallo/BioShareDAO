package com.bioshare.model;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bioshare.modeldao.AbstractDAOFactory;
import com.bioshare.modeldao.ProductDAO;
import com.bioshare.modeldao.UserDAO;

public class Eshop {
	
			public String insertNewProduct(Product product) throws SQLException {
			        
			        ProductDAO prodDAO = AbstractDAOFactory.getFactory().createProductDAO();
			        return prodDAO.insertNewProduct(product);
			}
			
			public ArrayList <ProductCategory> getProductCategoriesList() throws SQLException {
			    
			    ProductDAO prodDAO = AbstractDAOFactory.getFactory().createProductDAO();
			    return prodDAO.getProductCategoriesList();
			}
			
			public ArrayList <ProductType> getProductTypesList(int category) {
			    
			    ProductDAO prodDAO = AbstractDAOFactory.getFactory().createProductDAO();
			    return prodDAO.getProductTypesList(category);
			}
			
			public String getRole(String login, String pass) {
			    UserDAO userDAO = AbstractDAOFactory.getFactory().getRoleDAO();
			    return userDAO.getRole(login, pass);
			}
			
			public ArrayList <Product> getProduct() throws SQLException {
			    
			    ProductDAO prodDAO = AbstractDAOFactory.getFactory().createProductDAO();
			    return prodDAO.getProduct();
			}

}
