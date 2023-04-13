package com.example.repository;

import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    //通过用户名uname查找用户
    User findByUname(String uname);
    //通过用户名uname和密码查找用户
    User findByUnameAndPassword(String uname, String password);
}
