package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.user.AddUserRequest;
import com.tobeto.spring.b.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.spring.b.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.spring.b.services.dtos.responses.user.GetUserResponse;

import java.util.List;

public interface UserService {
    List<GetUserListResponse> getAll();
    GetUserResponse getById(int id);
    public void add(AddUserRequest addUserRequest);
    public void update(UpdateUserRequest updateUserRequest);
    public void delete(int id);
}
