package belyaev.order.OrderManager.controller;

import belyaev.order.OrderManager.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("product", new Product());
        return "index";
    }

    @PostMapping("/add_product")
    public String addProduct(Product product, Model model) {
        System.out.println(product.getProductName() + " is here!");
        return "redirect:/";
    }
}
