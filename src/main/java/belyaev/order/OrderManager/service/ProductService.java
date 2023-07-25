package belyaev.order.OrderManager.service;

import belyaev.order.OrderManager.entity.Category;
import belyaev.order.OrderManager.entity.Product;
import belyaev.order.OrderManager.entity.User;
import belyaev.order.OrderManager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsByCategory(Category category) {
        return productRepository.getProductsByCategoryOfProducts(category);
    }

    public Product getProductById(Long id) {
        Optional<Product> productFromDb = productRepository.findById(id);
        return productFromDb.orElse(null);
    }

    public Product getProductByNameAndCategory(String name, Category category) {
        return productRepository.getProductByProductNameAndCategoryOfProducts(name, category).orElse(null);
    }


    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
