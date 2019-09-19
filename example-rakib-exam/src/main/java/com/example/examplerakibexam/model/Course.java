package com.example.examplerakibexam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"code"})
@Entity
public class Course {

    @Id
    private String code;

    private String title;
    private int credit;


}
