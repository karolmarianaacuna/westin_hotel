package com.usta.hotel.Models.DAO;


import com.usta.hotel.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioDAO extends CrudRepository<UsuarioEntity,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE UsuarioEntity  SET estadoUsuario=false WHERE cedula=?1")
    public void changeState(long cedula);

    @Transactional
    @Modifying
    @Query("SELECT US  FROM UsuarioEntity US WHERE US.email=?1")
    public void findByEmail(long email);

}
