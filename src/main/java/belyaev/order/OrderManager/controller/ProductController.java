package belyaev.order.OrderManager.controller;

import belyaev.order.OrderManager.entity.Product;
import belyaev.order.OrderManager.service.CategoryService;
import belyaev.order.OrderManager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("category_list", categoryService.getAllCategories());
        return "index";
    }

    @GetMapping("/add_product")
    public String addProductPage(Model model) {
        model.addAttribute("product_input", new Product());
        model.addAttribute("category_list", categoryService.getAllCategories());
        return "add_product";
    }

    @PostMapping("/add_product")
    public String addProduct(Product product, Model model) {
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/update_product")
    public String updateProductPage(@RequestParam("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product_input", product);
        model.addAttribute("category_list", categoryService.getAllCategories());
        return "update_product";
    }

    @PostMapping("/update_product_put")
    public String updateProduct(Product product, Model model) {
        productService.updateProduct(product);
        return "redirect:/";
    }

    @GetMapping("/delete_product")
    public String deleteProduct(@RequestParam("id") Long id, Model model) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
