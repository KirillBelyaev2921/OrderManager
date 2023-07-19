package belyaev.order.OrderManager.service;

import belyaev.order.OrderManager.OrderManagerApplication;
import belyaev.order.OrderManager.entity.Product;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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

    @Autowired
    public ProductServiceTest(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @Test
    @Transactional
    @Order(1)
    public void addProductAndGetByIdTest() {
        Product product = new Product();
        product.setProductName("Milk");
        product.setProductAmount(1);
        product.setProductDetails("det");
        product.setCategoryOfProducts(categoryService.getCategoryById(1L));
        productService.addProduct(product);

        System.out.println(productService.getAllProducts());
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
        product.setCategoryOfProducts(categoryService.getCategoryById(1L));
        productService.addProduct(product);

        assertEquals(productService.getAllProducts().get(0), product);
    }


    @Test
    @Transactional
    @Order(3)
    void updateProductSetNewNameTest() {
        Product product = new Product();
        product.setProductName("Apple");
        product.setProductAmount(5);
        product.setProductDetails("det3");
        product.setCategoryOfProducts(categoryService.getCategoryById(1L));
        productService.addProduct(product);

        Product updateProduct = productService.getProductById(3L);
        updateProduct.setProductName("Fresh Milk");
        productService.updateProduct(updateProduct);

        Product expectedProduct = productService.getProductById(3L);
        String expectedName = expectedProduct.getProductName();

        assertEquals(expectedProduct, updateProduct);
        assertEquals(expectedName, "Fresh Milk");
    }

    @Test
    @Transactional
    @Order(4)
    void deleteProductTest() {
        Product product = new Product();
        product.setProductName("Milk");
        product.setProductAmount(1);
        product.setProductDetails("det");
        product.setCategoryOfProducts(categoryService.getCategoryById(1L));
        productService.addProduct(product);

        productService.deleteProduct(4L);

        assertNull(productService.getProductById(4L));
    }
}