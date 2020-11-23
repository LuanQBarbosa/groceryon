package infra;

import business.model.Product;
import util.InfraException;

import java.util.Map;

public interface ProductDao {
    Map<String, Product> loadProducts() throws InfraException;

    void saveProducts(Map<String, Product> products) throws InfraException;
}
