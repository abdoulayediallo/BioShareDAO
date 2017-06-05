package com.bioshare.modeldao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MySqlUserDAO implements UserDAO{
    private static MySqlUserDAO instance;
    
    public static MySqlUserDAO getInstance() {
        if (instance == null)
            instance = new MySqlUserDAO();
        return instance;
    }
    
    private MySqlUserDAO(){ }
    
    public String getRole(String login, String pass) {
	    String sql = "SELECT role FROM role WHERE login = ? AND password = ?";
	    String message="";
	    Connection connection = null;
	    try{
	    	connection = MySqlDAOFactory.getInstance().getConnection();
		    PreparedStatement statement = connection.prepareStatement(sql);
		    statement.setString(1, login);
		    statement.setString(2, pass);
		     
		    ResultSet resultSet = statement.executeQuery();
		    if(resultSet.next()){
		    	message = resultSet.getString("role");
		    }else{
		    	message = "Erreur ! Veuillez verifier le login et/ou le mot de passe";
		    }
		    
		    resultSet.close();
		    statement.close();
	    	
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return message;
   }

}
