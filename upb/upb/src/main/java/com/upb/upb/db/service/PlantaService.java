package com.upb.upb.db.service;

import com.upb.upb.db.model.Planta;

import java.util.List;

public interface PlantaService {
    List<Planta> findAll();
    Planta findById(Long id);
    Long save(Planta plantaDto);
}
