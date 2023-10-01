package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Vivero;
import com.upb.upb.db.repository.ViveroRepository;
import com.upb.upb.db.service.ViveroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ViveroServiceImpl implements ViveroService {
    @Autowired
    ViveroRepository viveroRepository;

    @Override
    public List<Vivero> findAll() {
        List<Vivero> respuesta = viveroRepository.findAllByEstadoFalse();
        return  respuesta;
    }

    @Override
    public Vivero findById(Long id) {
        Optional<Vivero> respuesta = viveroRepository.findByIdAndEstadoFalse(id);
        return respuesta.get();
    }

    @Override
    public Long save(Vivero viveroDto) {
        Vivero vivero = new Vivero();
        vivero.setId(null);
        vivero.setNombre(viveroDto.getNombre());
        vivero.setUbicacion(viveroDto.getUbicacion());
        vivero.setEstado(viveroDto.getEstado());

        vivero = viveroRepository.save(vivero);
        return vivero.getId();
    }
}
