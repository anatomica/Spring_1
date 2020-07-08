package Homework4.services;

import Homework4.model.Product;
import Homework4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<Product> findByPage(int pageNumber, int pageSize) {
        if (pageNumber < 1L) {
            pageNumber = 1;
        }
        return productRepository.findAll(PageRequest.of(pageNumber - 1, pageSize));
    }

    public List<Product> findByMinCost(int minCost) {
        return productRepository.findAllByCostGreaterThan(minCost);
    }

    public List<Product> findByMaxCost(int maxCost) {
        return productRepository.findAllByCostLessThan(maxCost);
    }

    public List<Product> findByMinMaxCost(int minCost, int maxCost) {
        return productRepository.findAllByCostGreaterThanAndCostLessThan(minCost, maxCost);
    }

}
