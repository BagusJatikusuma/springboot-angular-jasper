package com.pemda.ekinerja.service;

import com.pemda.ekinerja.model.Departement;

import java.util.List;

/**
 * Created by bagus on 04/09/17.
 */
public interface DepartementService {
    List<Departement> getAll();
    Departement getById(String departementId);
}
