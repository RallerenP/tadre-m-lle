package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.dto.AddUserDTO;
import com.mchg.tadremoelle.models.User;
import com.mchg.tadremoelle.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        return this.userRepository.findByUsernameAndPassword(username, password);
    }

    public User add(AddUserDTO dto) {
        if (this.findUserByUsername(dto.getUsername()) != null) {
            return null;
        }
        return userRepository.save(this.transform(dto));
    }

    public User transform(AddUserDTO dto) {
        User u = new User();
        u.setUsername(dto.getUsername());
        u.setPassword(dto.getPassword());
        u.setEmail(dto.getEmail());
        return u;
    }
}
