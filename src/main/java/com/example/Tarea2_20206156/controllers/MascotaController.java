package com.example.Tarea2_20206156.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.Tarea2_20206156.model.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Tarea2_20206156.model.repository.MascotaRepository;
import com.example.Tarea2_20206156.model.bean.Mascota;


@Controller
@RequestMapping("/mascotas")
public class MascotaController {
    @Autowired
    private MascotaRepository mascotaRepository;
    @Autowired
    private PersonaRepository personaRepository;



    @GetMapping
    public String listarMascotas(Model model){
        model.addAttribute("mascotas",  mascotaRepository.findAll());
        return "mascotas/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioMascota(Model model){
        model.addAttribute("lugar", new Mascota());
        model.addAttribute("personas", personaRepository.findAll());
        return "mascotas/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarLugar(@ModelAttribute Mascota mascota){
        mascotaRepository.save(mascota);
        return "redirect:/mascotas";
    }

    @GetMapping("/borrar/{id}")
    public String borrarMascota(@PathVariable Long id){
        mascotaRepository.deleteById(id);
        return "redirect:/mascotas";
    }}
