package belyaev.order.OrderManager.service;

import belyaev.order.OrderManager.OrderManagerApplication;
import belyaev.order.OrderManager.entity.Category;
import belyaev.order.OrderManager.entity.Product;
import belyaev.order.OrderManager.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ContextConfiguration(classes = {OrderManagerApplication.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceTest {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final UserService userService;
    private User user;

    @Autowired
    public ProductServiceTest(ProductService productService, CategoryService categoryService, UserService userService) {
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
    public void addProductAndGetByIdTest() {
        Product product = new Product();
        product.setProductName("Milk");
        product.setProductAmount(1);
        product.setProductDetails("det");
        product.setCategoryOfProducts(categoryService.getCategoryByNameAndUser("Products", user));
        productService.addProduct(product);

        Product expectedProduct = productService.getProductById(1L);
        assertNotNull(expectedProduct);
    }

    @Test
    @Transactional
    @Order(2)
    public void getAllProductsTest() {
        Product product = new Product();
        product.setProductName("Bread");
        product.setProductAmount(2);
        product.setProductDetails("det2");
        product.setCategoryOfProducts(categoryService.getCategoryByNameAndUser("Products", user));
        productService.addProduct(product);

        assertEquals(productService.getAllProducts().get(0), product);
    }

    @Test
    @Transactional
    @Order(3)
    void deleteProductTest() {
        Product product = new Product();
        product.setProductName("Milk");
        product.setProductAmount(1);
        product.setProductDetails("det");
        product.setCategoryOfProducts(categoryService.getCategoryByNameAndUser("Products", user));
        productService.addProduct(product);

        assertEquals(productService.getProductById(3L), product);

        productService.deleteProduct(4L);

        assertNull(productService.getProductById(4L));
    }

    @Test
    @Transactional
    @Order(4)
    void updateProductSetNewNameTest() {
        Product product = new Product();
        product.setProductName("Apple");
        product.setProductAmount(5);
        product.setProductDetails("det3");
        product.setCategoryOfProducts(categoryService.getCategoryByNameAndUser("Products", user));
        productService.addProduct(product);

        Product updateProduct = productService.getProductById(4L);
        updateProduct.setProductName("Fresh Milk");
        productService.updateProduct(updateProduct);

        Product expectedProduct = productService.getProductById(4L);
        String expectedName = expectedProduct.getProductName();

        assertEquals(expectedProduct, updateProduct);
        assertEquals(expectedName, "Fresh Milk");
    }

    @Test
    @Transactional
    @Order(5)
    void updateProductSetNewAmountTest() {
        Product product = new Product();
        product.setProductName("Apple");
        product.setProductAmount(5);
        product.setProductDetails("det3");
        product.setCategoryOfProducts(categoryService.getCategoryByNameAndUser("Products", user));
        productService.addProduct(product);

        Product updateProduct = productService.getProductById(5L);
        updateProduct.setProductAmount(7);
        productService.updateProduct(updateProduct);

        Product expectedProduct = productService.getProductById(5L);
        int expectedAmount = expectedProduct.getProductAmount();

        assertEquals(expectedProduct, updateProduct);
        assertEquals(expectedAmount, 7);
    }

    @Test
    @Transactional
    @Order(6)
    void updateProductSetNewDetailsTest() {
        Product product = new Product();
        product.setProductName("Apple");
        product.setProductAmount(5);
        product.setProductDetails("det3");
        product.setCategoryOfProducts(categoryService.getCategoryByNameAndUser("Products", user));
        productService.addProduct(product);

        Product updateProduct = productService.getProductById(6L);
        updateProduct.setProductDetails("Yummy!");
        productService.updateProduct(updateProduct);

        Product expectedProduct = productService.getProductById(6L);
        String expectedDetails = expectedProduct.getProductDetails();

        assertEquals(expectedProduct, updateProduct);
        assertEquals(expectedDetails, "Yummy!");
    }

    @Test
    @Transactional
    @Order(7)
    void updateProductSetNewCategoryTest() {
        Product product = new Product();
        product.setProductName("Apple");
        product.setProductAmount(5);
        product.setProductDetails("det3");
        product.setCategoryOfProducts(categoryService.getCategoryByNameAndUser("Products", user));
        productService.addProduct(product);

        Category category = new Category(
                6L, "Food", null, user
        );
        categoryService.addCategory(category);

        Product updateProduct = productService.getProductById(7L);
        updateProduct.setCategoryOfProducts(categoryService.getCategoryByNameAndUser("Food", user));
        productService.updateProduct(updateProduct);

        Product expectedProduct = productService.getProductById(7L);
        Category expectedCategory = expectedProduct.getCategoryOfProducts();

        assertEquals(expectedProduct, updateProduct);
        assertEquals(expectedCategory.getCategoryName(), category.getCategoryName());
    }

}
