package core;

import dao.DAOFactory;
import dtos.SupplierDTO;
import models.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierBO {
    private final DAOFactory daoFactory;

    public SupplierBO(int option) {
        daoFactory = DAOFactory.getDAOFactory(option);
    }

    public void insert(SupplierDTO supplierDTO) throws SQLException {
        System.out.println("Inserindo novo fornecedor...");
        daoFactory.getSuppliersDAO().insert(supplierDTO);
        System.out.println("Sucesso!");
    }

    public void update(SupplierDTO supplierDTO) throws SQLException {
        System.out.println("Atualizando fornecedor...");
        daoFactory.getSuppliersDAO().update(supplierDTO);
        System.out.println("Sucesso!");
    }

    public List<Supplier> getSuppliers() throws SQLException {
        System.out.println("Listando fornecedores...");
        return daoFactory.getSuppliersDAO().getSuppliers();
    }

    public void delete(int id) throws SQLException{
        System.out.println("Apagando fornecedor com ID: " + id);
        daoFactory.getSuppliersDAO().delete(id);
        System.out.println("Sucesso!");
    }
}
