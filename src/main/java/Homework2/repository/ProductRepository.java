package Homework2.repository;

import Homework2.model.Product;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    List<Product> products;
    Long maxId;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Processor", 10000));
        products.add(new Product(2L, "Memory", 5000));
        maxId = (long) products.size();
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product saveOrUpdateProduct(Product product) {
        if (product.getId() == null) {
            maxId++;
            product.setId(maxId);
            products.add(product);
            return product;
        } else {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(product.getId())) {
                    products.set(i, product);
                    return product;
                }
            }
        }
        throw new RuntimeException("System error!");
    }

    public Product findById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new RuntimeException("Product not found");
    }
}
