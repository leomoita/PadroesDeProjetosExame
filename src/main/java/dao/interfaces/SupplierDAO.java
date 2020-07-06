package dao.interfaces;

import dtos.SupplierDTO;
import models.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDAO {
    List<Supplier> getSuppliers() throws SQLException;

    void insert(SupplierDTO suppliers) throws SQLException;

    void update(SupplierDTO suppliers) throws SQLException;

    void delete(int id) throws SQLException;
}
