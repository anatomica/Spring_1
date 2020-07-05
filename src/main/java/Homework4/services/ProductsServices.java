package Homework4.services;

import Homework4.model.Product;
import Homework4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsServices {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow((RuntimeException::new));
    }

    public Product findByTitle(String title) {
        return productRepository.findOneByTitle(title);
    }

    public List<Product> findByMinCost(int cost) {
        return productRepository.findAllByCostGreaterThan(cost);
    }

    public List<Product> findByMaxCost(int cost) {
        return productRepository.findAllByCostLessThan(cost);
    }

}
