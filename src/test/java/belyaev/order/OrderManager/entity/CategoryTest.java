package belyaev.order.OrderManager.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void testToString() {
        Category category = new Category(1L, "Products", null);
        Product product = new Product(1L, "Milk", 1, "Yummy", category);
        category.setProducts(List.of(product));

        assertEquals(product.toString(), "Product{productId=1, productName='Milk', productAmount=1, productDetails='Yummy', categoryOfProducts=Products}");
        assertEquals(category.toString(), "Category{categoryId=1, categoryName='Products', products=Milk}");
    }
}