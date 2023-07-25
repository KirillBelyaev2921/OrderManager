package belyaev.order.OrderManager.repository;

import belyaev.order.OrderManager.entity.Category;
import belyaev.order.OrderManager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductsByCategoryOfProducts(Category category);
    Optional<Product> getProductByProductNameAndCategoryOfProducts(String name, Category category);
}
