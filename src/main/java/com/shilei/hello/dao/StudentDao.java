package com.shilei.hello.dao;

import com.shilei.hello.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
    private Student student;

    public Student getStudent() {
        if (student == null) {
            synchronized (this) {
                if (student == null) {
                    student = new Student();
                }
            }
        }
        return student;
    }
}
