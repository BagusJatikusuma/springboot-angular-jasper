package com.pemda.ekinerja.dao;

import com.pemda.ekinerja.model.Jabatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bagus on 30/08/17.
 */
@Repository
public interface JabatanDao extends JpaRepository<Jabatan, Long>{
    Jabatan findById(String jabatanId);
    void deleteById(String jabatanId);
}
