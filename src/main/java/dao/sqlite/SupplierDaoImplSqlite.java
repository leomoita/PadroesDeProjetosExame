package dao.sqlite;

import dao.interfaces.SupplierDAO;
import dtos.SupplierDTO;
import models.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoImplSqlite implements SupplierDAO {

    public List<Supplier> getSuppliers() throws SQLException {
        String query = "select * from supplier;";
        List<Supplier> suppliers = new ArrayList<Supplier>();

        PreparedStatement preparedStatement = SqliteDAOFactory.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            suppliers.add(new Supplier(resultSet.getInt("id"),
                    resultSet.getString("companyname"),
                    resultSet.getString("contactname"),
                    resultSet.getString("contacttitle"),
                    resultSet.getString("address"),
                    resultSet.getString("city"),
                    resultSet.getString("region"),
                    resultSet.getString("postalcode"),
                    resultSet.getString("country"),
                    resultSet.getString("phone"),
                    resultSet.getString("fax"),
                    resultSet.getString("homepage")));
        }

        return suppliers;
    }

    public void insert(SupplierDTO suppliers) throws SQLException {
        String query = "insert into supplier " +
                "(id , companyname , contactname , contacttitle " +
                ", address , city , region , postalcode , country , phone " +
                ", fax , homepage) values (? , ?  ,? , ? , ? , ?, ? , ? , ? , ? , ? , ? );";

        PreparedStatement preparedStatement = SqliteDAOFactory.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, suppliers.getSupplierId());
        preparedStatement.setString(2, suppliers.getCompanyName());
        preparedStatement.setString(3, suppliers.getContactName());
        preparedStatement.setString(4, suppliers.getContactTitle());
        preparedStatement.setString(5, suppliers.getAddress());
        preparedStatement.setString(6, suppliers.getCity());
        preparedStatement.setString(7, suppliers.getRegion());
        preparedStatement.setString(8, suppliers.getPostalCode());
        preparedStatement.setString(9, suppliers.getCountry());
        preparedStatement.setString(10, suppliers.getPhone());
        preparedStatement.setString(11, suppliers.getFax());
        preparedStatement.setString(12, suppliers.getHomePage());

        preparedStatement.execute();
    }

    public void update(SupplierDTO suppliers) throws SQLException {
        String query = "update supplier set " +
                "(companyname = ? , contactname = ?, contacttitle = ?" +
                ", address = ?, city = ?, region = ?, postalcode = ?, country = ?, phone = ?" +
                ", fax = ?, homepage = ?) where id = ?;";

        PreparedStatement preparedStatement = SqliteDAOFactory.getConnection().prepareStatement(query);

        preparedStatement.setString(1, suppliers.getCompanyName());
        preparedStatement.setString(2, suppliers.getContactName());
        preparedStatement.setString(3, suppliers.getContactTitle());
        preparedStatement.setString(4, suppliers.getAddress());
        preparedStatement.setString(5, suppliers.getCity());
        preparedStatement.setString(6, suppliers.getRegion());
        preparedStatement.setString(7, suppliers.getPostalCode());
        preparedStatement.setString(8, suppliers.getCountry());
        preparedStatement.setString(9, suppliers.getPhone());
        preparedStatement.setString(10, suppliers.getFax());
        preparedStatement.setString(11, suppliers.getHomePage());
        preparedStatement.setInt(12, suppliers.getSupplierId());

        preparedStatement.execute();
    }

    public void delete(int id) throws SQLException {
        String query = "delete from supplier where id = ?";

        PreparedStatement preparedStatement = SqliteDAOFactory.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }
}
