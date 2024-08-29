package com.allaboutsports.AaS.Controller;

import com.allaboutsports.AaS.Model.User;
import com.allaboutsports.AaS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/mypage")
    public String myPage(Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("user", user);
        return "mypage";
    }

    @PostMapping("/updateEmail")
    public String updateEmail(Principal principal, @RequestParam String newEmail) {
        String username = principal.getName();
        User user = userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(newEmail);
        userService.registerUser(user);
        return "redirect:/mypage";
    }

    @PostMapping("/deleteAccount")
    public String deleteAccount(Principal principal, @RequestParam String password) {
        String username = principal.getName();
        User user = userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        if (userService.checkPassword(user, password)) {
            userService.deleteUser(user);
            return "redirect:/logout";
        }
        return "redirect:/mypage?error";
    }
}
