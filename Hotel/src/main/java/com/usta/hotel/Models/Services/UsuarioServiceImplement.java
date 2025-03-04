package com.usta.hotel.Models.Services;

import com.usta.hotel.entities.UsuarioEntity;

import java.util.List;

public class UsuarioServiceImplement implements UsuarioService{
    @Override
    public List<UsuarioEntity> findAll() {
        return List.of();
    }

    @Override
    public void save(UsuarioEntity usuario) {

    }

    @Override
    public UsuarioEntity findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        return null;
    }

    @Override
    public UsuarioEntity viewDetails(Long id) {
        return null;
    }

    @Override
    public UsuarioEntity findByEmail(String email) {
        return null;
    }
}
