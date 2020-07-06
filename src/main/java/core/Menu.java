package core;

import dtos.CategoryDTO;
import dtos.ProductDTO;
import dtos.SupplierDTO;
import models.Category;
import models.Product;
import models.Supplier;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public void OpenMenu() {
        System.out.println("****************");
        System.out.println("MENU");
        System.out.println("****************");
        System.out.println("1. Categorias");
        System.out.println("2. Produtos");
        System.out.println("3. Forncedores");
        System.out.println("0. Sair");
        System.out.println("****************");

        switch (new Scanner(System.in).nextInt()) {
            case 1:
                menuCategory();
                break;
            case 2:
                menuProduct();
                break;
            case 3:
                menuSupplier();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Tente novamente!");
                OpenMenu();
        }
    }

    //CATEGORIAS
    private void menuCategory(){
        System.out.println("****************");
        System.out.println("CATEGORIAS");
        System.out.println("****************");
        System.out.println("1. Inserir");
        System.out.println("2. Editar");
        System.out.println("3. Exibir Todas");
        System.out.println("4. Excluir");
        System.out.println("0. Sair");
        System.out.println("****************");

        switch (new Scanner(System.in).nextInt()) {
            case 1:
                insertCategory();
                break;
            case 2:
                updateCategory();
                break;
            case 3:
                showCategories();
                break;
            case 4:
                deleteCategory();
                break;
            case 0:
                OpenMenu();;
                break;
            default:
                System.out.println("Tente novamente!");
                menuCategory();
        }
    }

    private void insertCategory() {
        System.out.println("Nome: ");
        String name = new Scanner(System.in).next();
        System.out.println("Descricao: ");
        String desc = new Scanner(System.in).next();

        Category obj = new Category(name, desc);
        CategoryDTO dtoObj = new CategoryDTO(obj.getCategoryName(), obj.getDescription());

        CategoryBO bo = new CategoryBO(selectDB());

        try {
            bo.insert(dtoObj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateCategory() {
        System.out.println("ID: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Nome: ");
        String name = new Scanner(System.in).next();
        System.out.println("Descricao: ");
        String desc = new Scanner(System.in).next();

        Category obj = new Category(id, name, desc);
        CategoryDTO dtoObj = new CategoryDTO(obj.getCategoryId(), obj.getCategoryName(), obj.getDescription());

        CategoryBO bo = new CategoryBO(selectDB());

        try {
            bo.update(dtoObj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showCategories() {
        CategoryBO bo = new CategoryBO(selectDB());
        List<Category> categoriesList = null;
        try {
            categoriesList = bo.getCategories();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Category category : categoriesList) {
            System.out.println(category.toString());
        }
    }

    private void deleteCategory() {
        System.out.println("Informe o ID: ");
        int id = new Scanner(System.in).nextInt();
        CategoryBO categoryBO = new CategoryBO(selectDB());
        try {
            categoryBO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //PRODUTOS
    private void menuProduct(){
        System.out.println("****************");
        System.out.println("PRODUTOS");
        System.out.println("****************");
        System.out.println("1. Inserir");
        System.out.println("2. Editar");
        System.out.println("3. Exibir Todos");
        System.out.println("4. Excluir");
        System.out.println("0. Sair");
        System.out.println("****************");

        switch (new Scanner(System.in).nextInt()) {
            case 1:
                insertProduct();
                break;
            case 2:
                updateProduct();
                break;
            case 3:
                showProducts();
                break;
            case 4:
                deleteProduct();
                break;
            case 0:
                OpenMenu();;
                break;
            default:
                System.out.println("Tente novamente!");
                menuProduct();
        }
    }

    private void insertProduct() {
        System.out.println("Nome: ");
        String name = new Scanner(System.in).next();
        System.out.println("ID Fornecedor: ");
        int supplierId = new Scanner(System.in).nextInt();
        System.out.println("ID Categoria: ");
        int categoryId = new Scanner(System.in).nextInt();
        System.out.println("Quantidade por unidade: ");
        int quantityPerUnit = new Scanner(System.in).nextInt();
        System.out.println("Preço da unidade: ");
        double unitPrice = new Scanner(System.in).nextDouble();
        System.out.println("Unidades em estoque: ");
        int unitsInStock = new Scanner(System.in).nextInt();
        System.out.println("Unidades no pedido: ");
        int unitsOnOrder = new Scanner(System.in).nextInt();
        System.out.println("Nível de reabastecimento: ");
        int reorderLevel = new Scanner(System.in).nextInt();
        System.out.println("Descontinuado: ");
        int discontinued = new Scanner(System.in).nextInt();

        ProductDTO productDTO = new ProductDTO(name, supplierId, categoryId, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued);

        ProductBO bo = new ProductBO(selectDB());

        try {
            bo.insert(new ProductDTO(
                    productDTO.getProductName()
                    , productDTO.getSupplierId()
                    , productDTO.getCategoryId()
                    , productDTO.getQuantityPerUnit()
                    , productDTO.getUnitPrice()
                    , productDTO.getUnitsInStock()
                    , productDTO.getUnitsOnOrder()
                    , productDTO.getReorderLevel()
                    , productDTO.getDiscontinued()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct() {
        System.out.println("ID: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Nome: ");
        String name = new Scanner(System.in).next();
        System.out.println("ID Fornecedor: ");
        int supplierId = new Scanner(System.in).nextInt();
        System.out.println("ID Categoria: ");
        int categoryId = new Scanner(System.in).nextInt();
        System.out.println("Quantidade por unidade: ");
        int quantityPerUnit = new Scanner(System.in).nextInt();
        System.out.println("Preço da unidade: ");
        double unitPrice = new Scanner(System.in).nextDouble();
        System.out.println("Unidades em estoque: ");
        int unitsInStock = new Scanner(System.in).nextInt();
        System.out.println("Unidades no pedido: ");
        int unitsOnOrder = new Scanner(System.in).nextInt();
        System.out.println("Nível de reabastecimento: ");
        int reorderLevel = new Scanner(System.in).nextInt();
        System.out.println("Descontinuado: ");
        int discontinued = new Scanner(System.in).nextInt();

        ProductDTO productDTO = new ProductDTO(id, name, supplierId, categoryId, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued);

        ProductBO bo = new ProductBO(selectDB());

        try {
            bo.update(new ProductDTO(productDTO.getProductId()
                    , productDTO.getProductName()
                    , productDTO.getSupplierId()
                    , productDTO.getCategoryId()
                    , productDTO.getQuantityPerUnit()
                    , productDTO.getUnitPrice()
                    , productDTO.getUnitsInStock()
                    , productDTO.getUnitsOnOrder()
                    , productDTO.getReorderLevel()
                    , productDTO.getDiscontinued()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showProducts() {
        ProductBO bo = new ProductBO(selectDB());
        List<Product> productsList = null;
        try {
            productsList = bo.getProducts();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Product product : productsList) {
            System.out.println(product.toString());
        }
    }

    private void deleteProduct() {
        System.out.println("Informe o ID:");
        int id = new Scanner(System.in).nextInt();
        ProductBO categoryBO = new ProductBO(selectDB());
        try {
            categoryBO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //FORNECEDORES
    private void menuSupplier(){
        System.out.println("****************");
        System.out.println("FORNECEDORES");
        System.out.println("****************");
        System.out.println("1. Inserir");
        System.out.println("2. Editar");
        System.out.println("3. Exibir Todas");
        System.out.println("4. Excluir");
        System.out.println("0. Sair");
        System.out.println("****************");

        switch (new Scanner(System.in).nextInt()) {
            case 1:
                insertSupplier();
                break;
            case 2:
                updateSupplier();
                break;
            case 3:
                showSuppliers();
                break;
            case 4:
                deleteSupplier();
                break;
            case 0:
                OpenMenu();;
                break;
            default:
                System.out.println("Tente novamente!");
                menuSupplier();
        }
    }

    private void insertSupplier() {
        System.out.println("Nome empresa: ");
        String compName = new Scanner(System.in).next();
        System.out.println("Nome contato: ");
        String contaName = new Scanner(System.in).next();
        System.out.println("Titulo contato: ");
        String contaTitle = new Scanner(System.in).next();
        System.out.println("Endereco: ");
        String address = new Scanner(System.in).next();
        System.out.println("Cidade: ");
        String city = new Scanner(System.in).next();
        System.out.println("Regiao: ");
        String region = new Scanner(System.in).next();
        System.out.println("Codigo Postal: ");
        String postalCode = new Scanner(System.in).next();
        System.out.println("Pais: ");
        String country = new Scanner(System.in).next();
        System.out.println("Telefone: ");
        String phone = new Scanner(System.in).next();
        System.out.println("Fax: ");
        String fax = new Scanner(System.in).next();
        System.out.println("Home Page: ");
        String homepage = new Scanner(System.in).next();


        Supplier supplier = new Supplier(compName, contaName, contaTitle, address, city, region, postalCode, country, phone, fax, homepage);

        SupplierDTO supplierDTO =
                new SupplierDTO(supplier.getCompanyName()
                        , supplier.getContactName()
                        , supplier.getContactTitle()
                        , supplier.getAddress()
                        , supplier.getCity()
                        , supplier.getRegion()
                        , supplier.getPostalCode()
                        , supplier.getCountry()
                        , supplier.getPhone()
                        , supplier.getFax()
                        , supplier.getHomePage());

        SupplierBO bo = new SupplierBO(selectDB());

        try {
            bo.insert(supplierDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateSupplier() {
        System.out.println("ID: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Nome empresa: ");
        String compName = new Scanner(System.in).next();
        System.out.println("Nome contato: ");
        String contaName = new Scanner(System.in).next();
        System.out.println("Titulo contato: ");
        String contaTitle = new Scanner(System.in).next();
        System.out.println("Endereco: ");
        String address = new Scanner(System.in).next();
        System.out.println("Cidade: ");
        String city = new Scanner(System.in).next();
        System.out.println("Regiao: ");
        String region = new Scanner(System.in).next();
        System.out.println("Codigo Postal: ");
        String postalCode = new Scanner(System.in).next();
        System.out.println("Pais: ");
        String country = new Scanner(System.in).next();
        System.out.println("Telefone: ");
        String phone = new Scanner(System.in).next();
        System.out.println("Fax: ");
        String fax = new Scanner(System.in).next();
        System.out.println("Home Page: ");
        String homepage = new Scanner(System.in).next();


        Supplier supplier = new Supplier(id, compName, contaName, contaTitle, address, city, region, postalCode, country, phone, fax, homepage);

        SupplierDTO supplierDTO =
                new SupplierDTO(
                        supplier.getSupplierId()
                        , supplier.getCompanyName()
                        , supplier.getContactName()
                        , supplier.getContactTitle()
                        , supplier.getAddress()
                        , supplier.getCity()
                        , supplier.getRegion()
                        , supplier.getPostalCode()
                        , supplier.getCountry()
                        , supplier.getPhone()
                        , supplier.getFax()
                        , supplier.getHomePage());

        SupplierBO bo = new SupplierBO(selectDB());

        try {
            bo.update(supplierDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showSuppliers() {
        SupplierBO bo = new SupplierBO(selectDB());
        List<Supplier> suppliersList = null;
        try {
            suppliersList = bo.getSuppliers();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Supplier sup : suppliersList) {
            System.out.println(sup.toString());
        }
    }

    private void deleteSupplier() {
        System.out.println("Informe o ID: ");
        int id = new Scanner(System.in).nextInt();
        SupplierBO categoryBO = new SupplierBO(selectDB());
        try {
            categoryBO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private int selectDB() {
        System.out.println("****************");
        System.out.println("Informe qual bando de dados deseja usar");
        System.out.println("1. SQLITE");

        return new Scanner(System.in).nextInt();
    }

}
