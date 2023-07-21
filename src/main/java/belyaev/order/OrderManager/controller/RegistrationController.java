package belyaev.order.OrderManager.controller;

import belyaev.order.OrderManager.entity.User;
import belyaev.order.OrderManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user_input", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            model.addAttribute("password_error", "Password mismatch");
            return "registration";
        }
        if (!userService.addUser(user)) {
            model.addAttribute("username_error", "A user with the same name already exists");
            return "registration";
        }

        return "redirect:/";
    }
}
