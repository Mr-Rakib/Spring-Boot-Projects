package com.example.examplerakibexam.controller;

import com.example.examplerakibexam.model.Student;
import com.example.examplerakibexam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "api/v1/students")


public class StudentController {
    @Autowired
    private StudentRepository studentRepository;


    @GetMapping(value = "")
    public ResponseEntity<List<Student>> findAll(){

        List<Student> allStudent = studentRepository.findAll();
        return ResponseEntity.ok(allStudent);
    }

    @PostMapping(value = "")
    public ResponseEntity<Student> insert(@RequestBody Student student){
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.created(null).body(savedStudent);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id){
        studentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
