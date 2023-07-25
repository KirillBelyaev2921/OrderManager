package belyaev.order.OrderManager.controller;

import belyaev.order.OrderManager.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user_input", new User());

        return "login";
    }
}
