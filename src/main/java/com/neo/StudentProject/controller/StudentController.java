package com.neo.StudentProject.controller;

import com.neo.StudentProject.model.Student;
import com.neo.StudentProject.model.StudentMarksDTO;
import com.neo.StudentProject.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private  StudentService studentService;
    @PostMapping
    public ResponseEntity<Student> createStudent(@Validated @RequestBody Student student) {
        try {
            studentService.createStudent(student);
            return new ResponseEntity<Student>(student, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @PutMapping("/updateMarks/{id}")
    public ResponseEntity<Student> updateStudentMarks(@PathVariable(value="id")Long id, @RequestBody StudentMarksDTO studentMarksDTO){
        try {
            studentService.updateStudentMarks(id,studentMarksDTO);
            return new ResponseEntity<Student>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }
    }
    }
