import com.bioshare.model.Product;

import java.sql.SQLException;

import com.bioshare.model.Eshop;
import com.bioshare.modeldao.AbstractDAOFactory;
import com.bioshare.modeldao.MySqlDAOFactory;

public class Launcher {
    public static void main(String[] args) throws SQLException {
        System.out.println("Using MySql database");
        Product product = new Product();
        product.setTitle("Mon produit");
        product.setDescription("Il est beau");
        Eshop eshop = new Eshop();
        
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        String result = eshop.getProduct().toString();
        		
        System.out.println(result);
        		
        


        
        
        
        //Iterator<Product> mySQLbooksitr = mySQLbooks.iterator();
        //while (mySQLbooksitr.hasNext()) {
        //    Product b = mySQLbooksitr.next();
        //    System.out.println(b);
        //}        
}
}
