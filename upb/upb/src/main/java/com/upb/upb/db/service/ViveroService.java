package com.upb.upb.db.service;

import com.upb.upb.db.model.Vivero;

import java.util.List;

public interface ViveroService {
    List<Vivero> findAll();
    Vivero findById(Long id);
    Long save(Vivero viveroDto);
}
