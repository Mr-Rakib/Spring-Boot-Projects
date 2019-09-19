package com.example.connectingwithdatabase;

import com.example.connectingwithdatabase.model.Student;
import com.example.connectingwithdatabase.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.helger.commons.mock.CommonsAssert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConnectingWithDatabaseApplicationTests {
@Autowired
    StudentRepository studentRepository;

    @Test
    public void contextLoads() {
        Student student = new Student(123456l,"Mst Khairul Hasnat");
        Student savedStudent = studentRepository.save(student);
        assertEquals(student,savedStudent);

    }

}
