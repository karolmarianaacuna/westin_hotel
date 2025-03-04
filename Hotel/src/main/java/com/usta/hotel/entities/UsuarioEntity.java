package com.usta.hotel.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "USUARIOS")

public class UsuarioEntity {

    @Id
    @Column(name="cedula")
    private Long cedula;

    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_usuario", length = 40, nullable = false)
    private String nombreUsuario;

    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "apellido_usuario", length = 40, nullable = false)
    private String apellidoUsuario;



    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "ocupacion", length = 60, nullable = false)
    private String ocupacion;



    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "email", length = 40, nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "clave", length = 100, nullable = false)
    private String clave;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ciudad", length = 50, nullable = false)
    private String ciudad;

    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefono", length = 15, nullable = false)
    private String telefono;

    @NotNull
    @Column(name = "estado_usuario", columnDefinition = "boolean", nullable = false)
    private Boolean estadoUsuario;

    @NotNull
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_reg" ,nullable = false)
    private Date fechaReg;

    //relacion de las tablas de roles
    @NotNull
    @JoinColumn(name = "id_Rol", referencedColumnName = "id_Rol")
    @ManyToOne(fetch = FetchType.EAGER)

    @OnDelete(action = OnDeleteAction.CASCADE)
    private RolEntity rol;




}
