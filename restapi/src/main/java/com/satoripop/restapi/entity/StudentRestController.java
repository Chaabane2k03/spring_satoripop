package com.satoripop.restapi.entity;


import com.satoripop.restapi.rest.StudentErrorResponse;
import com.satoripop.restapi.rest.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students ;

    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.add(new Student("Chaabane", "Boussadia"));
        students.add(new Student("David", "Davidson"));
        students.add(new Student("Felix", "mocha"));
    }



    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }


    //define an endpoint for a single student by id
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException("Student not found -" + studentId);
        }

        return students.get(studentId);
    }


    /*@ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //Add another exception handler :
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }*/




}
