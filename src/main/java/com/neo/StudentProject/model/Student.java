package com.neo.StudentProject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name",nullable = false)
    @Size(min=3)
    private  String firstName;
    @Column(name="last_name",nullable = false)
    @Size(min=3)
    private  String lastName;
    @Column(name="section")
    private  String section;
    @Column(name="gender")
    private  String gender;
    @Column(name="DOB")
    @NotNull
    private LocalDate dob;
    @Column(name="age")
    @Min(value =16,message="Age should be greater than 15 Years")
    @Max(value =20,message="Age should be less than or equal to 20 Years")
    private int age;
    @Column(name="MARK1")
    @NotNull(message= "mark1 is required")
    @PositiveOrZero(message = "mark1 should be positive number or zero")
    @Min(value=35,message = "mark1 should be at least 35")
    private double marks1;
    @Column(name="MARK2")
    @NotNull(message= "mark2 is required")
    @PositiveOrZero(message = "mark2 should be positive number or zero")
    @Min(value=35,message = "mark2 should be at least 35")
    private double marks2;
    @Column(name="MARK3")
    @NotNull(message= "mark3 is required")
    @PositiveOrZero(message = "mark3 should be positive number or zero")
    @Min(value=35,message = "mark3 should be at least 35")
    private double marks3;
    @Column(name="average")
    private  double average;
    @Column(name="result")
    private String result;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String section, String gender, LocalDate dob, int age, double marks1, double marks2, double marks3, double average, String result) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
        this.gender = gender;
        this.dob = dob;
        this.age = age;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        this.average = average;
        this.result = result;

        if(section!=null &&
                (section.equalsIgnoreCase("A")
                        ||section.equalsIgnoreCase("B")
                        ||section.equalsIgnoreCase("C"))) {
            this.section = section.toLowerCase();
        }else{
            throw new IllegalArgumentException("Invalid section,Allowed sections are 'A','B',and 'C'");
        }
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMarks1() {
        return marks1;
    }

    public void setMarks1(double marks1) {
        this.marks1 = marks1;
    }

    public double getMarks2() {
        return marks2;
    }

    public void setMarks2(double marks2) {
        this.marks2 = marks2;
    }

    public double getMarks3() {
        return marks3;
    }

    public void setMarks3(double marks3) {
        this.marks3 = marks3;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private double calculateAverage(){
        return (marks1+marks2+marks3)/3.0;

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", section='" + section + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", marks1=" + marks1 +
                ", marks2=" + marks2 +
                ", marks3=" + marks3 +
                ", average=" + average +
                ", result='" + result + '\'' +
                '}';
    }
}
