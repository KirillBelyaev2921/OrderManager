package belyaev.order.OrderManager.controller;

import belyaev.order.OrderManager.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user_input", new User());

        return "login";
    }

    @PostMapping("/perform_login")
    public String loginUser(@ModelAttribute("userForm") User user, Model model) {

        return "redirect:/";
    }
}
