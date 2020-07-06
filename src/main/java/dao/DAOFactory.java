package dao;

import dao.interfaces.CategoryDAO;
import dao.interfaces.ProductDAO;
import dao.interfaces.SupplierDAO;
import dao.sqlite.SqliteDAOFactory;

public abstract class DAOFactory {
    public static final int SQLITE = 1;

    public static DAOFactory getDAOFactory(int option) {
        switch (option) {
            case SQLITE:
                return new SqliteDAOFactory();
            default:
                return null;
        }
    }

    public abstract CategoryDAO getCategoriesDAO();

    public abstract ProductDAO getProductsDAO();

    public abstract SupplierDAO getSuppliersDAO();
}
