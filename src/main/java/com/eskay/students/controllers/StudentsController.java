package com.eskay.students.controllers;

import com.eskay.students.bean.Student;
import com.eskay.students.entity.StudentsEntity;
import com.eskay.students.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eskay.students.dao.StudentsRepository;

@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students/{id}")
    public StudentsEntity getStudent(@PathVariable int id) {
        return studentsService.getStudent(id);
    }

    @GetMapping("/studentsnew/{id}")
    public StudentsEntity getStudentAnotherMethod(@PathVariable int id) {
        System.out.println("sysout statement");
        return studentsService.getStudent(id);
    }

    @PostMapping("/students")
    public String recordStudentsData(@RequestBody StudentsEntity student) {
        return studentsService.recordStudentsData(student);
    }
}
