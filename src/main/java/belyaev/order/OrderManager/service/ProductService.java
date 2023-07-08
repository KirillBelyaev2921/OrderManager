package belyaev.order.OrderManager.service;

import belyaev.order.OrderManager.entity.Product;
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

    public Product getProductById(Long id) {
        Optional<Product> oProduct = productRepository.findById(id);
        if (oProduct.isPresent()) {
            return oProduct.get();
        } else {
            Product product = new Product();
            product.setProductId(id);
            return product;
        }
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }
}
