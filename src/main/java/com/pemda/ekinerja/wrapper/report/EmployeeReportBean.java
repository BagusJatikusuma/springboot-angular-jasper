package com.pemda.ekinerja.wrapper.report;

import java.util.Date;

/**
 * Created by bagus on 01/09/17.
 */
public class EmployeeReportBean {
    private String id;
    private String name;
    private Date birthday;
    private String location;
    private String jabatanName;
    private String departementName;

    public EmployeeReportBean() {}
    public EmployeeReportBean(String id, String name, Date birthday, String location, String jabatanName, String departementName) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.location = location;
        this.jabatanName = jabatanName;
        this.departementName = departementName;
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

    public String getJabatanName() {
        return jabatanName;
    }

    public void setJabatanName(String jabatanName) {
        this.jabatanName = jabatanName;
    }

    public String getDepartementName() {
        return departementName;
    }

    public void setDepartementName(String departementName) {
        this.departementName = departementName;
    }
}
