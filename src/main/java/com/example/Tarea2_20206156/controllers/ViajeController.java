package com.example.Tarea2_20206156.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.Tarea2_20206156.model.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Tarea2_20206156.model.repository.ViajeRepository;
import com.example.Tarea2_20206156.model.bean.Viaje;


@Controller
@RequestMapping("/viajes")
public class ViajeController {
    @Autowired
    private LugarRepository lugarRepository;

    @Autowired
    private ViajeRepository viajeRepository;

    @GetMapping
    public String listarViajes(Model model){
        model.addAttribute("viajes",  viajeRepository.findAll());
        return "viajes/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioViaje(Model model){
        model.addAttribute("viaje", new Viaje());
        model.addAttribute("lugares", lugarRepository.findAll());
        return "viajes/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarViaje(@ModelAttribute Viaje viaje){
        viajeRepository.save(viaje);
        return "redirect:/viajes";
    }

    @GetMapping("/borrar/{id}")
    public String borrarViaje(@PathVariable Long id){
        viajeRepository.deleteById(id);
        return "redirect:/viajes";
    }


}