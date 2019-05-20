package com.shilei.hello.service.impl;

import com.shilei.hello.dao.StudentDao;
import com.shilei.hello.model.Student;
import com.shilei.hello.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl(@Autowired StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Integer upGrade() {
        Student student = studentDao.getStudent();
        student.setGrade(student.getGrade() + 1);
        return student.getGrade();
    }

    @Override
    public Integer downGrade() {
        Student student = studentDao.getStudent();
        student.setGrade(student.getGrade() - 1);
        return student.getGrade();
    }

    @Override
    public Integer getGrade() {
        Student student = studentDao.getStudent();
        return student.getGrade();
    }
}
