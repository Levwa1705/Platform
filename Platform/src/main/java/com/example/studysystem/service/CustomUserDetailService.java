package com.example.studysystem.service;

import com.example.studysystem.dao.UserRepository;
import com.example.studysystem.model.CustomUserDetail;
import com.example.studysystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findUserByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("Пользователь не найден"));
        return user.map(CustomUserDetail::new).get();




    }
}
