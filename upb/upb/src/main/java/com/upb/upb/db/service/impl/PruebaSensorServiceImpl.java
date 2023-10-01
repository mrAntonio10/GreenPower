package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.PruebaSensor;
import com.upb.upb.db.repository.PruebaSensorRepository;
import com.upb.upb.db.service.PruebaSensorService;
import com.upb.upb.dto.PruebaSensorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PruebaSensorServiceImpl implements PruebaSensorService {

    @Autowired
    private PruebaSensorRepository pruebaSensorRepository;

    @Override
    public List<PruebaSensorDto> findAll() {
        List<PruebaSensor> pruebaSensorList = pruebaSensorRepository.findAll();
        List<PruebaSensorDto> dtos = new ArrayList<>();

        for (PruebaSensor item: pruebaSensorList) {
            PruebaSensorDto dto = new PruebaSensorDto();
            dto.setId(item.getId());
            dto.setMedida(item.getMedida());
//            dto.setIdHumedad(item.getIdHumedad());
//            dto.setIdTemperatura(item.getIdTemperatura());
//            dto.setFecha(item.getFecha());
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public void saveData(String saveData) {
        PruebaSensor sensor = new PruebaSensor();
        sensor.setId(1l);
        sensor.setSensor("Sensorcito");
        sensor.setMedida(500l);
        System.out.println("Vamos a guardar en datos: "+sensor.toString());

//        pruebaSensorRepository.save(sensor);
    }


}
