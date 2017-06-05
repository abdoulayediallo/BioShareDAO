package com.bioshare.modeldao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bioshare.model.Product;
import com.bioshare.model.ProductCategory;
import com.bioshare.model.ProductType;
import com.bioshare.model.User;
public interface UserDAO {
	
	public default String getRole(String login, String pass) {
	    UserDAO userDAO = AbstractDAOFactory.getFactory().getRoleDAO();
	    return userDAO.getRole(login, pass);
	}
	
}
