package dao.sqlite;

import dao.interfaces.ProductDAO;
import dtos.ProductDTO;
import models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplSqlite implements ProductDAO {

    public List<Product> getProducts() throws SQLException {
        String query = "select * from product;";
        List<Product> products = new ArrayList<Product>();

        PreparedStatement preparedStatement = SqliteDAOFactory.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            products.add(new Product(resultSet.getInt("id"), resultSet.getString("productname")
                    , resultSet.getInt("supplierid"), resultSet.getInt("categoryid")
                    , resultSet.getInt("quantityperunit"), resultSet.getDouble("unitprice")
                    , resultSet.getInt("unitsinstock"), resultSet.getInt("unitsonorder")
                    , resultSet.getInt("reorderlevel"), resultSet.getInt("discontinued")));
        }

        return products;
    }

    public void insert(ProductDTO products) throws SQLException {
        String query =
                "insert into product (id , productname " +
                        ", supplierid , categoryid , quantityperunit " +
                        ", unitprice , unitsinstock , unitsonorder " +
                        ", reorderlevel , discontinued) values (? , ? , ? , ? , ? , ? , ? , ? , ? , ?);";

        PreparedStatement preparedStatement = SqliteDAOFactory.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, products.getProductId());
        preparedStatement.setString(2, products.getProductName());
        preparedStatement.setInt(3, products.getSupplierId());
        preparedStatement.setInt(4, products.getCategoryId());
        preparedStatement.setInt(5, products.getQuantityPerUnit());
        preparedStatement.setDouble(6, products.getUnitPrice());
        preparedStatement.setInt(7, products.getUnitsInStock());
        preparedStatement.setInt(8, products.getUnitsOnOrder());
        preparedStatement.setInt(9, products.getReorderLevel());
        preparedStatement.setInt(10, products.getDiscontinued());
        preparedStatement.execute();
    }

    public void update(ProductDTO products) throws SQLException {
        String query =
                "update product set (productname = ?" +
                        ", supplierid = ?, categoryid = ?, quantityperunit = ?" +
                        ", unitprice = ?, unitsinstock = ?, unitsonorder = ?" +
                        ", reorderlevel = ?, discontinued = ?) where id = ?;";

        PreparedStatement preparedStatement = SqliteDAOFactory.getConnection().prepareStatement(query);
        preparedStatement.setString(1, products.getProductName());
        preparedStatement.setInt(2, products.getSupplierId());
        preparedStatement.setInt(3, products.getCategoryId());
        preparedStatement.setInt(4, products.getQuantityPerUnit());
        preparedStatement.setDouble(5, products.getUnitPrice());
        preparedStatement.setInt(6, products.getUnitsInStock());
        preparedStatement.setInt(7, products.getUnitsOnOrder());
        preparedStatement.setInt(8, products.getReorderLevel());
        preparedStatement.setInt(9, products.getDiscontinued());
        preparedStatement.setInt(10, products.getProductId());
        preparedStatement.execute();
    }

    public void delete(int id) throws SQLException {
        String query = "delete from product where id = ?;";

        PreparedStatement preparedStatement = SqliteDAOFactory.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

}
