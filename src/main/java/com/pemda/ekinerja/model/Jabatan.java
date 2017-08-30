package com.pemda.ekinerja.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bagus on 30/08/17.
 */
@Entity(name = "Jabatan")
@Table(name = "Jabatan")
public class Jabatan {
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "jabatan", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Jabatan() {}
    public Jabatan(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Jabatan(String id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
