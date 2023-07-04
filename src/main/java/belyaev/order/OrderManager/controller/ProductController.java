package belyaev.order.OrderManager.controller;

import belyaev.order.OrderManager.entity.Product;
import belyaev.order.OrderManager.service.CategoryService;
import belyaev.order.OrderManager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class ProductController {


    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String productListPage(Model model) {
        model.addAttribute("product_list", productService.getAllProducts());
        return "index";
    }

    @GetMapping("/add_product")
    public String addProductPage(Model model) {
        model.addAttribute("product_input", new Product());
        return "add_product";
    }

    @PostMapping("/add_product_post")
    public String addProduct(Product product, Model model) {
        System.out.println(product.getProductName() + " is here!");
        product.setCategoryOfProducts(categoryService.getMainCategory());
        productService.addProduct(product);
        return "redirect:/";
    }
}
