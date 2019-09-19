package bd.seu.ac.vaadindemorakib.ui;

import bd.seu.ac.vaadindemorakib.model.Student;
import bd.seu.ac.vaadindemorakib.repository.StudentRepository;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;


@Route(value = "student")
@Theme(value = Lumo.class,variant = Lumo.DARK)
public class StudentController extends VerticalLayout {
    private StudentRepository studentRepository;
    private Binder<Student> studentBinder;
    private Student studentbean;
    private  Grid<Student> studentGrid;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository  = studentRepository;

        studentbean= new Student();
        studentBinder= new Binder<>();

        studentGrid = new Grid<>();
        studentGrid
                .addColumn(Student::getId)
                .setHeader("Student ID");

        studentGrid
                .addColumn(Student ::getName)
                .setHeader("Student Name");

        studentGrid
                .addColumn(Student::getDob)
                .setHeader("Date of Birth");
        studentGrid
                .addComponentColumn(student -> getEditColumn(student))
                .setWidth("50px")
                .setFlexGrow(0);

        studentGrid
                .addComponentColumn(student -> getDeleteColumn(student))
                .setWidth("50px")
                .setFlexGrow(0);

        FormLayout formLayout = new FormLayout();

        TextField idField = new TextField("Student ID","13 Digit ID");
        TextField nameField = new TextField("Full Name","Name of the Student");
        DatePicker dateOfBirth = new DatePicker("Select Date of Birth");
        Button submit = new Button("Submit");
        studentGrid.setItems(studentRepository.findAll());

        //Binder

        studentBinder
                .forField(idField)
                .asRequired()
                .withValidator(id -> id.length() == 13,"Please provided a 13 digit ID")
                .bind(Student::getId , Student::setId);

        studentBinder
                .forField(nameField)
                .asRequired()
                .withValidator(name-> name.length() >=3,"Name Should Be 3 Letters Long")
                .withValidator(name-> name.length() <=60,"Name Shouldn't more than 60 Letters Long")
                .withValidator(name-> !name.contains("_"),"Name Should Not Contains Special Characters")
                .bind(Student::getName,Student::setName);

        studentBinder
                .forField(dateOfBirth)
                .withValidator(dob-> DAYS.between(dob,LocalDate.now()) > 16*365 ,"Student Should be at lest 16 years old")
                .bind(Student::getDob,Student::setDob);



//        studentBinder.bind(nameField,Student::getName,Student::setName);

//        studentBinder.bind(nameField,Student::getName,Student::setName);
//        studentBinder.bind(nameField,Student::getName,Student::setName);

        formLayout.add(idField,nameField,dateOfBirth,submit);
        add(formLayout,studentGrid);

        Student student1 = new Student("2016","Md ",LocalDate.now());
        studentBinder.readBean(student1);

   /*     studentGrid.addItemClickListener(event->{
            Student selectedStudent = event.getItem();
            studentBinder.readBean(selectedStudent);

           // idField.setValue(""+selectedStudent.getId());
           // nameField.setValue(selectedStudent.getName());
           // dateOfBirth.setValue(selectedStudent.getDob());
        });
*/
        submit.addClickListener(event->{
/*            Student newStudent= null;

            Long id = Long.parseLong(idField.getValue());
            String name = nameField.getValue();
            LocalDate dob = dateOfBirth.getValue();


            if( studentRepository.findById(id).isPresent()){

                Student student = new Student(id,name,dob);
                Student savedStudent = studentRepository.save(student);
                Notification.show("Imformation Updated "+savedStudent.getName());

            }else
            {
                Student student = new Student(id,name,dob);
                Student savedStudent = studentRepository.save(student);
                Notification.show("Saved "+savedStudent.getName());
            }

 */

            Student student = new Student();
            try {
                studentBinder.writeBean(student);
                Student savedStudent = studentRepository.save(student);
                Notification.show("Imformation Saved "+savedStudent.getName());
                Notification.show(student.toString());
            } catch (ValidationException e) {
                Notification.show(e.getMessage());
                e.printStackTrace();
            } catch (Exception e){
                Notification.show(e.getMessage());
            }

            studentGrid.setItems(studentRepository.findAll());
/*
            idField.clear();
            nameField.clear();
            dateOfBirth.clear();
*/
        });

    }

    private Component getDeleteColumn(Student student) {
        Button delete = new Button("Edit");
        delete.setIcon(VaadinIcon.FILE_REMOVE.create());
        delete.addClickListener(event-> {
            studentRepository.delete(student);
            studentGrid.setItems(studentRepository.findAll());
        });
        return delete;
    }

    private Component getEditColumn(Student student) {
        Button edit = new Button("Edit");
        edit.setIcon(VaadinIcon.EDIT.create());
        edit.addClickListener(event->studentBinder.readBean(student));
        return edit;
    }


}
