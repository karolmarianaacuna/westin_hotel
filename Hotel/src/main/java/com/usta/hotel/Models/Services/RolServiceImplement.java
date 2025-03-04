package com.usta.hotel.Models.Services;

import com.usta.hotel.Models.DAO.ReservaDAO;
import com.usta.hotel.Models.DAO.RolDAO;
import com.usta.hotel.entities.ReservaEntity;
import com.usta.hotel.entities.RolEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolServiceImplement implements RolService{

    @Autowired
    private RolDAO rolDAO;

    @Override
    @Transactional
    public List<RolEntity> findAll() {
        return (List<RolEntity> ) rolDAO.findAll();
    }

    @Override
    @Transactional
    public void save(RolEntity rol) {
        rolDAO.save(rol);

    }

    @Override
    @Transactional
    public RolEntity findById(Long id) {
        return rolDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        rolDAO.deleteById(id);


    }

    @Override
    @Transactional
    public RolEntity actualizarRol(RolEntity rol) {
        return rolDAO.save(rol);
    }
}
