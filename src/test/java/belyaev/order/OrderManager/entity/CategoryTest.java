package belyaev.order.OrderManager.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void testToString() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("user");
        user.setPassword("1234");
        Category category = new Category();
        category.setCategoryName("Products");
        category.setUserCategories(user);
        Product product = new Product(1L, "Milk", 1, "Yummy", category);
        category.setProducts(List.of(product));

        assertEquals(product.toString(), "Product{productId=1, productName='Milk', productAmount=1, productDetails='Yummy', categoryOfProducts=Products}");
        assertEquals(category.toString(), "Category{categoryId=null, categoryName='Products', products=[Product{productId=1, productName='Milk', productAmount=1, productDetails='Yummy', categoryOfProducts=Products}], user=1}");
    }
}