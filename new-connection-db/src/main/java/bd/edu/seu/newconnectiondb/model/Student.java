package bd.edu.seu.newconnectiondb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = {"id","name"})
@Entity
public class Student {

    @Id
    private Long id;
    private String name;
    private LocalDate dob;
}
