package com.example.controller;


import com.example.domain.User;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.Result;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<User> loginController(@RequestParam String uname, @RequestParam String password) {
        User user = userService.loginService(uname, password);
        if (user!=null) {
            return Result.success(user, "登陆成功!");
        } else {
            return Result.error("123", "账号或密码错误");
        }
    }

    @PostMapping("/register")
    public Result<User> registerController(@RequestBody User newUser){
        User user = userService.registerService(newUser);
        if (user!=null) {
            return Result.success(user,"注册成功！");
        } else {
            return Result.error("456","用户名已存在！");
        }
    }
}
