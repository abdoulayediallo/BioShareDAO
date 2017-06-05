package com.bioshare.modeldao;
public abstract class AbstractDAOFactory {
    
    private static AbstractDAOFactory factory;

    public static AbstractDAOFactory getFactory(){
        return factory;
    }

    public static void setFactory(AbstractDAOFactory factory) {
        AbstractDAOFactory.factory = factory;
    }
    
    public abstract ProductDAO createProductDAO();
    
    public abstract ProductDAO getAllProductDAO();
    
    public abstract UserDAO getRoleDAO();
}
