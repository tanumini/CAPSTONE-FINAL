package in.capstone.UserService.controller;

import in.capstone.UserService.model.User;
import in.capstone.UserService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User saveUser(@RequestBody User user) {

        log.info("Inside save user method of user controller");
        return service.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }


    @PutMapping("/register/{id}")
    public  ResponseEntity<User>  updateUser(@PathVariable(value = "id") Integer id,
                                             @RequestBody User user)
    {
        return service.updateUser(id,user);
    }

}
