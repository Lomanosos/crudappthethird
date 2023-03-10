package hiber.logic.controller;

import hiber.logic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import hiber.logic.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/") //домаш. страница
    public String home(Model mav) {
        mav.addAttribute("listUser",userService.getListUsers());
        return "all-users";
    }

    @GetMapping("/createNewUser")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping() //сохранение
    public String save(@ModelAttribute("user") User theuser){
        userService.addUser(theuser);
        return "redirect:/";
    }
    @GetMapping("/editUser/{id}")//редактирование
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateUser";
    }
    @PostMapping("/updateUser")
    public String update(@ModelAttribute("update") User user) {
        userService.changeUser(user);
        return "redirect:/";
    }




    @GetMapping("/{id}") //удаление
    public String deleteById(@PathVariable("id") long id) {
        User user = userService.getUserById(id);
        userService.removeUser(user);
        return "redirect:/";
    }



}
