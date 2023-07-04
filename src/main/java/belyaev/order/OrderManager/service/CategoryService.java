package belyaev.order.OrderManager.service;

import belyaev.order.OrderManager.entity.Category;
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

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getMainCategory() {
        Optional<Category> mainCategory = categoryRepository.findById(1L);
        if (mainCategory.isPresent()) {
            return mainCategory.get();
        } else {
            Category category = new Category();
            category.setCategoryName("Products");
            categoryRepository.save(category);
            return category;
        }

    }

}
