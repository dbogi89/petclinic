package com.comtrade.service;

import com.comtrade.entity.User;
import com.comtrade.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
       return userRepository.findAll();
    }
}
