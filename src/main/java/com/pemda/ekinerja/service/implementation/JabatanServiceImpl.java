package com.pemda.ekinerja.service.implementation;

import com.pemda.ekinerja.dao.JabatanDao;
import com.pemda.ekinerja.model.Jabatan;
import com.pemda.ekinerja.service.JabatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bagus on 30/08/17.
 */
@Service("JabatanService")
public class JabatanServiceImpl implements JabatanService {
    @Autowired
    private JabatanDao jabatanDao;

    @Override
    public List<Jabatan> getAll() {
        List<Jabatan> jabatans = jabatanDao.findAll();

        return jabatans;
    }

    @Override
    public Jabatan getById(String jabatanId) {
        Jabatan jabatan = jabatanDao.findById(jabatanId);

        return jabatan;
    }

    @Override
    public void save(Jabatan jabatan) {
        jabatanDao.save(jabatan);
    }

    @Override
    public void update(Jabatan jabatan) {
        jabatanDao.save(jabatan);
    }

    @Override
    public void delete(String jabatanId) {
        jabatanDao.deleteById(jabatanId);
    }
}
