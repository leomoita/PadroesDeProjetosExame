package core;

import dao.DAOFactory;
import dtos.CategoryDTO;
import models.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryBO {
    private final DAOFactory daoFactory;

    public CategoryBO(int option) {
        daoFactory = DAOFactory.getDAOFactory(option);
    }

    public void insert(CategoryDTO categoryDTO) throws SQLException {
        System.out.println("Inserindo nova categoria...");
        daoFactory.getCategoriesDAO().insert(categoryDTO);
        System.out.println("Sucesso!");
    }

    public void update(CategoryDTO categoryDTO) throws SQLException {
        System.out.println("Atualizando categoria...");
        daoFactory.getCategoriesDAO().update(categoryDTO);
        System.out.println("Sucesso!");
    }

    public List<Category> getCategories() throws SQLException {
        System.out.println("Listando categorias...");
        return daoFactory.getCategoriesDAO().getCategories();
    }

    public void delete(int id) throws SQLException{
        System.out.println("Apagando categoria com ID: " + id);
        daoFactory.getCategoriesDAO().delete(id);
        System.out.println("Sucesso!");
    }
}
