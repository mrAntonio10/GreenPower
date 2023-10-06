package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Planta;
import com.upb.upb.db.repository.PlantaRepository;
import com.upb.upb.db.service.PlantaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class PlantaServiceImpl implements PlantaService {
    @Autowired
    PlantaRepository plantaRepository;


    @Override
    public List<Planta> findAll() {
        return plantaRepository.findAllByEstadoFalse();
    }

    @Override
    public Planta findById(Long id) {
        Optional<Planta> respuesta = plantaRepository.findByIdAndEstadoFalse(id);
        if(!respuesta.isPresent())
            throw new NoSuchElementException("Planta no encontrada");
        return respuesta.get();
    }

    @Override
    public Long save(Planta plantaDto) {
        if(plantaDto.getId() == null){ //nueva planta
            Planta planta = new Planta();
            planta.setNombre(plantaDto.getNombre());
            planta.setEstado(false);
            planta.setCaracteristica(plantaDto.getCaracteristica());

            planta = plantaRepository.save(planta);

            return planta.getId();
        } else {    //actualizar planta
            Optional<Planta> plantaOpt = plantaRepository.findByIdAndEstadoFalse(plantaDto.getId());
            if(!plantaOpt.isPresent()){
                throw new NoSuchElementException("Planta no encontrada");
            }
            Planta planta = plantaOpt.get();

            planta.setNombre(plantaDto.getNombre());
            planta.setEstado(plantaDto.getEstado());
            planta.setCaracteristica(plantaDto.getCaracteristica());

            planta = plantaRepository.save(planta);
            return planta.getId();
        }
    }
}
