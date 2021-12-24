package com.example.httpCommunication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HttpCommunicationRestController {
    //    @PostMapping(path = "/user", produces = "application/xml")
//    public String greetingWithPathVariable() {
//        return "Hello! This a message from a simple application";
//    }
    @Autowired
    private HttpCommunicationService service;

    @PostMapping("/user/post")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int id){
        return service.getUserById(id);
    }
    @PutMapping("/user/{id}")
    public User updateEmail(@PathVariable("id") int id, @RequestParam String email) {
        return service.updateEmail(id, email);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }
    @PostMapping("/user/edit/{id}")
    public User updateUsername(@PathVariable("id") int id, @RequestParam String username){
        return service.updateUsername(id,username);
    }
    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        return service.deleteUser(id);
    }

    @GetMapping("/user/username/{username}")
    public User getUserByUsername(@PathVariable String username){
          return service.getUserByUsername(username);
    }
}