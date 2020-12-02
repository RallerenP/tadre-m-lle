package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.dto.AddUserDTO;
import com.mchg.tadremoelle.dto.LoginDTO;
import com.mchg.tadremoelle.models.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class AuthService {

    private IHashService hashService;
    private UserService userService;

    public AuthService(IHashService hashService, UserService userService) {
        this.hashService = hashService;
        this.userService = userService;
    }

    public boolean signUp(AddUserDTO dto) {
        dto.setPassword(this.hashService.hash(dto.getPassword()));
        if (this.userService.add(dto) != null)
            return true;
        else
            return false;

    }

    public User login(LoginDTO dto) {
        User found = this.userService.findUserByUsername(dto.getUsername());
        if (found == null) {
            return null;
        }

        if (!this.hashService.verify(found.getPassword(), dto.getPassword())) {
            return null;
        }

        return found;
    }

}
