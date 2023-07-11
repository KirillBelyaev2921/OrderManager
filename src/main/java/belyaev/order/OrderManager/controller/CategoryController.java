package belyaev.order.OrderManager.controller;

import belyaev.order.OrderManager.entity.Category;
import belyaev.order.OrderManager.entity.Product;
import belyaev.order.OrderManager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/add_category")
    public String addCategoryPage(Model model) {
        model.addAttribute("category_input", new Category());
        return "add_category";
    }

    @PostMapping("/add_category")
    public String addCategory(Category category, Model model) {
        categoryService.addCategory(category);
        return "redirect:/";
    }
}
