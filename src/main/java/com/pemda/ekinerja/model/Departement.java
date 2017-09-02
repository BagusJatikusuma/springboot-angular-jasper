package com.pemda.ekinerja.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by bagus on 01/09/17.
 */
@Entity(name = "Departement")
@Table(name = "Departement")
public class Departement {
    @Id
    private String id;

    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public Departement() {}
    public Departement(String id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
