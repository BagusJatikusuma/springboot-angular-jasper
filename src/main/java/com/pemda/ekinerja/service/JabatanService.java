package com.pemda.ekinerja.service;

import com.pemda.ekinerja.model.Jabatan;

import java.util.List;

/**
 * Created by bagus on 30/08/17.
 */
public interface JabatanService {
    List<Jabatan> getAll();
    Jabatan getById(String jabatanId);
    void save(Jabatan jabatan);
    void update(Jabatan jabatan);
    void delete(String jabatanId);
}
