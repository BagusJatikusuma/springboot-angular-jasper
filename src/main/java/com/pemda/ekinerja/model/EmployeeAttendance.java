package com.pemda.ekinerja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by bagus on 01/09/17.
 */
@Entity(name = "EmployeeAttendance")
@Table(name = "EmployeeAttendance")
public class EmployeeAttendance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "izin")
    private int izin;

    @Column(name = "sakit")
    private int sakit;

    @Column(name = "alpha")
    private int alpha;

    @Column(name = "periode")
    private String periode;

    public  EmployeeAttendance() {}
    public EmployeeAttendance(Employee employee, int izin, int sakit, int alpha, String periode) {
        this.employee = employee;
        this.izin = izin;
        this.sakit = sakit;
        this.alpha = alpha;
        this.periode = periode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getIzin() {
        return izin;
    }

    public void setIzin(int izin) {
        this.izin = izin;
    }

    public int getSakit() {
        return sakit;
    }

    public void setSakit(int sakit) {
        this.sakit = sakit;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }
}
