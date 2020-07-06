package dao.interfaces;

import dtos.ProductDTO;
import models.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    List<Product> getProducts() throws SQLException;

    void update(ProductDTO products) throws SQLException;

    void insert(ProductDTO categories) throws SQLException;

    void delete(int id) throws SQLException;
}
