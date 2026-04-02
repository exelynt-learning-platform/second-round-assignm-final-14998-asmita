package com.asmita.ecommerce.service;

import com.asmita.ecommerce.entity.User;
import com.asmita.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public String register(User user) {
        repo.save(user);
        return "User Registered";
    }

    public String login(String email, String password) {
        return repo.findByEmail(email)
                .map(u -> "Login Success")
                .orElse("User not found");
    }
}
