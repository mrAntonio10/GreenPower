package com.upb.upb.db.repository;

import com.upb.upb.db.model.Vivero_arduino_planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ViveroArduinoPlantaRepository extends JpaRepository<Vivero_arduino_planta, Long> {
    @Query("SELECT vap FROM Vivero_arduino_planta vap" +
            " WHERE vap.vivero.id = :id AND vap.planta.id != null AND vap.planta.estado = false")
    Optional<List<Vivero_arduino_planta>> findAllPlantaByViveroId(@Param("id") Long id);

    @Query("SELECT vap FROM Vivero_arduino_planta vap" +
            " WHERE vap.vivero.id = :id AND vap.arduino.id != null AND vap.arduino.estado = false")
    Optional<List<Vivero_arduino_planta>> findAllArduinoByViveroId(@Param("id") Long id);

    List<Vivero_arduino_planta> findAllByViveroId(@Param("viveroId") Long id);
}
