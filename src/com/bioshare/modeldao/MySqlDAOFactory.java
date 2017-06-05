package com.bioshare.modeldao;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;

public class MySqlDAOFactory extends AbstractDAOFactory{

    // unique instance of MySqlDAOFactory    
    private static MySqlDAOFactory instance;
    // private constructor to ensure that no can be created outside the class itself   
    private MySqlDAOFactory(){ };
    // static getter for the unique instance that handles initialization of the unique instance
    public static MySqlDAOFactory getInstance() {
        if (instance == null)
            instance = new MySqlDAOFactory();
        return instance;
    }
    
    // centralization of the connection complexity for all MySql Data Access Objects    
    public Connection getConnection() throws SQLException {
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection c = DriverManager.getConnection ("jdbc:mysql://localhost:3306/biosharejava?useSSL=false", "root", "messenger1417");
        return c;
    }
    
	public ProductDAO createProductDAO() {
		return MySqlProductDAO.getInstance();

	}
	public ProductDAO getAllProductDAO() {
		// TODO Auto-generated method stub
		return  MySqlProductDAO.getInstance();
	}
	public UserDAO getRoleDAO() {
		// TODO Auto-generated method stub
		return  MySqlUserDAO.getInstance();
	}


}
