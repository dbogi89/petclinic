package com.comtrade.api;

import com.comtrade.entity.User;
import com.comtrade.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
@CrossOrigin
public class UserApi {

    private final UserService userService;
    @GetMapping("")
    public List<User> findAll(){
       return userService.findAll();
    }

}
