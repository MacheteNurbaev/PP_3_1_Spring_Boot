package com.machete.PP_3_1_Spring_Boot.web.controller;

import com.machete.PP_3_1_Spring_Boot.web.model.User;
import com.machete.PP_3_1_Spring_Boot.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String showUsersTable(Model model) {
        model.addAttribute("users", userService.getAllUsers());

        return "usersTable";
    }

    @GetMapping(value = "/goToChangeUser")
    public String goToChangeUser(@RequestParam Long id,Model model) {
        List<User> user = new ArrayList<>();
        user.add(userService.getUser(id));
        model.addAttribute("users", user);
        model.addAttribute("user", new User());
        return "changeUser";
    }

    @GetMapping(value = "/goToAddUser")
    public String goToAddUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addUser";

        }
        model.addAttribute("user", user);
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PostMapping("/change")
    public String change(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "changeUser";
        }
        userService.changeUser(user);
        return "redirect:/";
    }


}
