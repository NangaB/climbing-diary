package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.User;
import com.beatex.climbingDiary.repository.UserRepository;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class UserRepositoryUserDetailService{
//        implements UserDetailsService {

//    private UserRepository userRepository;
//
//    public UserRepositoryUserDetailService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(s);
//        if(user != null){
//            return user;
//        }
//        throw new UsernameNotFoundException("Użytkownik " + s + " nie został znaleziony");
//    }
}
