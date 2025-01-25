package com.agilmetric.services;

import com.agilmetric.dto.UserRequest;
import com.agilmetric.models.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserModel> findAll();
    UserModel findById(UUID id);
    UserModel save(UserRequest request);
    UserModel update(UUID id, UserRequest request);
    void delete(UUID id);

}
