package bd.edu.seu.newconnectiondb.controller;

import bd.edu.seu.newconnectiondb.model.Student;
import bd.edu.seu.newconnectiondb.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController() {

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> FindByID(@PathVariable long id) throws Exception {
        Student studentFound = studentService.findByID(id);
       if(studentFound.getId() == id)
        return ResponseEntity.ok(studentFound);
       else
           return ResponseEntity.badRequest().build();
        //return studentRepository.findById(id).get();
    }


    @GetMapping(value = "")
    public ResponseEntity<List<Student>> FindAll(){
        List<Student> studentList = studentService.findAll();
        return ResponseEntity.ok(studentList);
    }

    @PostMapping(value = "")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
        try {
            Student savedStudent = studentService.save(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Long> DeleteStudent(@PathVariable Long id) throws Exception {
        boolean condition = studentService.deleteById(id);
        if (condition){
            return ResponseEntity.ok(id);
        }else return ResponseEntity.notFound().build();


    }

}
