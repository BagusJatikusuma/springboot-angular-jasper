package com.pemda.ekinerja.controller;

import com.pemda.ekinerja.model.Jabatan;
import com.pemda.ekinerja.service.JabatanService;
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
@RequestMapping("/jabatan")
public class JabatanController {
    public static final Logger LOGGER = LoggerFactory.getLogger(JabatanController.class);

    @Autowired private JabatanService jabatanService;

    @RequestMapping(value = "/get-jabatans", method = RequestMethod.GET)
    ResponseEntity<?> getJabatans() {
        List<Jabatan> jabatans = jabatanService.getAll();

        return new ResponseEntity<Object>(jabatans, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseEntity<?> createJabatan(@RequestBody Jabatan jabatan) {
        jabatanService.save(jabatan);

        return new ResponseEntity<Object>("jabatan created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    ResponseEntity<?> updateJabatan(@RequestBody Jabatan jabatan) {
        jabatanService.update(jabatan);

        return new ResponseEntity<Object>("jabatan updated",HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteJabatan(@PathVariable("jabatanId") String jabatanId) {
        jabatanService.delete(jabatanId);

        return new ResponseEntity<Object>("jabatan deleted", HttpStatus.OK);
    }

}
