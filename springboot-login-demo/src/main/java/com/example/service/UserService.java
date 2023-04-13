package com.example.service;

import com.example.domain.User;

public interface UserService {

    User loginService(String uname, String password);


    User registerService(User user);

}
