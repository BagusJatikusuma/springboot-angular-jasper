package com.pemda.ekinerja.controller;

import com.pemda.ekinerja.ReportApplication;
import com.pemda.ekinerja.model.Employee;
import com.pemda.ekinerja.service.DepartementService;
import com.pemda.ekinerja.service.EmployeeService;
import com.pemda.ekinerja.service.JabatanService;
import com.pemda.ekinerja.wrapper.input.CreateEmployeeWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by bagus on 30/08/17.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired private EmployeeService employeeService;
    @Autowired private DepartementService departementService;
    @Autowired private JabatanService jabatanService;
    @Autowired private ReportApplication reportApplication;

    @RequestMapping(value = "/get-employees", method = RequestMethod.GET)
    ResponseEntity<?> getEmployees() {
        LOGGER.info("get employee");

        List<Employee> employees = employeeService.getAll();

        return new ResponseEntity<Object>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseEntity<?> createEmployee(@RequestBody CreateEmployeeWrapper createEmployeeWrapper) {
        LOGGER.info("create employee :");

        LOGGER.info(createEmployeeWrapper.getName());
        LOGGER.info(String.valueOf(createEmployeeWrapper.getBirthday()));
        LOGGER.info(createEmployeeWrapper.getLocation());
        LOGGER.info(createEmployeeWrapper.getDepartement());
        LOGGER.info(createEmployeeWrapper.getJabatan());

        Employee employee = new Employee();

        employee.setId(String.valueOf(new Date()));
        employee.setName(createEmployeeWrapper.getName());
        employee.setBirthday(createEmployeeWrapper.getBirthday());
        employee.setLocation(createEmployeeWrapper.getLocation());
        employee.setDepartement(
                departementService.getById(createEmployeeWrapper.getDepartement())
        );
        employee.setJabatan(
                jabatanService.getById(createEmployeeWrapper.getJabatan())
        );

        employeeService.save(employee);

        return new ResponseEntity<Object>(employeeService.getById(employee.getId()), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    ResponseEntity<?> updateJabatan(@RequestBody Employee employee) {
        LOGGER.info("update employee");

        employeeService.update(employee);

        return new ResponseEntity<Object>("employee updated", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") String employeeId) {
        LOGGER.info("delete employee"+employeeId);

        employeeService.delete(employeeId);

        return new ResponseEntity<Object>("employee deleted", HttpStatus.OK);
    }

    @RequestMapping(value = "/create-report", method = RequestMethod.GET)
    ResponseEntity<?> createReport() {
        LOGGER.info("create report server");

        reportApplication.createReport();

        return new ResponseEntity<Object>("success create report", HttpStatus.OK);
    }

}
