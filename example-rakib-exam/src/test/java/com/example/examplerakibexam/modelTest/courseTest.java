package com.example.examplerakibexam.modelTest;

import com.example.examplerakibexam.model.Course;
import com.example.examplerakibexam.model.Sections;
import com.example.examplerakibexam.repository.CourseRepository;
import com.example.examplerakibexam.repository.SectionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest

public class courseTest {

    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void createCourse(){
        Course course = new Course("CSE4047","Advance Java",3);
        Course course1 = new Course("CSE4048","Advance Java Lab",1);

        Sections section = new Sections(course.getCode(),"KMH",1,30,52);
        Sections section1 = new Sections(course1.getCode(),"KMH",1,30,52);


        Sections savedSection = sectionRepository.save(section);
        sectionRepository.save(section1);

        courseRepository.save(course);
        courseRepository.save(course1);


        System.out.println(course);
        System.out.println(course1);

        System.out.println(section);
        System.out.println(section1);


        assertEquals(section,savedSection);

    }
}
