package com.example.examplerakibexam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"code"})
@Entity
public class Sections {
    @Id
    private String id;
    private String code;
    private String faculty;
    private int sectionNumber;
    private int capacity;
    private int semesterId;

    public Sections(String code, String faculty, int sectionNumber, int capacity, int semesterId) {
        this.code = code;
        this.faculty = faculty;
        this.sectionNumber = sectionNumber;
        this.capacity = capacity;
        this.semesterId = semesterId;
        this.id = getMainID();
    }

    private  String getMainID(){
        return code+"."+sectionNumber+"."+semesterId;
    }
}
