package com.example.examplerakibexam.repository;

import com.example.examplerakibexam.model.Sections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository extends CrudRepository<Sections,String> {
}
