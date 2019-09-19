package com.example.connectingwithdatabase.controller;

import com.example.connectingwithdatabase.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/student")

public class StudentController {


        Map<Long, Student> studentMap;
        public StudentController() {
            studentMap = new HashMap<>();
            studentMap.put(1231l, new Student(1231 , "Rakib Hasan") );
            studentMap.put(1232l, new Student(1232 , "Monir Khan"));
            studentMap.put(1233l, new Student(1233 , "Rubel Hasan") );
            studentMap.put(1234l, new Student(1234 , "Mr Rahim") );
        }


        @GetMapping(value = "/findByID/{id}")
        public Student FindByID(@PathVariable long id){
            return studentMap.get(id);
        }

        @GetMapping(value = "/findAll")
        public Collection<Student> FindAllStudent(){
            return studentMap.values();
        }

        @GetMapping(value = "/insert/{id}/{name}")
        public Collection<Student> FindAllStudent(@PathVariable long id,@PathVariable String name){
            Student student  = new Student(id,name);
            studentMap.put(id,student);
            return studentMap.values();
        }



}
