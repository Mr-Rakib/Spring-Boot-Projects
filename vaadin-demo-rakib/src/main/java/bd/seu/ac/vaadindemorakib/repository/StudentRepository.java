package bd.seu.ac.vaadindemorakib.repository;

import bd.seu.ac.vaadindemorakib.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {
    List<Student> findAllByName(String name);
    List<Student> findAllByNameContaining(String name);
    List<Student> findAllByDobAfter(LocalDate localDate);

}
