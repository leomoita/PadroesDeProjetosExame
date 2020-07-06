package dao.sqlite;

import dao.DAOFactory;
import dao.interfaces.CategoryDAO;
import dao.interfaces.ProductDAO;
import dao.interfaces.SupplierDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqliteDAOFactory extends DAOFactory {


    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:src/main/java/database/northwind.db");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public CategoryDAO getCategoriesDAO() {
        return new CategoryDaoImplSqlite();
    }

    public ProductDAO getProductsDAO() {
        return new ProductDaoImplSqlite();
    }

    public SupplierDAO getSuppliersDAO() {
        return new SupplierDaoImplSqlite();
    }
}
