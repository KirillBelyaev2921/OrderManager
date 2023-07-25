package belyaev.order.OrderManager.service;

import belyaev.order.OrderManager.OrderManagerApplication;
import belyaev.order.OrderManager.entity.Category;
import belyaev.order.OrderManager.entity.User;
import org.junit.jupiter.api.*;
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
    private final UserService userService;
    private User user;

    @Autowired
    public CategoryServiceTest(ProductService productService, CategoryService categoryService, UserService userService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUsername("UserName");
        user.setPassword("1234");
        user.setPasswordConfirm("1234");
        userService.addUser(user);
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
        Category category = new Category();
        category.setCategoryName("Food");
        category.setUserCategories(user);

        assertNull(categoryService.getCategoryByNameAndUser("Food", user));

        categoryService.addCategory(category);
        assertNotNull(categoryService.getCategoryByNameAndUser("Food", user));

    }

    @Test
    @Transactional
    @Order(3)
    void getAllCategoriesByUser() {
        List<Category> categories = categoryService.getAllCategoriesByUser(user);

        assertEquals(categories.get(0).getCategoryName(), "Products");
    }

    @Test
    @Transactional
    @Order(4)
    void updateCategory() {
        Category category = new Category();
        category.setCategoryName("Food2");
        category.setUserCategories(user);

        categoryService.addCategory(category);

        Category updateCategory = categoryService.getCategoryByNameAndUser("Food2", user);
        updateCategory.setCategoryName("Technics");
        categoryService.updateCategory(updateCategory);

        assertNull(categoryService.getCategoryByNameAndUser("Food2", user));
        assertNotNull(categoryService.getCategoryByNameAndUser("Technics", user));
    }

    @Test
    @Transactional
    @Order(5)
    void deleteCategory() {
        Category category = new Category();
        category.setCategoryName("Technics");
        category.setUserCategories(user);
        categoryService.addCategory(category);

        categoryService.deleteCategory(categoryService.getCategoryByNameAndUser("Technics", user).getCategoryId());

        assertNull(categoryService.getCategoryByNameAndUser("Technics", user));
    }
}