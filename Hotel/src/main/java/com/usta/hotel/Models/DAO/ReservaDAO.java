package com.usta.hotel.Models.DAO;

import com.usta.hotel.entities.HabitacionEntity;
import com.usta.hotel.entities.ReservaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReservaDAO extends CrudRepository<ReservaEntity,Long> {


    @Transactional
    @Query("SELECT RE  FROM ReservaEntity RE WHERE RE.idReservas=?1")
    public ReservaEntity viewDetails(long idReserva);

    @Transactional
    @Query("SELECT RE FROM ReservaEntity RE JOIN RE.habitaciones h where h= :habitacion")
    public List<ReservaEntity> findBy(@Param("habitacion") HabitacionEntity habitacion);

}
