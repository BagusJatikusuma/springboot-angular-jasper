package com.pemda.ekinerja.model;

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

    @NotNull
    @ManyToOne
    @JoinColumn(name = "jabatan_id")
    private Jabatan jabatan;

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

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }
}
