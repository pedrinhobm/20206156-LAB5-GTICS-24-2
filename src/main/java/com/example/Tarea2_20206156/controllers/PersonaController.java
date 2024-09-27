package com.example.Tarea2_20206156.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.Tarea2_20206156.model.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Tarea2_20206156.model.repository.PersonaRepository;
import com.example.Tarea2_20206156.model.bean.Persona;


@Controller
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public String listarPersonas(Model model){
        model.addAttribute("personas", personaRepository.findAll());
        return "personas/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioPersona(Model model){
        model.addAttribute("persona", new Persona());
        return "personas/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarPersona(@ModelAttribute Persona persona){
        personaRepository.save(persona);
        return "redirect:/personas";
    }

    @GetMapping("/borrar/{id}")
    public String borrarPersona(@PathVariable Long id){
        personaRepository.deleteById(id);
        return "redirect:/personas";
    }


}
