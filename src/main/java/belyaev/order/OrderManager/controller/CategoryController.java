package belyaev.order.OrderManager.controller;

import belyaev.order.OrderManager.entity.Category;
import belyaev.order.OrderManager.entity.Product;
import belyaev.order.OrderManager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/update_category")
    public String updateProductPage(@RequestParam("id") Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category_input", category);
        model.addAttribute("category_list", categoryService.getAllCategories());
        return "update_category";
    }

    @PostMapping("/update_category_put")
    public String updateProduct(Category category, Model model) {
        categoryService.updateCategory(category);
        return "redirect:/";
    }

    @GetMapping("/delete_category")
    public String deleteProduct(@RequestParam("id") Long id, Model model) {
        categoryService.deleteCategory(id);
        return "redirect:/";
    }
}
