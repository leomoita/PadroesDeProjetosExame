package core;

import dao.DAOFactory;
import dtos.ProductDTO;
import models.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductBO {
    private final DAOFactory daoFactory;

    public ProductBO(int option) {
        daoFactory = DAOFactory.getDAOFactory(option);
    }

    public void insert(ProductDTO categoriesDTO) throws SQLException {
        System.out.println("Inserindo novo produto...");
        daoFactory.getProductsDAO().insert(categoriesDTO);
        System.out.println("Sucesso!");
    }

    public void update(ProductDTO categoriesDTO) throws SQLException {
        System.out.println("Atualizando produto...");
        daoFactory.getProductsDAO().update(categoriesDTO);
        System.out.println("Sucesso!");
    }

    public List<Product> getProducts() throws SQLException {
        System.out.println("Listando produtos...");
        return daoFactory.getProductsDAO().getProducts();
    }

    public void delete(int id) throws SQLException{
        System.out.println("Apagando produto com ID: " + id);
        daoFactory.getProductsDAO().delete(id);
        System.out.println("Sucesso!");
    }
}
