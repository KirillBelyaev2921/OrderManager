package belyaev.order.OrderManager.config;

import belyaev.order.OrderManager.service.CategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductsCategoryConfig {


    private final CategoryService categoryService;

    public ProductsCategoryConfig(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Bean
    public void addProductsCategory() {
        categoryService.setProductsCategory();
    }
}
