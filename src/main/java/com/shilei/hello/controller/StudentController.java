package com.shilei.hello.controller;

import com.shilei.hello.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(@Autowired StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/up")
    public String up() {
        return String.valueOf(studentService.upGrade());
    }

    @RequestMapping("/down")
    public String down() {
        return String.valueOf(studentService.downGrade());
    }

    @RequestMapping("/get")
    public String get() {
        return String.valueOf(studentService.getGrade());
    }
}
