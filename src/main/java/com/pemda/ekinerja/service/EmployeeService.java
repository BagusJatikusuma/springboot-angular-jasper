package com.pemda.ekinerja.service;

import com.pemda.ekinerja.model.Employee;

import java.util.List;

/**
 * Created by bagus on 30/08/17.
 */
public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(String employeeId);
    void save(Employee employee);
    void update(Employee employee);
    void delete(String employeeId);
}
