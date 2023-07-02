package belyaev.order.OrderManager.repository;

import belyaev.order.OrderManager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
