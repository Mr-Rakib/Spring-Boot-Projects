package bd.edu.seu.newconnectiondb.repository;

import bd.edu.seu.newconnectiondb.model.Student;
import bd.edu.seu.newconnectiondb.services.StudentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    @Before
    public void deleteAll(){

    }

    @Test
    public void testCreateStudent(){

        Student student = new Student(1236l,"Mojnu Mia", LocalDate.now());
        try {
            Student savedStudent = studentService.save(student);
            assertEquals(student,savedStudent);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testDeleteStudent() throws Exception {

        Student student = new Student(1237l,"Mojnu Mia", LocalDate.now());
        Student savedStudent = studentService.save(student);
        boolean b = studentService.deleteById(savedStudent.getId());
        assertEquals(true,b);

    }


    @Test
    public void testFindAllStudents() throws Exception {

        List<Student> allfound = (List<Student>) studentRepository.findAll();
        List<Student> allStudent = studentService.findAll();
        assertEquals(allfound.size(),allStudent.size());
    }

    @Test
    public void testFindStudentById() throws Exception {

        final Student student = new Student(1235l,"Mst Komola Khatun", LocalDate.now());
        Student savedStudent = studentRepository.save(student);
        Student foundStudent = studentService.findByID(student.getId());
        assertEquals(student,foundStudent);
    }
}
