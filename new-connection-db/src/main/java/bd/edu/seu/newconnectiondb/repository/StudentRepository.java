package bd.edu.seu.newconnectiondb.repository;

import bd.edu.seu.newconnectiondb.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
