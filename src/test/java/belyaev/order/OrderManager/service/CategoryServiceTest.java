package belyaev.order.OrderManager.service;

import belyaev.order.OrderManager.OrderManagerApplication;
import belyaev.order.OrderManager.entity.Category;
import belyaev.order.OrderManager.entity.Product;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {OrderManagerApplication.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryServiceTest {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public CategoryServiceTest(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Test
    @Transactional
    @Order(1)
    void getProductsCategory() {
        Category category = categoryService.getCategoryById(1L);
        assertEquals(category.getCategoryName(), "Products");
    }

    @Test
    @Transactional
    @Order(2)
    void addCategory() {
        Category category = new Category(
                2L, "Food", new ArrayList<>()
        );
        categoryService.addCategory(category);
        Category expectedCategory = categoryService.getCategoryById(2L);

        assertEquals(expectedCategory.getCategoryName(), category.getCategoryName());
    }

    @Test
    @Transactional
    @Order(3)
    void getAllCategories() {
        Category category = new Category(
                3L, "Food", null
        );
        categoryService.addCategory(category);

        List<Category> categories = categoryService.getAllCategories();

        assertEquals(categories.get(0).getCategoryName(), "Products");
        assertEquals(categories.get(1).getCategoryName(), category.getCategoryName());
    }

    @Test
    @Transactional
    @Order(4)
    void updateCategory() {
        Category category = new Category(
                4L, "Food", null
        );
        categoryService.addCategory(category);

        assertEquals(categoryService.getCategoryById(4L).getCategoryName(), category.getCategoryName());

        Category updateCategory = categoryService.getCategoryById(4L);
        updateCategory.setCategoryName("Technics");
        categoryService.updateCategory(updateCategory);

        assertEquals(categoryService.getCategoryById(4L).getCategoryName(), updateCategory.getCategoryName());
    }

    @Test
    @Transactional
    @Order(5)
    void deleteCategory() {
        Category category = new Category(
                5L, "Food", null
        );
        categoryService.addCategory(category);

        assertEquals(categoryService.getCategoryById(5L).getCategoryName(), category.getCategoryName());

        categoryService.deleteCategory(5L);

        assertNull(categoryService.getCategoryById(5L));
    }
}