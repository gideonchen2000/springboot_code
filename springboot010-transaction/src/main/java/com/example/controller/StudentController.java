package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Resource
    private StudentService service;

    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(String name, Integer age) {
        Student s1 = new Student();
        s1.setName(name);
        s1.setAge(age);

        int rows = service.addStudent(s1);
        return "add student"+rows;
    }
}
