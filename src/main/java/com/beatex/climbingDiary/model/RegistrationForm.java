package com.beatex.climbingDiary.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Data
public class RegistrationForm {

    private String username;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder){
//        Set<Role> roles = new HashSet<>();
//        Role role = new Role("USER");
//        roles.add(Role.USER);
        return new User(username, passwordEncoder.encode(password), Role.USER);
    }
}
