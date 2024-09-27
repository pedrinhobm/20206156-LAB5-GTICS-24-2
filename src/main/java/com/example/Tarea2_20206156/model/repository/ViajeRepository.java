package com.example.Tarea2_20206156.model.repository;
import com.example.Tarea2_20206156.model.bean.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
}

