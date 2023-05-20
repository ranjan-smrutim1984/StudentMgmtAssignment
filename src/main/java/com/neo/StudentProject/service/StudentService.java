package com.neo.StudentProject.service;

import com.neo.StudentProject.model.Student;
import com.neo.StudentProject.model.StudentMarksDTO;
import com.neo.StudentProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setAge(student.getAge());
        student.setDob(student.getDob());
        student.setGender(student.getGender());
        student.setMarks1(student.getMarks1());
        student.setMarks2(student.getMarks2());
        student.setMarks3(student.getMarks3());
        student.setSection(student.getSection());
        student.setResult(student.getResult());
        student.setAverage(student.getAverage());
        studentRepository.save(student);
        return student;
    }

    public Student getStudentById(Long id) {
        Student student=null;
        List<Student> studentList=studentRepository.findAll();
        for(Student student1:studentList){
            if(student1.getId()==id)
                student=student1;
        }
        return student;

    }
    public void updateStudentMarks(Long id, StudentMarksDTO marks){
        Student student=studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with Id:"+id));
        student.setMarks1(student.getMarks1());
        student.setMarks2(student.getMarks2());
        student.setMarks3(student.getMarks3());
        studentRepository.save(student);
    }

}
