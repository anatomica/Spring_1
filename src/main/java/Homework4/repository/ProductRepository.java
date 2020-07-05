package Homework4.repository;

import Homework4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface  ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Product findOneByTitle(String title);
    List<Product> findAllByCostGreaterThan(int minCost);
    List<Product> findAllByCostLessThan(int maxCost);
}
