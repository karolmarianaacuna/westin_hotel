package com.usta.hotel.Models.DAO;

import com.usta.hotel.entities.HabitacionEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface HabitacionDAO extends CrudRepository<HabitacionEntity,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE HabitacionEntity  SET disponibilidad=false WHERE idHabitacion=?1")
    public void changeState(long idHabitacion);

    @Transactional
    @Query("SELECT HA  FROM HabitacionEntity HA WHERE HA.idHabitacion=?1")
    public HabitacionEntity viewDetails(long idHabitacion);
}
