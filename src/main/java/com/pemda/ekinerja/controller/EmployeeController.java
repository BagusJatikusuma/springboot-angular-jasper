package com.pemda.ekinerja.controller;

import com.pemda.ekinerja.model.Employee;
import com.pemda.ekinerja.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bagus on 30/08/17.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired private EmployeeService employeeService;

    @RequestMapping(value = "/get-employees", method = RequestMethod.GET)
    ResponseEntity<?> getEmployees() {
        LOGGER.info("get employee");

        List<Employee> employees = employeeService.getAll();

        return new ResponseEntity<Object>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        LOGGER.info("create employee");

        employeeService.save(employee);

        return new ResponseEntity<Object>("employee created", HttpStatus.CREATED);
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

}
