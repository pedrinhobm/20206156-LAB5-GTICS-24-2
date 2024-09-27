/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Tarea2_20206156.model.bean;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity

public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViaje;
    private String puntoRecojo;
    private Integer cantPersonas;
    private Integer cantPerros;
    private LocalDate fechaviaje;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="lugar_id")
    private Lugar lugar;

    public Long getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Long idViaje) {
        this.idViaje = idViaje;
    }

    public String getPuntoRecojo() {
        return puntoRecojo;
    }

    public void setPuntoRecojo(String puntoRecojo) {
        this.puntoRecojo = puntoRecojo;
    }

    public Integer getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(Integer cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public Integer getCantPerros() {
        return cantPerros;
    }

    public void setCantPerros(Integer cantPerros) {
        this.cantPerros = cantPerros;
    }

    public LocalDate getFechaviaje() {
        return fechaviaje;
    }

    public void setFechaviaje(LocalDate fechaviaje) {
        this.fechaviaje = fechaviaje;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
}
