package dao.sqlite;

import dao.interfaces.CategoryDAO;
import dtos.CategoryDTO;
import models.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImplSqlite implements CategoryDAO {

    public List<Category> getCategories() throws SQLException {

        List<Category> listaCategoria = new ArrayList<Category>();
        String query = "select * from category;";

        PreparedStatement preparedStatement = SqliteDAOFactory.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            listaCategoria.add(new Category(resultSet.getInt("id"), resultSet.getString("categoryname"), resultSet.getString("description")));
        }

        return listaCategoria;
    }

    public void insert(CategoryDTO categories) throws SQLException {
        String query = "insert into category (id , categoryname , description) values (? , ? , ?);";

        PreparedStatement preparedStatement = SqliteDAOFactory.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, categories.getId());
        preparedStatement.setString(2, categories.getName());
        preparedStatement.setString(3, categories.getDescription());

        preparedStatement.execute();

    }

    public void update(CategoryDTO categories) throws SQLException {
        String updateCategory = "update category set categoryname = ?, description = ? where id = ?;";

        PreparedStatement preparedStatement = SqliteDAOFactory.getConnection().prepareStatement(updateCategory);
        preparedStatement.setString(1, categories.getName());
        preparedStatement.setString(2, categories.getDescription());
        preparedStatement.setInt(3, categories.getId());
        preparedStatement.execute();
    }

    public void delete(int id) throws SQLException {
        String delCategory = "delete from category where id = ?;";

        PreparedStatement preparedStatement = SqliteDAOFactory.getConnection().prepareStatement(delCategory);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

}
