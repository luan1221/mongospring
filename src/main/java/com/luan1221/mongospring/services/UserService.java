package com.luan1221.mongospring.services;

import com.luan1221.mongospring.domain.User;
import com.luan1221.mongospring.dto.UserDTO;
import com.luan1221.mongospring.repositories.UserRepository;
import com.luan1221.mongospring.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public List<User> findAll() {
        return this.repository.findAll();
    }

    public User findById(String id) {
        Optional<User> optionalUser = this.repository.findById(id);
        return optionalUser.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
