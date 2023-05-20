package com.neo.StudentProject.repository;

import com.neo.StudentProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
