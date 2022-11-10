package SPRING_MVC.dao;

import SPRING_MVC.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();


    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @PostConstruct
    public void init() {
        products.add(new Product(1, "q", 100));
        products.add(new Product(2, "w", 200));
    }
}
