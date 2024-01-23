package com.machete.PP_3_1_Spring_Boot.web.controller;

import com.machete.PP_3_1_Spring_Boot.web.model.User;
import com.machete.PP_3_1_Spring_Boot.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getAllUsers());

        return "usersTable";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute User user) {
        userService.deleteUser(user);
        return "redirect:/";
    }

    @PostMapping("/change")
    public String change(@ModelAttribute User user) {
        userService.changeUser(user);
        return "redirect:/";
    }


}
