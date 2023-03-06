package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/") //ready
    public String home(Model mav) {
        List<User> listUser = userService.getListUsers();
        mav.addAttribute("listUser",listUser);
        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user-info";
    }
    @RequestMapping("/saveUser")
    public String saveUsers(@ModelAttribute("user") User theuser){
        userService.addUser(theuser);
        return "redirect:/";
    }
    @RequestMapping("/deleteUser")
    public String deleteById(@RequestParam("userId") long id) {
        User user = userService.getUserById(id);
        userService.removeUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("userId") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-info";
    }
}
