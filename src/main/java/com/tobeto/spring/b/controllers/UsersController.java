package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.User;
import com.tobeto.spring.b.repositories.UserRepository;
import com.tobeto.spring.b.services.abstracts.UserService;
import com.tobeto.spring.b.services.dtos.requests.user.AddUserRequest;
import com.tobeto.spring.b.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.spring.b.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.spring.b.services.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UsersController {
    private final UserService userService;



    @GetMapping
    public List<GetUserListResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("{id}")
    public GetUserResponse getById(@PathVariable int id){
        return  userService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddUserRequest addUserRequest){
        userService.add(addUserRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateUserRequest updateUserRequest){
       userService.update(updateUserRequest);
    }

    @DeleteMapping("{id}")
    public  void delete(@PathVariable int id){
        userService.delete(id);
    }
}
