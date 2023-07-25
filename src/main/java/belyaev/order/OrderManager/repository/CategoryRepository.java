package belyaev.order.OrderManager.repository;

import belyaev.order.OrderManager.entity.Category;
import belyaev.order.OrderManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findCategoriesByUserCategories(User user);
    Optional<Category> findCategoryByCategoryNameAndUserCategories(String name, User user);
}
