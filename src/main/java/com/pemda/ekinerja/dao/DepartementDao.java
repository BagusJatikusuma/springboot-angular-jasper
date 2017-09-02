package com.pemda.ekinerja.dao;

import com.pemda.ekinerja.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bagus on 01/09/17.
 */
@Repository
public interface DepartementDao extends JpaRepository<Departement, Long> {
    Departement findById(String departementId);
    void deleteById(String departementId);
}
