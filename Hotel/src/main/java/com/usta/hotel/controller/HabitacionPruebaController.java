package com.usta.hotel.controller;

import com.usta.hotel.Models.Services.HabitacionService;
import com.usta.hotel.Models.Services.ReservaService;
import com.usta.hotel.entities.HabitacionEntity;
import com.usta.hotel.entities.ReservaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Comparator;
import java.util.List;

@Controller
public class HabitacionPruebaController {

    @Autowired
    private HabitacionService habitacionServicePrueba;

    @Autowired
    private ReservaService reservaService;

    @GetMapping(value="/habitacionesProtalPrueba")
    public String listarHabitacion(Model model) {
        model.addAttribute("tittle", "Room list");
        model.addAttribute("urlRegistro", "/createHabitacion");
        List<HabitacionEntity> lista = habitacionServicePrueba.findAll();
        lista.sort(Comparator.comparing(HabitacionEntity::getIdHabitacion));
        model.addAttribute("habitaciones", lista);
        return "/habitaciones/listarHabitaciones2";


    }
    /* ********************************************************************* */
    @PostMapping(value="/eliminarHab/{id}")
    public String eliminarHabitacion(@PathVariable (value="id")Long id, RedirectAttributes redirectAttributes) {
        if (id>0){
            HabitacionEntity habitacion = habitacionServicePrueba.findById(id);
            if (habitacion != null){
                List<ReservaEntity> reservas = reservaService.findByHab(habitacion);
                if (!reservas.isEmpty()){
                    redirectAttributes.addFlashAttribute("error","Cannot delete room : There are reservations associated");
                    return "redirect:/habitacionesProtalPrueba";
                }
            }
            habitacionServicePrueba.deleteById(id);
            redirectAttributes.addFlashAttribute("success","Room delete successfully");
        }else{
            redirectAttributes.addFlashAttribute("error","invalid ID");
        }
        return "redirect:/habitacionesProtalPrueba";
    }



}
