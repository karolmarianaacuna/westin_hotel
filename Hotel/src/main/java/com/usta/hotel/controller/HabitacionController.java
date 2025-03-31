package com.usta.hotel.controller;

import com.usta.hotel.Models.Services.HabitacionService;
import com.usta.hotel.entities.HabitacionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;
    @GetMapping(value="/habitaciona")
    public String listarHabitacion(Model model) {
        model.addAttribute("tittle", "Room list");
        model.addAttribute("urlRegistro", "/createHabitacion");
        List<HabitacionEntity> lista = habitacionService.findAll();
        model.addAttribute("habitaciones", lista);
        return "/habitaciones/listarHabitaciones";

    }

}
