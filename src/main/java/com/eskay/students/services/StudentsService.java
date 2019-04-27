package com.eskay.students.services;

import com.eskay.students.bean.Student;
import com.eskay.students.dao.StudentsRepository;
import com.eskay.students.entity.StudentsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    public StudentsEntity getStudent(int id) {
        Optional<StudentsEntity> student = studentsRepository.findById(id);
        return student.get();
    }

    public String recordStudentsData(StudentsEntity student) {
        studentsRepository.save(student);
        return "Hello Docker World..Save..!!!";
    }
}
