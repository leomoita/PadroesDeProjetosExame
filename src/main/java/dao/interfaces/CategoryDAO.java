package dao.interfaces;

import dtos.CategoryDTO;
import models.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDAO {
    List<Category> getCategories() throws SQLException;

    void insert(CategoryDTO categories) throws SQLException;

    void update(CategoryDTO categories) throws SQLException;

    void delete(int id) throws SQLException;
}
