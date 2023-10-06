package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Arduino;
import com.upb.upb.db.model.Planta;
import com.upb.upb.db.model.Vivero;
import com.upb.upb.db.model.Vivero_arduino_planta;
import com.upb.upb.db.repository.ArduinoRepository;
import com.upb.upb.db.repository.PlantaRepository;
import com.upb.upb.db.repository.ViveroArduinoPlantaRepository;
import com.upb.upb.db.repository.ViveroRepository;
import com.upb.upb.db.service.ViveroArduinoPlantaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ViveroArduinoPlantaServiceImpl implements ViveroArduinoPlantaService {
    @Autowired
    ViveroArduinoPlantaRepository viveroArduinoPlantaRepository;
    @Autowired
    PlantaRepository plantaRepository;
    @Autowired
    ArduinoRepository arduinoRepository;
    @Autowired
    ViveroRepository viveroRepository;

    @Override
    @Transactional
    public Long save(Vivero_arduino_planta viveroArduinoPlantaDto) {
        if(viveroArduinoPlantaDto.getId() == null){ //nueva relacion vivero_arduino_planta
            Vivero_arduino_planta vap = new Vivero_arduino_planta();
            Optional<Vivero> vivero = viveroRepository.findByIdAndEstadoFalse(viveroArduinoPlantaDto.getVivero().getId());
            vap.setVivero(vivero.get());

            if(viveroArduinoPlantaDto.getPlanta() != null){ //se registra planta
                vap.setArduino(null);   //arduino null
                Planta planta = new Planta();
                planta.setEstado(false);
                planta.setNombre(viveroArduinoPlantaDto.getPlanta().getNombre());
                planta.setCaracteristica(viveroArduinoPlantaDto.getPlanta().getCaracteristica());
                planta = plantaRepository.save(planta);
                vap.setPlanta(planta);
            } else {    //Se registra arduino
                vap.setPlanta(null);    //planta null
                Arduino arduino = new Arduino();
                arduino.setEstado(false);
                arduino.setNombre(viveroArduinoPlantaDto.getArduino().getNombre());
                arduino.setSensor_actuador(viveroArduinoPlantaDto.getArduino().getSensor_actuador());
                arduino.setParametro(viveroArduinoPlantaDto.getArduino().getParametro());
                arduino= arduinoRepository.save(arduino);
                vap.setArduino(arduino);
            }
            vap = viveroArduinoPlantaRepository.save(vap);
            return vap.getId();
        }
        return null;
    }

    @Override
    public List<Vivero_arduino_planta> findAllByViveroId(Long id) {
        return viveroArduinoPlantaRepository.findAllByViveroId(id);
    }

    @Override
    public List<Vivero_arduino_planta> findAllPlantaByViveroId(Long id) {
        Optional<List<Vivero_arduino_planta>> respuesta  = viveroArduinoPlantaRepository.findAllPlantaByViveroId(id);
        if(!respuesta.isPresent())
            return null;
        return respuesta.get();
    }

    @Override
    public List<Vivero_arduino_planta> findAllArduinoByViveroId(Long id) {
        Optional<List<Vivero_arduino_planta>> respuesta  = viveroArduinoPlantaRepository.findAllArduinoByViveroId(id);
        if(!respuesta.isPresent())
            return null;
        return respuesta.get();
    }


}
