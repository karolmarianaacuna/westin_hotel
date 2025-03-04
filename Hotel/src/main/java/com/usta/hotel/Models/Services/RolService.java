package com.usta.hotel.Models.Services;


import com.usta.hotel.entities.RolEntity;

import java.util.List;

public interface RolService {

    public List<RolEntity> findAll();
    public void save(RolEntity rol);
    public RolEntity findById(Long id);
    public void deleteById(Long id) ;
    public RolEntity actualizarRol(RolEntity rol);

}
