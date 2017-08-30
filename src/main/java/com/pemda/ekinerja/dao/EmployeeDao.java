package com.pemda.ekinerja.dao;

import com.pemda.ekinerja.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bagus on 30/08/17.
 */
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
    Employee findById(String employeeId);
    void deleteById(String employeeId);
}
