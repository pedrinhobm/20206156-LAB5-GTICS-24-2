package com.example.Tarea2_20206156.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.Tarea2_20206156.model.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Tarea2_20206156.model.repository.LugarRepository;
import com.example.Tarea2_20206156.model.bean.Lugar;


@Controller
@RequestMapping("/lugares")
public class LugarController {
    @Autowired
    private LugarRepository lugarRepository;


    @GetMapping
    public String listarLugares(Model model){
        model.addAttribute("lugares",  lugarRepository.findAll());
        return "lugares/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioLugar(Model model){
        model.addAttribute("lugar", new Lugar());
        return "lugares/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarLugar(@ModelAttribute Lugar lugar){
        lugarRepository.save(lugar);
        return "redirect:/lugares";
    }

    @GetMapping("/borrar/{id}")
    public String borrarLugar(@PathVariable Long id){
        lugarRepository.deleteById(id);
        return "redirect:/lugares";
    }}
