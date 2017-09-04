package com.pemda.ekinerja.service.implementation;

import com.pemda.ekinerja.dao.EmployeeDao;
import com.pemda.ekinerja.model.Employee;
import com.pemda.ekinerja.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bagus on 30/08/17.
 */
@Service("EmployeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = employeeDao.findAll();

        return employees;
    }

    @Override
    public Employee getById(String employeeId) {
        Employee employee = employeeDao.findById(employeeId);

        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void delete(String employeeId) {
        employeeDao.deleteById(employeeId);
    }
}
