package com.usta.hotel.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table(name = "RESERVAS")

public class ReservaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //llava primaria es la auto-increment
    @Column(name="id_reserva")
    private Long idReservas;

    @NotNull
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_inicio" ,nullable = false)
    private Date fechaInicio;

    @NotNull
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_fin" ,nullable = false)
    private Date fechaFin;

    @NotNull
    @Size(min=1 ,max = 20)
    @Column(name = "estado_reserva", nullable = false)
    private String estadoReserva;

    @NotNull
    @Column(name = "cant_habitacion", nullable = false)
    private String cantHabitacion;

    //relacion de las tablas de roles
    @NotNull
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UsuarioEntity cedula;

    //conexion de habitaciones para crear la tabla de rompimiento
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "reservas_hab",
            joinColumns = @JoinColumn(name = "id_reserva",referencedColumnName = "id_reserva"), inverseJoinColumns = @JoinColumn(name="id_habitacion", referencedColumnName = "id_habitacion"))
    private Collection<HabitacionEntity> habitaciones = new ArrayList<>();









}
