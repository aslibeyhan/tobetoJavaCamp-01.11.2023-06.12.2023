package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.User;
import com.tobeto.spring.b.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {
    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable int id){
        return  userRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody User user){
        userRepository.save(user);
    }

    @PutMapping
    public void update(@RequestBody User user){
        userRepository.findById(user.getId()).orElseThrow();
        userRepository.save(user);
    }

    @DeleteMapping("{id}")
    public  void delete(@PathVariable int id){
        User userToDelete=userRepository.findById(id).orElseThrow();
        userRepository.delete(userToDelete);
    }
}
