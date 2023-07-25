package belyaev.order.OrderManager.service;

import belyaev.order.OrderManager.entity.Category;
import belyaev.order.OrderManager.entity.User;
import belyaev.order.OrderManager.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAllCategoriesByUser(User user) {
        return categoryRepository.findCategoriesByUserCategories(user);
    }

    public Category getCategoryById(Long id) {
        Optional<Category> categoryFromDb = categoryRepository.findById(id);
        return categoryFromDb.orElse(null);
    }

    public Category getCategoryByNameAndUser(String name, User user) {
        return categoryRepository.findCategoryByCategoryNameAndUserCategories(name, user).orElse(null);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
