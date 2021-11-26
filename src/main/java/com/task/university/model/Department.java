package com.task.university.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "departments")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private List<Lector> lectors;
    @Column(name = "lector_head_id")
    private Long lectorHeadId;

    public Department() {
    }

    public Department(String name, Long lectorHeadId) {
        this.name = name;
        this.lectorHeadId = lectorHeadId;
    }
}
