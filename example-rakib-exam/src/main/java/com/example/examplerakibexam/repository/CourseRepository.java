package com.example.examplerakibexam.repository;

import com.example.examplerakibexam.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {
}
