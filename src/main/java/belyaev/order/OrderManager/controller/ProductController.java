package belyaev.order.OrderManager.controller;

import belyaev.order.OrderManager.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    List<Product> products = new ArrayList<>();
    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("product_input", new Product());
        model.addAttribute("product_list", products);
        return "index";
    }

    @PostMapping("/add_product")
    public String addProduct(Product product, Model model) {
        System.out.println(product.getProductName() + " is here!");
        products.add(product);
        return "redirect:/";
    }
}
