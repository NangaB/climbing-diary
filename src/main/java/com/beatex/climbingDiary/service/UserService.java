package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.Role;
import com.beatex.climbingDiary.model.User;
import com.beatex.climbingDiary.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    public Role getRole(String username){
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElseThrow(()->new UsernameNotFoundException("User not found")).getRole();
    }

    @Transactional
    public void deleteUser(Long id){
        userRepository.deleteUser(id);
    }

    public List<String> getAllUsers(){
        return userRepository.findAllUsers();
    }


}
