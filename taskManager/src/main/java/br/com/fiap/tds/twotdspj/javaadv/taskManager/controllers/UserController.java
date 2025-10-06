package br.com.fiap.tds.twotdspj.javaadv.taskManager.controllers;

import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.DTOs.UserEditDTO;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.User;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService){this.userService = userService;}

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "users/form";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            return "users/form";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") UUID id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/view/{id}")
    public String viewUser(@PathVariable("id") UUID id, Model model) {
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + id));
        model.addAttribute("user", user);
        return "users/view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") UUID id, Model model) {
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + id));
        model.addAttribute("user", user);
        return "users/form";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") UUID id,
                             @Valid @ModelAttribute("user") UserEditDTO dto,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "users/form";
        }

        User existingUser = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado " + id));

        existingUser.setName(dto.getName());
        existingUser.setEmail(dto.getEmail());

        if(dto.getPassword() != null && !dto.getPassword().isBlank()){
            existingUser.setPassword(dto.getPassword());
        }

        userService.save(existingUser);
        return "redirect:/users";
    }
}
