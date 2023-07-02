package belyaev.order.OrderManager.controller;

import belyaev.order.OrderManager.entity.Product;
import belyaev.order.OrderManager.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("product_input", new Product());
        model.addAttribute("product_list", productService.getAllProducts());
        return "index";
    }

    @PostMapping("/add_product")
    public String addProduct(Product product, Model model) {
        System.out.println(product.getProductName() + " is here!");
        productService.addProduct(product);
        return "redirect:/";
    }
}
