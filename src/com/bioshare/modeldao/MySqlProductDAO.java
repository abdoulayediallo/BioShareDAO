package com.bioshare.modeldao;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bioshare.model.Product;
import com.bioshare.model.ProductCategory;
import com.bioshare.model.ProductType;


public class MySqlProductDAO implements ProductDAO{
    
    private static MySqlProductDAO instance;
    
    public static MySqlProductDAO getInstance() {
        if (instance == null)
            instance = new MySqlProductDAO();
        return instance;
    }
    
    private MySqlProductDAO(){ }
    

    public String insertNewProduct(Product product) throws SQLException {
    	String result;
    	PreparedStatement prepareStatement = null;
    	Connection connection = null;
    	try {
	    	
	        connection = MySqlDAOFactory.getInstance().getConnection();
	        
	        prepareStatement = connection.prepareStatement("INSERT INTO announces (announce_label, announce_text, announce_product_id, announce_quantity, announce_price, announce_date_from, announce_date_to) values (?, ?, ?, ?, ?, ?, ?)");
	        
	        prepareStatement.setString(1, product.getTitle());
	        prepareStatement.setString(2, product.getDescription());
	        prepareStatement.setInt(3, product.getType());
	        prepareStatement.setInt(4, product.getQuantity());
	        prepareStatement.setInt(5, product.getPrice());
	        prepareStatement.setString(6, product.getDateFrom());
	        prepareStatement.setString(7, product.getDateTo());
	        prepareStatement.executeUpdate();

	        
	        result = "Success";
	    } catch (SQLException e) {
	        e.printStackTrace();
	        result = "Failure";
	    }
    	finally {
    		try { 
    			if (prepareStatement != null) {
    				prepareStatement.close();	
    				}
    			} 
    		catch (SQLException e) { 
    				e.printStackTrace(); 
    				}
    			
	      	try { 
	      		if (connection != null) {
	      			connection.close();	
	      			}
	      		}
	      	catch (SQLException e) { 
	      			e.printStackTrace(); 
	      			}
    	}
        return result;
         }
    
    public ArrayList <ProductCategory> getProductCategoriesList() throws SQLException {
    	Statement st = null;
    	Connection connection = null;
    	ResultSet rs = null;
    	ArrayList <ProductCategory> categories = new ArrayList <ProductCategory>();
    	try {
	    	
	        connection = MySqlDAOFactory.getInstance().getConnection();
	        st = connection.createStatement();
	        rs = st.executeQuery("SELECT *  FROM categories");
	        rs.beforeFirst();
	        
	        
	        while (rs.next()) {
	        	ProductCategory cat = new ProductCategory();
	        	
	        	cat.setCategoryId(rs.getInt("category_id"));
	        	cat.setCategoryLabel(rs.getString("category_label"));
	        	
	        	categories.add(cat);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
    	finally {
    		try { 
    			if (st != null) {
    				st.close();	
    				}
    			} 
    		catch (SQLException e) { 
    				e.printStackTrace(); 
    				}
    			
	      	try { 
	      		if (connection != null) {
	      			connection.close();	
	      			}
	      		}
	      	catch (SQLException e) { 
	      			e.printStackTrace(); 
	      			}
	      	try { 
	      		if (rs != null) {
	      			rs.close();	
	      			}
	      		}
	      	catch (SQLException e) { 
	      			e.printStackTrace(); 
	      			}
    	}
        return categories;
         }

    public ArrayList <ProductType> getProductTypesList(int category)  {
    	Statement st = null;
    	Connection connection = null;
    	ResultSet rs = null;
    	ArrayList <ProductType> types = new ArrayList <ProductType>();
    	try {
	    	
	        connection = MySqlDAOFactory.getInstance().getConnection();
	        st = connection.createStatement();
	        rs = st.executeQuery("SELECT *  FROM products WHERE product_category_id = "+category);

	        
	        
	        while (rs.next()) {
	        	ProductType tp = new ProductType();
	        	
	        	tp.setTypeId(rs.getInt("product_id"));
	        	tp.setTypeLabel(rs.getString("product_label"));
	        	
	        	types.add(tp);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
    	finally {
    		try { 
    			if (st != null) {
    				st.close();	
    				}
    			} 
    		catch (SQLException e) { 
    				e.printStackTrace(); 
    				}
    			
	      	try { 
	      		if (connection != null) {
	      			connection.close();	
	      			}
	      		}
	      	catch (SQLException e) { 
	      			e.printStackTrace(); 
	      			}
	      	try { 
	      		if (rs != null) {
	      			rs.close();	
	      			}
	      		}
	      	catch (SQLException e) { 
	      			e.printStackTrace(); 
	      			}
    	}

        return types;
         }
    
    public ArrayList<Product> getProduct() {
	    String sql = "SELECT * FROM productview";
	    Connection connection = null;
	    ArrayList<Product> product = new ArrayList<Product>();
	    try{
	    	connection = MySqlDAOFactory.getInstance().getConnection();
	    	PreparedStatement statement = connection.prepareStatement(sql);
	    	ResultSet resultSet = statement.executeQuery();
		    while (resultSet.next()) {
		    	Product p = new Product();
		    	p.setIdProduct(resultSet.getString("idProduct"));
	        	p.setLabel(resultSet.getString("productLabel"));
	        	p.setCategory(resultSet.getString("categoryLabel"));
	        	product.add(p);
	        }
		    resultSet.close();
		    statement.close();
	    	
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return product;
   }
    
}
