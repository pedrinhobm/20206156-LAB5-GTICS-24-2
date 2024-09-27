package com.example.Tarea2_20206156.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Tarea2_20206156.model.bean.Lugar;
@Repository
public interface LugarRepository extends JpaRepository< Lugar, Long> {

}
