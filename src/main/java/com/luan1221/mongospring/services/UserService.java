package com.luan1221.mongospring.services;

import com.luan1221.mongospring.domain.User;
import com.luan1221.mongospring.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public List<User> findAll() {
        return this.repository.findAll();
    }
}
