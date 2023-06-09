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
    private StudentService studentService;
    @RequestMapping("/student/query")
    @ResponseBody
    public String queryStudent(Integer id) {

        Student student = studentService.queryStudent(id);
        return student.toString();
    }
}
