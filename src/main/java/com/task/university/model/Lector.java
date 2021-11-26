package com.task.university.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "lectors")
@Data
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Degree degree;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private double salary;

    public Lector() {
    }

    public Lector(String firstName, String lastName, double salary, Degree degree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.degree = degree;
    }
}
