package incload.controllers;

import incload.model.Team;
import incload.model.User;
import incload.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username){
        return userService.getUser(username);
    }

    @PostMapping("/user/registration")
    public void regUser(@RequestBody User user){
        userService.saveUser(user.getUsername());
    }


}
