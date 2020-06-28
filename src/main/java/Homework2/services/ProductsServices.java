package Homework2.services;

import Homework2.model.Product;
import Homework2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsServices {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product modifyProduct(Product product) {
        return productRepository.saveOrUpdateProduct(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

}
