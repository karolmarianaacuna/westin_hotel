package com.usta.hotel.Models.Services;

import com.usta.hotel.Models.DAO.ReservaDAO;
import com.usta.hotel.entities.HabitacionEntity;
import com.usta.hotel.entities.ReservaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class ReservaServiceImplement implements ReservaService {

    @Autowired
    private ReservaDAO reservaDAO;

    @Override
    @Transactional
    public List<ReservaEntity> findAll() {
        return (List<ReservaEntity> ) reservaDAO.findAll();
    }

    @Override
    @Transactional
    public void save(ReservaEntity reserva) {
        reservaDAO.save(reserva);

    }

    @Override
    @Transactional
    public ReservaEntity findById(Long id) {
        return reservaDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        reservaDAO.deleteById(id);

    }

    @Override
    @Transactional
    public ReservaEntity actualizarReserva(ReservaEntity reserva) {
        return reservaDAO.save(reserva);
    }

    @Override
    @Transactional(readOnly = true)
    public ReservaEntity viewDetails(Long id) {
        return reservaDAO.viewDetails(id);
    }

    @Override
    @Transactional
    public List<ReservaEntity> findByHab(HabitacionEntity habitacion) {
        return reservaDAO.findBy(habitacion);
    }
}
