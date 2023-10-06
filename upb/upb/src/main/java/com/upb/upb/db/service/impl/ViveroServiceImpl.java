package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Vivero;
import com.upb.upb.db.repository.ViveroRepository;
import com.upb.upb.db.service.ViveroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class ViveroServiceImpl implements ViveroService {
    @Autowired
    ViveroRepository viveroRepository;

    @Override
    public List<Vivero> findAll() {
        return  viveroRepository.findAllByEstadoFalse();
    }

    @Override
    public Vivero findById(Long id) {
        Optional<Vivero> respuesta = viveroRepository.findByIdAndEstadoFalse(id);
        if(!respuesta.isPresent())
            throw new NoSuchElementException("Vivero no encontrada");
        return respuesta.get();
    }

    @Override
    public Long save(Vivero viveroDto) {
        if( viveroDto.getId() == null) {    //nuevo vivero
            Vivero vivero = new Vivero();
            vivero.setId(null);
            vivero.setNombre(viveroDto.getNombre());
            vivero.setUbicacion(viveroDto.getUbicacion());
            vivero.setEstado(viveroDto.getEstado());

            vivero = viveroRepository.save(vivero);
            return vivero.getId();
        } else {
            //actualizar planta
            Optional<Vivero> viveroOpt = viveroRepository.findByIdAndEstadoFalse(viveroDto.getId());
            if(!viveroOpt.isPresent()){
                throw new NoSuchElementException("Vivero no encontrada");
            }
            Vivero vivero = viveroOpt.get();

            vivero.setNombre(viveroDto.getNombre());
            vivero.setEstado(viveroDto.getEstado());
            vivero.setUbicacion(viveroDto.getUbicacion());

            vivero = viveroRepository.save(vivero);
            return vivero.getId();
        }
    }
}
