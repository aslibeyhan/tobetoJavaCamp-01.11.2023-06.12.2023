package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.User;
import com.tobeto.spring.b.repositories.UserRepository;
import com.tobeto.spring.b.services.abstracts.UserService;
import com.tobeto.spring.b.services.dtos.requests.user.AddUserRequest;
import com.tobeto.spring.b.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.spring.b.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.spring.b.services.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<GetUserListResponse> getAll() {
       List<User>  userList=userRepository.findAll();
       List<GetUserListResponse> userListResponses=new ArrayList<>();
        for (User user:userList) {
            GetUserListResponse getUserListResponse=new GetUserListResponse();
            getUserListResponse.setId(user.getId());
            getUserListResponse.setFirst_name(user.getFirst_name());
            getUserListResponse.setLast_name(user.getLast_name());
            getUserListResponse.setEmail(user.getEmail());
            getUserListResponse.setPhone(user.getPhone());
            userListResponses.add(getUserListResponse);
        }
        return  userListResponses;
    }

    @Override
    public GetUserResponse getById(int id) {
        User user=userRepository.findById(id).orElseThrow();
        GetUserResponse userResponse=new GetUserResponse();
        userResponse.setId(user.getId());
        userResponse.setFirst_name(user.getFirst_name());
        userResponse.setLast_name(user.getLast_name());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        return userResponse;

    }

    @Override
    public void add(AddUserRequest addUserRequest) {
       User user=new User();
       user.setFirst_name(addUserRequest.getFirst_name());
       user.setLast_name(addUserRequest.getLast_name());
       user.setEmail(addUserRequest.getEmail());
       user.setPhone(addUserRequest.getPhone());
       userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User userToUpdate=userRepository.findById(updateUserRequest.getId()).orElseThrow();
        userToUpdate.setFirst_name(updateUserRequest.getFirst_name());
        userToUpdate.setLast_name(updateUserRequest.getLast_name());
        userToUpdate.setEmail(updateUserRequest.getEmail());
        userToUpdate.setPhone(updateUserRequest.getPhone());
        userRepository.save(userToUpdate);
    }

    @Override
    public void delete(int id) {
        User userToDelete=userRepository.findById(id).orElseThrow();
        userRepository.delete(userToDelete);

    }
}
