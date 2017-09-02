package com.pemda.ekinerja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by bagus on 29/08/17.
 */
@Entity(name = "Employee")
@Table(name = "Employee")
public class Employee {
    @Id
    private String id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "location")
    private String location;

    @OneToOne
    @JoinColumn(name = "employee_attendance_id")
    private  EmployeeAttendance employeeAttendance;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "jabatan_id")
    private Jabatan jabatan;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    public Employee() {}

    public Employee(String id, String name, Date birthday, String location, Jabatan jabatan) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.location = location;
        this.jabatan = jabatan;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonIgnore
    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }

    @JsonIgnore
    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public EmployeeAttendance getEmployeeAttendance() {
        return employeeAttendance;
    }

    public void setEmployeeAttendance(EmployeeAttendance employeeAttendance) {
        this.employeeAttendance = employeeAttendance;
    }
}
