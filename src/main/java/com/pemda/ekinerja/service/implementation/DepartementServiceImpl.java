package com.pemda.ekinerja.service.implementation;

import com.pemda.ekinerja.dao.DepartementDao;
import com.pemda.ekinerja.model.Departement;
import com.pemda.ekinerja.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bagus on 04/09/17.
 */
@Service("DepartementService")
@Transactional
public class DepartementServiceImpl implements DepartementService{
    @Autowired
    private DepartementDao departementDao;

    @Override
    public List<Departement> getAll() {
        return departementDao.findAll();
    }

    @Override
    public Departement getById(String departementId) {
        return departementDao.findById(departementId);
    }
}
