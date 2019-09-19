package bd.edu.seu.newconnectiondb.services;


import bd.edu.seu.newconnectiondb.exceptions.ResoueceNotFoundException;
import bd.edu.seu.newconnectiondb.exceptions.ResourceAlreadyExistException;
import bd.edu.seu.newconnectiondb.model.Student;
import bd.edu.seu.newconnectiondb.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student findByID(long id)throws Exception {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent())
            return optionalStudent.get();

        else
            throw new ResoueceNotFoundException(""+id);
    }


    public Student save(Student student) throws Exception{
        if (! studentRepository.findById(student.getId()).isPresent()) {
            Student savedStudent = studentRepository.save(student);
            return savedStudent;
        }else throw new ResourceAlreadyExistException(""+student.getId());
    }

    public boolean deleteById(long id) throws Exception {
        if (studentRepository.findById(id).isPresent()) {
           studentRepository.deleteById(id);
           return true;
        }else throw new ResourceAlreadyExistException(""+id);
    }

    public List<Student> findAll() {
        List<Student> allStudent = new ArrayList<>();
       studentRepository.findAll().forEach(allStudent::add);
       return allStudent;

    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
