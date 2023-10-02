package com.upb.upb.db.service;

import com.upb.upb.db.model.Vivero_arduino_planta;

import java.util.List;

public interface ViveroArduinoPlantaService {
    Long save(Vivero_arduino_planta viveroArduinoPlantaDto);
    List<Vivero_arduino_planta> findAllByViveroId(Long id);

    List<Vivero_arduino_planta> findAllPlantaByViveroId(Long id);

    List<Vivero_arduino_planta> findAllArduinoByViveroId(Long id);
}
