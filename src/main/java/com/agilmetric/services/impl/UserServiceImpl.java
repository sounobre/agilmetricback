package com.agilmetric.services.impl;

import com.agilmetric.dto.UserRequest;
import com.agilmetric.models.UserModel;
import com.agilmetric.repositories.UserRepository;
import com.agilmetric.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    @Override
    @Transactional
    public UserModel save(UserRequest request) {
        UserModel user = new UserModel();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPosition(request.position());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public UserModel update(UUID id, UserRequest request) {
        UserModel user = findById(id);
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPosition(request.position());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
