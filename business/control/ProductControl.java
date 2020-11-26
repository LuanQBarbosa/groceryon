package business.control;

import infra.ProductDao;
import util.InfraException;
import util.ProductNameException;
import business.model.Product;

import java.util.*;

public class ProductControl {
    private final ProductDao productDao;
    private final Map<String, Product> products;

    public ProductControl(ProductDao productDao) throws InfraException {
        this.productDao = productDao;
        products = productDao.loadProducts();
    }

    public void addProduct(String name, String description, String imgLink) throws ProductNameException, InfraException {
        if(products.containsKey(name))
            throw new ProductNameException("Produto já cadastrado!");

        Product product = new Product(name, description, imgLink);
        products.put(name, product);
        productDao.saveProducts(products);
    }

    public List<Product> listAll() {
        return new ArrayList<>(products.values());
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public Product deleteProduct(String login) throws InfraException {
        Product product = products.remove(login);
        if (product != null) { // evita chamada pesada, se users nao foi modificado
            productDao.saveProducts(products);
        }
        return product;
    }
}
