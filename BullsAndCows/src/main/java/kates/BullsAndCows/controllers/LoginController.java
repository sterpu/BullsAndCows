package kates.BullsAndCows.controllers;

import kates.BullsAndCows.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password) {
        return userService.register(login, password);
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password) {
        return userService.login(login, password);
    }

}
