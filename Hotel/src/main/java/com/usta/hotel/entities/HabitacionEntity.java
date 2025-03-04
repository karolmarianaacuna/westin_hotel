package com.usta.hotel.entities;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name = "HABITACIONES")

//serializable es para el auto-increment
// si aparece rojo es que no reconoce la accion, si aparece subrayado es que fakta que complete info.

public class HabitacionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_habitacion")
    private Long idHabitacion;

    @NotNull
    @Size(min=1, max=20)
    @Column(name = "tipo_hab", length = 20, nullable = false)
    private String tipoHab;

    @NotNull
    @Column(name="precio_hab",nullable = false, scale = 2, precision = 10)
    private BigDecimal precioHab;

    @NotNull
    @Column(name = "disponibilidad", nullable = false, columnDefinition = "boolean")
    private boolean disponibilidad;

    @NotNull
    @Size(min=20,max=200)
    @Column(name = "foto_hab", length = 200, nullable = false)
    private String fotoHab;

    @NotNull
    @Column(name = "capacidad_hab", nullable = false)
    private int capacidadHab;

    @ManyToMany(mappedBy = "habitaciones")
    private Set<ReservaEntity> reservas;

}
