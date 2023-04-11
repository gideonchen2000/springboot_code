package com.example.service.impl;

import com.example.dao.StudentDao;
import com.example.model.Student;
import com.example.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;
    @Override
    public Student queryStudent(Integer id) {
        Student student = studentDao.selectById(id);
        return student;
    }
}
