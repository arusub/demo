package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/greet")
    public String get(@RequestParam(value = "name") String name){
        return "Welcome "+name+"!";
    }

    @PostMapping("/user")
    public void addUpdateUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/user")
    public ResponseEntity<Object> getUser(@RequestParam Long id){
        Optional<User> user = userService.getUser(id);
       if(user.isPresent()){
           System.out.println(user);
           return ResponseEntity.ok().body(user);
       }else {
        return ResponseEntity.notFound().build();
        //   new ResponseEntity<User>(user, HttpStatus);
       }
    }
}
