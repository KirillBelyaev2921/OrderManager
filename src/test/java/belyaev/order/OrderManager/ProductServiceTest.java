package belyaev.order.OrderManager;

import belyaev.order.OrderManager.entity.Product;
import belyaev.order.OrderManager.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ContextConfiguration(classes = { OrderManagerApplication.class })
public class ProductServiceTest {

    private final ProductService productService;

    @Autowired
    public ProductServiceTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    @Transactional
    public void testAddProduct() {
        Product product = new Product();
        product.setProductName("Milk");
        product.setProductAmount(1);
        product.setProductDetails("det");
        productService.addProduct(product);
    }
    @Test
    @Transactional
    public void testGetAllProducts() {
        Product product = new Product();
        product.setProductName("Milk");
        product.setProductAmount(1);
        product.setProductDetails("det");
        productService.addProduct(product);
        System.out.println(productService.getAllProducts());
    }
}
