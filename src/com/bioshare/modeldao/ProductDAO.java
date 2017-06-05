package com.bioshare.modeldao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bioshare.model.Product;
import com.bioshare.model.ProductCategory;
import com.bioshare.model.ProductType;

public interface ProductDAO {
	public default String insertNewProduct(Product product) throws SQLException {
	      AbstractDAOFactory factory = AbstractDAOFactory.getFactory();
	      ProductDAO prodDAO = factory.createProductDAO();
	      return prodDAO.insertNewProduct(product); 
	}
	
	public default ArrayList<ProductCategory> getProductCategoriesList() throws SQLException {
	    
	    ProductDAO prodDAO = AbstractDAOFactory.getFactory().createProductDAO();
	    return prodDAO.getProductCategoriesList();
	}
	
	public default ArrayList<ProductType> getProductTypesList(int category) {
	    
	    ProductDAO prodDAO = AbstractDAOFactory.getFactory().createProductDAO();
	    return prodDAO.getProductTypesList(category);
	}
	
	public default ArrayList<Product> getProduct() {
	    
	    ProductDAO prodDAO = AbstractDAOFactory.getFactory().createProductDAO();
	    return prodDAO.getProduct();
	}
	
}
